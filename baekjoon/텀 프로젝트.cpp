#include<iostream>
using namespace std;
int a[100001];
int d[100001];
int s[100001];
int n;
int dfs(int x, int cnt, int &step) {//step은 한번 방문했던 정점이 가르키는값을 모두 s[x]에 저장하고 다른 정점에서 시작하는 이어지지 않는 간선이 있을 때 그것을 구별하기 위한 파라미터
	while (true) {
		if (d[x] != 0) {
			if (step != s[x]) {
				return 0;//이어지지 않는 간선이면 사이클이 아니므로 순환사이클이 존재하지 않으므로 0반환
			}
			return cnt - d[x];//이어진 간선이면 사이클이 존재 cnt에서 d[x]를 빼준값은 사이클에 속한 정점의 개수
		}
		d[x] = cnt;
		s[x] = step;//step의 값을 이어진 간선이 존재하는 모든 정점에 저장
		x = a[x];
		cnt += 1;
	}
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			d[i] = 0;
			s[i] = 0;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] == 0) {
				ans += dfs(i, 1, i);//사이클에 속한 정점의 개수를 계속 합해준다
			}
		}
		cout << n - ans << endl;//전체 정점에서 사이클에 속한 정점의 개수를 빼주면 그것이 정답
	}
	return 0;
}