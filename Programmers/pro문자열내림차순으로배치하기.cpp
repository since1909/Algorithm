#include <string>
#include <vector>
#include <algorithm>
#include <functional>


using namespace std;
string solution(string s) {
    string answer = "";
    sort(s.begin(), s.end(), greater<int>());
    answer = s;
    return answer;
}