#include<iostream>
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
		int a, b;
		int lcm;
		cin >> a >> b;

		lcm = (a * b) / gcd(a, b);
		cout << lcm << endl;
	}
	return 0;
}