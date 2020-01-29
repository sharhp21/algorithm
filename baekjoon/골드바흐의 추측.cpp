#include<iostream>
#include<string>
using namespace std;
#define MAX 1000000
bool check[MAX + 1];
int p[MAX];

int main() {
	int pn = 0;
	check[0] = check[1] = true;
	for (int i = 2; i <= MAX; i++) {
		if (check[i] == false) {
			p[pn++] = i;
			for (int j = i * 2; j <= MAX; j += i) {
				check[j] = true;
			}
		}
	}
	while (true) {
		int n;
		cin >> n;
		if (n == 0)
			break;
		for (int i = 1; i < pn; i++) {
			if (check[n - p[i]] == false) {//n���� p[i]�� ���ָ� �Ҽ��̱� ������ �������� ���� ���� ã�´�
				cout << n << " = " << p[i] << " + " << n - p[i] << endl;
				break;
			}
		}
	}
	return 0;
}