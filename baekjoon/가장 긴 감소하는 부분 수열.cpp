#include<iostream>
using namespace std;
int d[1001];
int a[1001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = n; i >= 1; i--) {
		d[i] = 1;
		for (int j = i + 1; j <= n; j++) {
			if (a[i] > a[j] && d[i] < d[j] + 1)
				d[i] = d[j] + 1;
		}
	}
	long long ans = 0;
	for (int i = n; i >= 1; i--) {
		if (ans < d[i])
			ans = d[i];
	}

	cout << ans << endl;
	return 0;
}