#include<iostream>
#include<vector>
using namespace std;

int gcd(int a, int b) {
	while (b != 0) {
		int r = a%b;
		a = b;
		b = r;
	}
	return a;
}

int main() {
	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		vector<int> d(n);
		for (int i = 0; i < n; i++)
			cin >> d[i];
		long long sum = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				sum += gcd(d[i], d[j]);
			}
		cout << sum << endl;
	}

	return 0;
}