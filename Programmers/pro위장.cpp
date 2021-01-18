#include<string>
#include<vector>
#include<cstring>
#include<iostream>
#include<map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer =1;
    int cnt = 1;
    vector<int> all;
    while(clothes.size() > 0) {
        for(int j=1; j<clothes.size(); j++) {
            if(clothes[0][1]== clothes[j][1]) {
                cnt++;
                clothes.erase(clothes.begin() + j);
                j--;
            }
        }
        all.push_back(cnt);
        cnt = 1;
        clothes.erase(clothes.begin());
    }
    
    for(int z=0; z<all.size(); z++) 
        answer = answer * (all[z] + 1);
    return answer-1;
}