#include<iostream>
using namespace std;

int main() {
	int n, m, k;
	cin >> n >> m >> k;
	int ans = 0;
	while (true) {
		if (n + m - k >= 3) {
			if (n >= 2 && m >= 1) {
				ans += 1;
				n -= 2;
				m -= 1;
			}
			else break;
		}
		else break;
	}
	cout << ans << endl;
	return 0;
}