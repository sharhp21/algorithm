#include<iostream>
using namespace std;
long long d[1001];
long long a[1001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) {
		d[i] = 1;//a[i]�� ������ ���ԵǾ�� �ϹǷ� ���̴� 1���� ����
		for (int j = 1; j < i; j++) {//j < i
			if (a[j] < a[i] && d[i] < d[j] + 1)// a[j] < a[i] �̰�, d[j]+1�߿� ���� ū ���� return
				d[i] = d[j] + 1;//�����̹Ƿ� 1�� �����ش�
		}
	}
	long long ans = 0;
	for (int i = 1; i <= n; i++) {//d[n]�� a[n]�� ������ ���ԵǾ��ִ� ���̹Ƿ� ��� d[n]�߿� �ִ밪�� ���Ѵ�
		if (ans < d[i])
			ans = d[i];
	}

	cout << ans << endl;
}