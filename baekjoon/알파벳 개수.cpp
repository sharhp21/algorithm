#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;

	for (int i = 'a'; i <= 'z'; i++) {
		cout << count(s.begin(), s.end(), i) << ' ';//s.begin()���� s.endl()���� i�� ����������� ���ִ� �Լ�
	}

	cout << endl;

	return 0;
}