#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int ans = 0;

	for(int i = 5; i<=n; i+=5) {
		ans += 1;
	}
	for (int i = 25; i <= n; i += 25) {
		ans += 1;
	}
	for (int i = 125; i <= n; i += 125) {
		ans += 1;
	}

	cout << ans << endl;
	return 0;
}