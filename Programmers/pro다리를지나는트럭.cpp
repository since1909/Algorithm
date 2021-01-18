#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
   int answer = 0;
	int time = 0;
	int i = 0; int sum = 0;
	vector<int> timer;
	queue<int> bridge;
	do {
		if (i != 0) {
			if (timer[0] == bridge_length) {
				sum -= bridge.front();
				bridge.pop();
				timer.erase(timer.begin());
			}
		}
		if (i < truck_weights.size() && sum + truck_weights[i] <= weight) {
			bridge.push(truck_weights[i]);
			timer.push_back(0);
			sum += truck_weights[i];
			i++;
		}
 		for (int k = 0; k < timer.size(); k++)
			timer[k]++;
		time++;
	} while (!bridge.empty());

	answer = time;
	return answer;
}