#include<iostream>
#include<vector>
using namespace std;
vector<int> a(10000);
int n, m;

bool check(long long x) {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		cnt += a[i] / x;
	}
	return cnt >= m;
}

int main() {
	cin >> n >> m;
	long long max = 0;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		if (max < a[i]) {
			max = a[i];
		}
	}
	long long ans = 0;
	long long left = 1;
	long long right = max;
	while (left <= right) {
		long long mid = (left + right) / 2;
		if (check(mid)) {
			if (ans < mid) {
				ans = mid;
			}
			left = mid + 1;
		}
		else right = mid - 1;
	}
	cout << ans << '\n';
	return 0;
}