#include<iostream>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
struct Edge {
	int to;
	int cost;
	Edge(int to, int cost) : to(to), cost(cost) {
	}
};
const int MAX = 100001;
vector<Edge> a[MAX];
bool check[MAX];
int dist[MAX];

void bfs(int start) {
	memset(dist, 0, sizeof(dist));
	memset(check, false, sizeof(check));
	queue<int> q;
	check[start] = true;
	q.push(start);
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < a[x].size(); i++) {
			Edge &e = a[x][i];
			if (check[e.to] == false) {
				dist[e.to] = dist[x] + e.cost;
				q.push(e.to);
				check[e.to] = true;
			}
		}
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int x;
		cin >> x;
		while (true) {
			int y, z;
			cin >> y;
			if (y == -1) break;
			cin >> z;
			a[x].push_back(Edge(y, z));
		}
	}
	bfs(1);
	int start = 1;
	for (int i = 2; i <= n; i++) {
		if (dist[i] > dist[start]) {
			start = i;
		}
	}
	bfs(start);
	int ans = dist[1];
	for (int i = 2; i <= n; i++) {
		if (ans < dist[i]) {
			ans = dist[i];
		}
	}
	cout << ans << endl;
	return 0;
}
