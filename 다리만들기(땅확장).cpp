#include<iostream>
#include<queue>
using namespace std;
int a[100][100];
int group[100][100];
int dist[100][100];
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			group[i][j] = 0;
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j] == 1 && group[i][j] == 0) {
				queue<pair<int, int>> q;
				q.push(make_pair(i, j));
				group[i][j] = ++cnt;
				while (!q.empty()) {
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (0 <= nx && nx < n && 0 <= ny && ny < n) {
							if (a[nx][ny] == 1 && group[nx][ny] == 0) {
								q.push(make_pair(nx, ny));
								group[nx][ny] = cnt;
							}
						}
					}
				}
			}
		}
	}
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			dist[i][j] = -1;
			if (group[i][j] != 0) {
				dist[i][j] = 0;
				q.push(make_pair(i, j));
			}
		}
	}
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (dist[nx][ny] == -1) {
					q.push(make_pair(nx, ny));
					group[nx][ny] = group[x][y];
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
		}
	}
	int ans = -1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];
				if (0 <= x && x < n && 0 <= y && y < n) {
					if (group[i][j] != group[x][y]) {
						if (ans == -1 || dist[i][j] + dist[x][y] < ans) {
							ans = dist[i][j] + dist[x][y];
						}
					}
				}
			}
		}
	}
	cout << ans << endl;
	return 0;
}