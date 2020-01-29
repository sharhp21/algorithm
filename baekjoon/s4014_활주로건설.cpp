#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N, X;
		int ans = 0;
		cin >> N >> X;
		vector<vector<int>> up_down;
		int **height = new int *[N];
		int **height_sort = new int *[2 * N];
		for (int i = 0; i < N; i++) 
			height[i] = new int[N];
		for (int i = 0; i < 2 * N; i++)
			height_sort[i] = new int[N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				cin >> height[i][j];
				height_sort[i][j] = height[i][j];
			}
		for (int i = N; i < 2 * N; i++) {
			for (int j = 0; j < N; j++) {
				height_sort[i][j] = height[j][i - N];
			}
		}

		for (int i = 0; i < 2 * N; i++) {
			int cnt = 0;
			for (int j = 0; j < N - 1; j++) {
				if (abs(height_sort[i][j] - height_sort[i][j + 1]) >= 2) {
					cnt += 10000;
					break;
				}
			}
			for (int j = 0; j < N - 1; j++) {
				if (height_sort[i][j] + 1 == height_sort[i][j + 1]) {
					up_down.push_back({ j, 1 });
				}
				if (height_sort[i][j] - 1 == height_sort[i][j + 1]) {
					up_down.push_back({ j, -1 });
				}
			}
			/*cout << i << endl;
			for (int k = 0; k < up_down.size(); k++) {
				cout << up_down.at(k)[0] << ' ' << up_down.at(k)[1] << endl;
			}*/
			for (int k = 0; k < up_down.size(); k++) {
				if (k == 0 && up_down.at(k)[1] == 1 && up_down.at(k)[0] >= X - 1) {
					cnt++;
				}
				if (k != 0 && up_down.at(k)[1] == 1 && up_down.at(k - 1)[1] == 1 && up_down.at(k)[0] - up_down.at(k - 1)[0] >= X) {
					cnt++;
				}
				if (k != 0 && up_down.at(k)[1] == 1 && up_down.at(k - 1)[1] == -1 && up_down.at(k)[0] - up_down.at(k - 1)[0] >= 2 * X) {
					cnt++;
				}
				if (k == up_down.size() - 1 && up_down.at(k)[1] == -1 && N - up_down.at(k)[0] >= X + 1) {
					cnt++;
				}
				if (k != up_down.size() - 1 && up_down.at(k)[1] == -1 && up_down.at(k + 1)[1] == -1 && up_down.at(k + 1)[0] - up_down.at(k)[0] >= X) {
					cnt++;
				}
				if (k != up_down.size() - 1 && up_down.at(k)[1] == -1 && up_down.at(k + 1)[1] == 1 && up_down.at(k + 1)[0] - up_down.at(k)[0] >= 2 * X) {
					cnt++;
				}
			}
			
			//if (up_down.size() == 0) ans++;
			if (cnt == up_down.size()) ans++;

			up_down.clear();
			
		}
		cout << '#' << test_case << ' ' << ans << endl;
	}
	return 0;
}