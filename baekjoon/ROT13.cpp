#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;
	getline(cin, s); // s�� ������ �޾ƿ�

	for (char x : s) { //x�� ���ڿ� s�� ù���ں��� �����ڱ����� ���� ���ʴ�� ����
		if ((x >= 'a' && x <= 'm') || (x >= 'A' && x <= 'M'))
			x = x + 13;
		else if ((x >= 'n' && x <= 'z') || (x >= 'N' && x <= 'Z'))
			x = x - 13;
		cout << x;
	}
	cout << endl;
	return 0;
}