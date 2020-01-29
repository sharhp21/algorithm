#include<iostream>
using namespace std;
bool broken[10];
int a[6];
int possible(int c){
	if (c == 0) {
		if (broken[0]) return 0;
		else return 1;
	}
	int len = 0;
	while (c > 0) {
		if (broken[c % 10]) return 0;
		len += 1;
		c /= 10;
	}
	return len;
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		broken[x] = true;
	}
	int ans = 0;
	ans = abs(100 - n);
	for (int i = 0; i <= 1000000; i++) {
		int c = i;
		int len = possible(c);
		if (len > 0) {
			int press = abs(c - n);
			if (ans > len + press) {
				ans = len + press;
			}
		}
	}
	cout << ans << '\n';
	return 0;
}