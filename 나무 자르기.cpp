#include<iostream>
#include<vector>
using namespace std;
int n;
long long m;

bool check(vector<long long> &a, long long h) {
	long long cnt = 0;
	for (int i = 0; i < n; i++) {
		if (a[i] > h) {
			cnt += a[i] - h;
		}
	}
	return cnt >= m;
}

int main() {
	cin >> n >> m;
	vector<long long> a(n);
	long long max = 0;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		if (max < a[i] && a[i] <= 1000000000) {
			max = a[i];
		}
	}
	long long ans = 0;
	long long left = 0;
	long long right = max;
	while (left <= right) {
		int mid = (left + right) / 2;
		if (check(a, mid)) {
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