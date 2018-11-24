#include<iostream>
using namespace std;
long long d[101][10];
long long mod = 1000000000;

int main() {
	int n;
	cin >> n;
	long long ans = 0;
	for (int i = 1; i <= 9; i++)
		d[1][i] = 1;//���̰� 1�϶��� ������ �� �ϳ� �ۿ� ����
	for (int i = 2; i <= n; i++) {//���̰� 2�϶����� n�϶� ����
		for (int j = 0; j <= 9; j++) {//������ ���ڰ� 0�϶� ���� 9�϶� ����
			if (j == 0) d[i][j] = d[i - 1][j + 1];//j�� 0�̸� �ٷ� �� ���ڴ� 1�� �� �ۿ�
			else if (j == 9) d[i][j] = d[i - 1][j - 1];//j�� 9�� �ٷ� �� ���ڴ� 8�� �� �ۿ�
			else d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];//�׿ܿ��� -1, +1 �ΰ��� ����� ��
			d[i][j] %= mod;
		}
	}
	for (int i = 0; i <= 9; i++)
		ans += d[n][i];
	ans %= mod;
	cout << ans << endl;
	return 0;
}