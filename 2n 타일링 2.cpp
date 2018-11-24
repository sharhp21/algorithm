#include<iostream>
using namespace std;
int d[1001];

int tile(int n) {
	if (n <= 1) return 1;
	else {
		if (d[n] > 0) return d[n];
		d[n] = tile(n - 1) + 2 * tile(n - 2);
		d[n] %= 10007;
		return d[n];
	}
}

int main() {
	int n;
	cin >> n;
	cout << tile(n) << endl;
}