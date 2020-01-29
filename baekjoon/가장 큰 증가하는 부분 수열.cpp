#include<iostream>
using namespace std;
long long d[1001];
long long a[1001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) {
		d[i] = a[i];//d[i]에 수열의 값 a[i]를 집어넣는다
		for (int j = 1; j < i; j++) {// j < i
			if (a[j] < a[i] && d[i] < d[j] + a[i])//a[j] > a[i]이어야 하며, d[i]의 최대값을 구한다
				d[i] = d[j] + a[i];
		}
	}

	long long ans = 0;
	for (int i = 1; i <= n; i++) {
		if (ans < d[i])
			ans = d[i];
	}

	cout << ans << endl;
	return 0;
}