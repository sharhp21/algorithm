#include<iostream>
using namespace std;

//1�� ���̳���
long long d[91];

int main() {
	int n;
	cin >> n;
	d[1] = 1;
	d[2] = 1;
	for (int i = 3; i <= n; i++)
		d[i] = d[i - 1] + d[i - 2]; //n��°�� 0�̸� n-1��°�� �Ѵ� �ü� �ְ� n��°�� 1�̸� n-��°�� 0�� �;��ϹǷ� n-2��°�� �Ѵ� �� �� �ִ�.
	cout << d[n] << endl;
	return 0;
}

//2�� ���̳���
/*long long d[91][2];

int main() {
	int n;
	cin >> n;
	long long ans = 0;

	d[1][0] = 0;
	d[1][1] = 1;
	d[2][0] = 1;
	d[2][1] = 0;

	for (int i = 3; i <= n; i++) {
		d[i][0] = d[i - 1][0] + d[i - 1][1];
		d[i][1] = d[i - 1][0];
	}

	ans = d[n][0] + d[n][1];

	cout << ans << endl;
	return 0;
}*/