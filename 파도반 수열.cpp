#include<iostream>
using namespace std;
long long p[101];

int main() {
	int t;
	cin >> t;
	while (t--) {
		int  n;
		cin >> n;

		p[1] = p[2] = p[3] = 1;
		for (int i = 4; i <= n; i++) {
			p[i] = p[i - 2] + p[i - 3];//2번째전과 3번째전 수열의 합
		}

		cout << p[n] << endl;
	}
	return 0;
}