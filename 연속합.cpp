#include<iostream>
#include<vector>
#define max(a,b) (((a) < (b) ? (b) : (a)))
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> d(n+1);
	vector<int> a(n+1);
	for (int i = 1; i <= n; i++)
		cin >> a[i];

	for (int i = 1; i <= n; i++) {
		d[i] = a[i];//d[i]에 수열값 저장
		if (i == 1) continue;
		d[i] = max(d[i - 1] + a[i], a[i]);//연속되어져 온것, 시작하는것 중에 큰것 선택
	}

	long long ans = d[1];//d[i]가 음수일 수도 있으므로
	for (int i = 2; i <= n; i++) {
		if (ans < d[i])
			ans = d[i];
	}
	cout << ans << endl;
	return 0;
}
