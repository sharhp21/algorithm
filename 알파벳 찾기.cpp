#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;

	for (int i = 'a'; i <= 'z'; i++) {
		auto pos = find(s.begin(), s.end(), i);//s.begin()���� s.end()���� i�� ������ ���� ó���� �ּҰ��� ã���� ������ last��ȯ
		if (pos == s.end()) {
			cout << -1 << ' ';
		}
		else
			cout << (pos-s.begin()) << ' ';
	}
	cout << endl;
	return 0;
}