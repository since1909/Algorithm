#include <string>
#include <iostream>
using namespace std;
int countP = 0;
int countY = 0;
bool solution(string s)
{
    bool answer = true;

    for(int i = 0 ; i < s.size(); i++)
    {
        if(s[i] == 80 || s[i] == 112)
            countP++;
        if(s[i] == 89 || s[i] == 121)
            countY++;
    }
    
    if(countP != countY)
        answer = false;
    return answer;
}