#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int col, row;
    for(int i = 1;i <= red; i++){
        if(red % i == 0) { 
            col = i; 
            row = red / i;
            
            if((((col + 2) * 2) + ((row + 2) * 2)) - 4 == brown){
                answer.push_back(row+2);
                answer.push_back(col+2);
                break;
            }
        }
    }
    return answer;
}