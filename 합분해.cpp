#include<iostream>
using namespace std;
//2�� ���̳���
/*long long d[201][201];
long long mod = 1000000000;

int main() {
	int n, k;
	cin >> n >> k;
	
	d[0][0] = 1LL;//d[0]�� 1�� �����ָ� ���̳��� ���α׷����� Ǯ�̰� ��������
	for (int i = 1; i <= k; i++) {//k�� 1���� ����(���� ����)
		for (int j = 0; j <= n; j++) {//j�� 0���� ����
			for (int l = 0; l <= j; l++) {//�� ������ ���� ���ڴ� 0���� j����
				d[i][j] += d[i - 1][j - l];//�� ������ ���� ���ڿ� ���� �����ױ����� ����� ���� ��� �޶����Ƿ� �� ��ħ
				d[i][j] %= mod;
			}
		}
	}
	cout << d[k][n] << endl;
	return 0;
}*/

//1�� ���̳���
long long d[201];
long long mod = 1000000000;

int main() {
	int n, k;
	cin >> n >> k;

	d[0] = 1;

	for (int i = 1; i <= k; i++) {
		for (int j = n; j >= 0; j--) {
			for (int l = 1; l <= j; l++) {
				d[j] += d[j - l];
				d[j] %= mod;
			}
		}
	}
	cout << d[n] << endl;
	return 0;
}