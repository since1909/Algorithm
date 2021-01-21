#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    
    for(int i = 0; i< strings.size()-1; i++)
    {
        for(int j = 0; j < strings.size()-i-1; j++)
        {
            int a = strings[j][n];
            int b = strings[j+1][n];
            if(a > b){
                strings[j].swap(strings[j+1]);
            }
            else if(a == b){
                if(strings[j] > strings[j+1])
                    strings[j].swap(strings[j+1]);
            }
        }
    }
    answer = strings;
    return answer;
}