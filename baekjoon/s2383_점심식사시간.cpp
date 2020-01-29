#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

int dist(int a, int b, int c, int d) {
	return abs(a - c) + abs(b - d);
}

int main() {
	int T;
	cin >> T;
	int test_case = T;

	while (T--) {
		int N;
		int time = 0;
		int ans = 0;
		int cnt[2][201];//계단번호, time
		vector<vector<int>> stairs;//계단좌표
		vector<vector<int>> people;//사람좌표
		vector<int> distance_first;//첫번째 계단 걸리는 시간
		vector<int> distance_second;//두번째 계단 걸리는 시간
		vector<int> bit_first;
		vector<int> bit_second;
		cin >> N;

		int **map = new int *[N];
		for (int i = 0; i < N; i++)
			map[i] = new int[N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1)
					people.push_back({ i, j });
				if (map[i][j] > 1) {
					stairs.push_back({ i, j });
				}
			}

		for (int i = 0; i < people.size(); i++) {
			distance_first.push_back(dist(people.at(i)[0], people.at(i)[1], stairs.at(0)[0], stairs.at(0)[1]));
			distance_second.push_back(dist(people.at(i)[0], people.at(i)[1], stairs.at(1)[0], stairs.at(1)[1]));
		}

		for (int i = 0; i < (int)pow(2, people.size()); i++) {

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 201; j++) {
					cnt[i][j] = 0;
				}
			}

			int temp = (int)pow(2, people.size() - 1);
			for (int j = (int)pow(2, people.size() - 1); j >= 1; j = j / 2) {
				bit_first.push_back(i / j);
				temp -= i;
				bit_second.push_back(((int)pow(2, people.size() - 1) - j) / j);
			}

			for (int i = 0; i < bit_first.size(); i++) {
				cout << bit_first.at(i) << ' ';
			}
			cout << endl;

			for (int j = 0; j < people.size(); j++) {
				if (bit_first.at(j) == 1) {
					cnt[0][distance_first.at(j)]++;
				}
				if (bit_second.at(j) == 1) {
					cnt[1][distance_second.at(j)]++;
				}
			}
			/*for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 5; k++) {
					cout << cnt[j][k] << ' ';
				}
				cout << endl;
			}*/
			int tmp = 0;
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 201; k++) {
					if (cnt[j][k] > 0) {
						time++;
						time += cnt[j][k];
						if (cnt[j][k] >= 4) {
							time += cnt[j][k] - 3;
						}
						time += k;
					}
				}
				tmp = time;
			}
			if (tmp > time) time = tmp;
			bit_first.clear();
			bit_second.clear();
		}
		stairs.clear();
		people.clear();
		distance_first.clear();
		distance_second.clear();
		cout << '#' << test_case - T << ' ' << time << endl;
	}
	return 0;
}