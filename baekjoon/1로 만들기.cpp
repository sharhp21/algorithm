#include<iostream>
using namespace std;
int d[1000000];

//Top-down���

/*int go(int n) {
	if (n == 1) return 0;
	if (d[n] > 0) return d[n];//memoization
	d[n] = go(n-1) + 1;//n���� 1�� �� ��� ���� Ƚ�� : go(n-1)+1
	if (n % 3 == 0) {
		int temp = go(n / 3) + 1;
		if (d[n] > temp) d[n] = temp;//3���� ��������µ� �� ����Ƚ���� 1�� �� ��캸�� ������ �װ��� �ּҿ��� Ƚ��
	}
	if (n % 2 == 0){
		int temp = go(n / 2) + 1;
		if (d[n] > temp) d[n] = temp;//2�� �������ٶ��� 3���� �������ٶ����� ����Ƚ���� ������ �װ��� �ּҿ���
	}
	return d[n];
}*/

//Bottom_up���

int go(int n) {
	d[1] = 0;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0 && d[i] > d[i / 2] + 1)
			d[i] = d[i / 2] + 1;
		if (i % 3 == 0 && d[i] > d[i / 3] + 1)
			d[i] = d[i / 3] + 1;
	}
	return d[n];
}

int main() {
	int n;
	cin >> n;
	cout << go(n) << endl;
}