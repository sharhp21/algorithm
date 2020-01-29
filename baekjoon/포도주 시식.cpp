#include<iostream>
#define max(a,b) (((a)>(b)) ? (a) : (b))
using namespace std;
//2�� ���̳���
/*long long d[10001][3];
long long a[10001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	d[0][0] = d[0][1] = d[0][2] = 0;

	for (int i = 1; i <= n; i++) {
		d[i][0] = max(d[i - 1][0], max(d[i - 1][1], d[i - 1][2]));
		d[i][1] = d[i - 1][0] + a[i];
		d[i][2] = d[i - 1][1] + a[i];
	}

	long long ans;
	ans = max(d[n][0], max(d[n][1], d[n][2]));
	cout << ans << endl;

	return 0;
}*/

//1�� ���̳���
long long d[10001];
long long a[10001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	d[0] = 0;
	d[1] = a[1];//������ ���� 1���϶� 1�� ���Ӹ��ô°� �ִ�
	d[2] = a[1] + a[2];//������ ���� 2���϶� 2�� ���Ӹ��ô°� �ִ�

	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 1];//i��°�� 0������ ���̸� i-1��°���� �ִ�� ���ž�� ����
		if (d[i] < d[i - 2] + a[i]) {
			d[i] = d[i - 2] + a[i];//i��°�� 1������ ���̸� i-2��°���� �ִ�� ���ž� + i���� �� / i-1��°���� 0��������
		}
		if (d[i] < d[i - 3] + a[i] + a[i - 1]) {
			d[i] = d[i - 3] + a[i] + a[i - 1];//i��°�� 2������ ���̸� i-3��°���� �ִ�� ���ž� + i���� �� + i-1���� �� / i-2��°���� 1��������
		}
	}

	cout << d[n] << endl;

	return 0;
}