#include<iostream>
#include<queue>
using namespace std;
int a[1000][1000];
int d[1000][1000];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int n, m;

int main() {
	cin >> m >> n;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			d[i][j] = -1;
			if (a[i][j] == 1) {
				q.push(make_pair(i, j));
				d[i][j] = 0;
			}
		}
	}
	while (!q.empty()) {
		int x = q.front().first; 
		int y = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k]; int ny = y + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (a[nx][ny] == 0 && d[nx][ny] == -1) {
					q.push(make_pair(nx, ny));
					d[nx][ny] = d[x][y] + 1;
				}
			}
		}
	}
	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (ans < d[i][j])
				ans = d[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0 && d[i][j] == -1)
				ans = -1;
		}
	}
	cout << ans << endl;
	return 0;
}