#include<iostream>
#include<vector>
using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> d(n + 1);

	for (int i = 1; i <= n; i++) {
		d[i] = i;//1�� ������ ���Ѱ��� ���� ������ �ִ밪
		for (int j = 1; j*j <= i; j++) {
			if (d[i] > d[i - j*j] + 1)//�������� d[i-j*j]+1�� d[i]��� �Ѵ�
				d[i] = d[i - j*j] + 1;
		}
	}
	cout << d[n] << endl;
	return 0;
}
