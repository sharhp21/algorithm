#include<iostream>
#include<vector>
using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> d(n + 1);

	for (int i = 1; i <= n; i++) {
		d[i] = i;//1의 제곱을 더한것이 항의 개수의 최대값
		for (int j = 1; j*j <= i; j++) {
			if (d[i] > d[i - j*j] + 1)//제일작은 d[i-j*j]+1을 d[i]라고 한다
				d[i] = d[i - j*j] + 1;
		}
	}
	cout << d[n] << endl;
	return 0;
}
