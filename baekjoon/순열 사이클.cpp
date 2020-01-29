#include<iostream>
using namespace std;
int a[1001];
bool c[1001];

void dfs(int node) {
	while (c[node] == false) {
		c[node] = true;
		node = a[node];
	}
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			c[i] = false;
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (c[i] == false) {
				dfs(i);
				cnt += 1;
			}
		}
		cout << cnt << endl;
	}
	return 0;
}