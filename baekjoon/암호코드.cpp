#include<iostream>
#include<string>
using namespace std;
int d[5001];
int mod = 1000000;

int main() {
	string s;
	cin >> s;
	int n = s.size();//s�� ũ�⸦ n�̶� �Ѵ�
	s = " " + s;//s[0]���� s[4]������ s[1]���� s[5]�� ��ĭ�� �о���

	d[0] = 1;
	for (int i = 1; i <= n; i++) {
		int x = s[i] - '0';//���ڸ� ���ڷ� �ٲ���
		if (x >= 1 && x <= 9) {
			d[i] += d[i - 1];//i-1���� �ؼ����� �� ���� ���� +
			d[i] %= mod;
		}
		if (i == 1) continue;//i�� 1�̸� ���
		if (s[i - 1] == '0') continue;//i-1�� �ڸ��� 0�̸� ���
		x = (s[i - 1] - '0') * 10 + (s[i] - '0');
		if (10 <= x && x <= 26) {
			d[i] += d[i - 2];//i-2���� �ؼ����� �� ���� ���� +
			d[i] %= mod;
		}
	}

	cout << d[n] << endl;
	return 0;
}
