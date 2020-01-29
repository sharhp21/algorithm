#include<iostream>
#include<string>
using namespace std;
int a[50][50];
int b[50][50];

void change(int x, int y) {
	for (int i = x; i <= x + 2; i++) {
		for (int j = y; j <= y + 2; j++) {
			a[i][j] = 1 - a[i][j];
		}
	}
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &a[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &b[i][j]);
		}
	}
	int ans = 0;
	for (int i = 0; i < n - 2; i++) {
		for (int j = 0; j < m - 2; j++) {
			if (a[i][j] != b[i][j]) {
				ans += 1;
				change(i, j);
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] != b[i][j]) {
				cout << -1 << endl;
				return 0;
			}
		}
	}
	cout << ans << endl;
	return 0;
}