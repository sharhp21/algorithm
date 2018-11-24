#include<iostream>
#include<stack>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> a[1001];
bool check[1001];
void dfs(int node) {
	stack<pair<int, int>> s;
	s.push(make_pair(node, 0));
	check[node] = true;
	cout << node << ' ';
	while (!s.empty()) {
		int node = s.top().first;
		int start = s.top().second;
		s.pop();
		for (int i = start; i < a[node].size(); i++) {
			int next = a[node][i];
			if (check[next] == false) {
				check[next] = true;
				cout << next << ' ';
				s.push(make_pair(node, i + 1));
				s.push(make_pair(next, 0));
				break;
			}
		}
	}
}
int main() {
	int n, m, start;
	cin >> n >> m >> start;
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}
	for (int i = 1; i <= n; i++) {
		sort(a[i].begin(), a[i].end());
	}
	dfs(start);
	cout << endl;
	return 0;
}