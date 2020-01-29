#include<iostream>
using namespace std;
#define MAX 1000000
bool c[MAX + 1];

int main() {
	c[0] = c[1] = true;//0,1 �� �����
	for (int i = 2; i*i <= MAX; i++) {//2���� ��ƮMAX���� ���������� �˻�
		if (c[i] == false) {//�� ����������
			for (int j = i + i; j <= MAX; j += i) {//i�� �ι���� j�� i����� �������� �����ش�
				c[j] = true;//�����
			}
		}
	}
	int m, n;
	cin >> m >> n;

	for (int i = 1; i <= n; i++) {
		if(c[i] == false)//�������� �ʾ�����
			cout << i << endl;
	}
	return 0;
}