#include<iostream>
using namespace std;
int d[100];

bool prime(int n) {
	if (n < 2) return false;
	for (int i = 2; i*i <= n; i++) {
		if (n % i == 0)
			return false;
	}
	return true;
}

int main() {
	int n;
	cin >> n;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		cin >> d[i];
	}
	for (int i = 0; i < n; i++) {
		if (prime(d[i]) == true)
			ans += 1;
	}
	cout << ans << endl;
	return 0;
}