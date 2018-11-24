#include<iostream>
#include<vector>
#include<string.h>
using namespace std;
#define MAX 101

int main() {
	int N;
	int x, y, d, g;
	cin >> N;
	bool plane[MAX][MAX];
	int ans = 0;
	memset(plane, false, sizeof(plane));

	vector<vector<int>> tmp_dot;

	while (N--) {
		cin >> x >> y >> d >> g;
		int mid[2] = { };
		tmp_dot.push_back({ x, y });
		switch (d) {
		case 0:
			tmp_dot.push_back({ x + 1, y });
			break;
		case 1:
			tmp_dot.push_back({ x, y - 1 });
			break;
		case 2:
			tmp_dot.push_back({ x - 1, y });
			break;
		case 3:
			tmp_dot.push_back({ x, y + 1 });
			break;
		default:
			break;
		}

		for (int i = 0; i < g; i++) {
			mid[0] = tmp_dot.back()[0];
			mid[1] = tmp_dot.back()[1];
			//cout << tmp_dot.size() << endl;
			int temp = tmp_dot.size() - 2;
			for (int j = temp; j >= 0; j--) {
				//cout << mid[0] << ' ' << mid[1] << endl;
				//if (mid[0] == tmp_dot.at(j)[0] && mid[1] == tmp_dot.at(j)[1]) continue;
				tmp_dot.push_back({ -(tmp_dot.at(j)[1] - mid[1]) + mid[0], (tmp_dot.at(j)[0] - mid[0]) + mid[1] });
			}
		}

		for (int i = 0; i < tmp_dot.size(); i++) {
			//cout << tmp_dot.at(i)[0] << ' ' << tmp_dot.at(i)[1] << endl;
			plane[tmp_dot.at(i)[0]][tmp_dot.at(i)[1]] = true;
		}

		tmp_dot.clear();
	}

	for (int i = 0; i < MAX - 1; i++) {
		for (int j = 0; j < MAX - 1; j++) {
			if (plane[i][j] == true)
				if (plane[i][j + 1] == true && plane[i + 1][j] == true && plane[i + 1][j + 1] == true)
					ans++;
		}
	}

	cout << ans << endl;
	return 0;
}