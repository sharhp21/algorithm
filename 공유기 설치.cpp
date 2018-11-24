#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, m;

bool possible(vector<int> &a, int length) {
	int cnt = 1;
	int i = 0;
	for (int j = i + 1; j < n; j++) {
		if (a[j] - a[i] >= length) {
			cnt += 1;
			i = j;
		}
	}
	return cnt >= m;
}


int main() {
	cin >> n >> m;
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a.begin(), a.end());
	int ans = 0;
	int left = 1;
	int right = a[n - 1] - a[0];
	while (left <= right) {
		int mid = (left + right) / 2;
		if (possible(a, mid)) {
			left = mid + 1;
			ans = mid;
		}
		else {
			right = mid - 1;
		}
	}
	cout << ans << '\n';
	return 0;
}