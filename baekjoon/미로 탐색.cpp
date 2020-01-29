#include<iostream>
#include<queue>
using namespace std;
int a[100][100];
int dist[100][100];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int n, m;

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	dist[x][y] = 1;
	while (!q.empty()) {
		x = q.front().first; y = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k]; int ny = y + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (a[nx][ny] == 1 && dist[nx][ny] == 0) {
					q.push(make_pair(nx, ny));
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &a[i][j]);
			dist[i][j] = 0;
		}
	}
	bfs(0, 0);
	cout << dist[n - 1][m - 1] << endl;
	return 0;
}