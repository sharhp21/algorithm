#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	int ans = 0;
	vector<pair<int, int>> a(n+1);
	for (int i = 1; i <= n; i++) {
		cin >> a[i].first;
		a[i].second = i;
	}
	sort(a.begin(), a.end());
	for (int i = 1; i <= n; i++) {
		if (ans < a[i].second - i) {
			ans = a[i].second - i;
		}
	}
	cout << ans+1 << endl;
	return 0;
}