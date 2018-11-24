#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;
	getline(cin, s); // s를 한줄을 받아옴

	for (char x : s) { //x는 문자열 s의 첫문자부터 끝문자까지의 값을 차례대로 받음
		if ((x >= 'a' && x <= 'm') || (x >= 'A' && x <= 'M'))
			x = x + 13;
		else if ((x >= 'n' && x <= 'z') || (x >= 'N' && x <= 'Z'))
			x = x - 13;
		cout << x;
	}
	cout << endl;
	return 0;
}