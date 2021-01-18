#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
        
    if(s.size()  != 4 && s.size() != 6)
        answer = false;
    
    for(string::iterator iter = s.begin(); iter != s.end(); ++iter)
    {
        char c = *iter;
        
        if(c < 48 || c > 57)
            answer = false;
    }

    return answer;
}