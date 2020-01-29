#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int a[50][50];
int d[50][50];
int dx[8] = { -1, -1, -1, 0, 1, 1, 1, 0 };
int dy[8] = { -1, 0, 1, 1, 1, 0, -1, -1 };
int n, m;

void bfs(int x, int y, int cnt) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	d[x][y] = cnt;
	while (!q.empty()) {
		x = q.front().first; y = q.front().second;
		q.pop();
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k]; int ny = y + dy[k];
			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (d[nx][ny] == 0 && a[nx][ny] == 1) {
					q.push(make_pair(nx, ny));
					d[nx][ny] = cnt;
				}
			}
		}
	}
}

int main() {
	while (true) {
		cin >> n >> m;
		if (n == 0 && m == 0)
			break;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cin >> a[i][j];
				d[i][j] = 0;
			}
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] == 0 && a[i][j] == 1)
					bfs(i, j, ++cnt);
			}
		}
		cout << cnt << endl;
	}
	return 0;
}