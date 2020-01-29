#include<iostream>
#include<algorithm>
using namespace std;
long long d[100001][3];
long long a[100001][2];

int main() {
	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++)
			cin >> a[i][0];//ù��° ���� ����
		for (int i = 1; i <= n; i++)
			cin >> a[i][1];//�ι�° �� ��ƼĿ�� ����

		d[0][0] = d[0][1] = d[0][2] = 0; //0��° ������ ������ 0

		for (int i = 1; i <= n; i++) {//���� ������ 0 : �ȶ�����, 1 : ������ ������, 2 : �Ʒ��� ������
			d[i][0] = max(d[i - 1][0], max(d[i - 1][1], d[i - 1][2]));//n��°���� 0�� ��� n-1���� 0,1,2�߿� ū��
			d[i][1] = max(d[i - 1][0], d[i - 1][2]) + a[i][0];//n��°���� 1�� ��� n-1���� 0,2�߿� ū��
			d[i][2] = max(d[i - 1][0], d[i - 1][1]) + a[i][1];//n��°���� 2�� ��� n-1���� 0,1�߿� ū��
		}

		long long ans = 0;
		ans = max(d[n][0], max(d[n][1], d[n][2]));//n��° ���� 0,1,2�߿� ���� ū ������

		cout << ans << endl;
	}
	return 0;
}