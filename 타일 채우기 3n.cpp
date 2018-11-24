#include<iostream>
using namespace std;
int d[31];

int main() {
	int n;
	cin >> n;

	d[0] = 1;
	d[1] = 0;

	for (int i = 2; i <= n; i++) {
		d[i] = 3 * d[i - 2];//3*2에서 만들 수 있는 가지 수는 3가지
		for (int j = 4; j <= i; j+=2) {
			d[i] += 2 * d[i - j];//3*4, 6, 8, .... 만들 수 있는 가지 수는 2가지 씩
		}
	}

	cout << d[n] << endl;
	return 0;

}