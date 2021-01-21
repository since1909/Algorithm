#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 1;
   	queue<int> q;
	vector<int> prior(priorities.size());
	copy(priorities.begin(), priorities.end(), prior.begin());

	int value = priorities[location];
	int max = *max_element(priorities.begin(), priorities.end());

	for (int i = 0; i < priorities.size(); i++)
		q.push(i);

	while (value < max || q.front() != location) {
		if (priorities[q.front()] < max) {
			q.push(q.front());
			q.pop();
		}
		else {
			prior.erase(find(prior.begin(), prior.end(), max));
			max = *max_element(prior.begin(), prior.end());
			q.pop();
			answer++;
		}
	}
    return answer;
}