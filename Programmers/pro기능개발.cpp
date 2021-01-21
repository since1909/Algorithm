#include <vector>
#include <queue>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answer;
	queue<int> date;

	int value;
	for (int i = 0; i < progresses.size(); i++) {
		value = (100 - progresses[i]) / speeds[i];
		if ((100-progresses[i]) % speeds[i] != 0)
			value++;
		date.push(value);
	}

	int count = 0;
	int max; 
	while (!date.empty()) {
		max = date.front();
		while (max >= date.front()) {
			count++;
			date.pop();
			if (date.empty())
				break;
		}
		answer.push_back(count);
		count = 0;
	}
	return answer;
}