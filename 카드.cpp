#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<long long> a(n);

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	sort(a.begin(), a.end());

	long long ans = a[0];
	int cnt = 1;
	int count = 1;

	for (int i = 0; i < n - 1; i++) {
		if (a[i] == a[i + 1])
			cnt += 1;
		else cnt = 1;
		if (count < cnt) {
			count = cnt;
			ans = a[i];
		}
	}


	cout << ans << endl;
	return 0;
}