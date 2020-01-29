#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;

	for (int i = 'a'; i <= 'z'; i++) {
		cout << count(s.begin(), s.end(), i) << ' ';//s.begin()부터 s.endl()까지 i가 몇번나오는지 세주는 함수
	}

	cout << endl;

	return 0;
}