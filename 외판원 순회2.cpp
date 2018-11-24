#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int w[10][10];

int main() {
	int n;
	cin >> n;
	vector<int> d(n);
	for (int i = 0; i < n; i++) {
		d[i] = i;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> w[i][j];
		}
	}
	int ans = 10000000;
	do {
		bool ok = true;
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			if (w[d[i]][d[i + 1]] == 0) ok = false;
			else sum += w[d[i]][d[i + 1]];
		}
		if (ok && w[d[n - 1]][d[0]] != 0) {
			sum += w[d[n - 1]][d[0]];
			if (ans > sum) ans = sum;
		}
	} while (next_permutation(d.begin() + 1, d.end()));
	cout << ans << '\n';
	return 0;
}