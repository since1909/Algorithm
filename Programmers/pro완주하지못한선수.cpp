#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> checking;
    for(auto name : participant)
        ++checking[name];
    for(auto name : completion)
        --checking[name];
    for(auto c : checking){
        if(c.second > 0)
            answer = c.first;
    }
    
    return answer;
}