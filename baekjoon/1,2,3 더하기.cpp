#include<iostream>
using namespace std;
int d[10];

int main() {
	int t;
	cin >> t;
	d[0] = 1;
	for (int i = 1; i <= 10; i++) {
		if (i >= 1)
			d[i] += d[i - 1];
		if (i >= 2)
			d[i] += d[i - 2];
		if (i >= 3)
			d[i] += d[i - 3];
	}
	while (t--) {
		int n;
		cin >> n;
		cout << d[n] << endl;
	}
}