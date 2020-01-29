#include<iostream>
#include<queue>
#include<vector>
using namespace std;
vector<int> a[100001];
int depth[100001];
int parent[100001];
bool check[100001];

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		int u, v, w;
		cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}
	queue<int> q;
	depth[1] = 0;
	check[1] = true;
	parent[1] = 0;
	q.push(1);
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int y : a[x]) {
			if (!check[y]) {
				check[y] = true;
				depth[y] = depth[x] + 1;
				parent[y] = x;
				q.push(y);
			}
		}
	}
	for (int i = 2; i <= n; i++) {
		cout << parent[i] << '\n';
	}
	return 0;
}