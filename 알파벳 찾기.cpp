#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;

	for (int i = 'a'; i <= 'z'; i++) {
		auto pos = find(s.begin(), s.end(), i);//s.begin()부터 s.end()까지 i가 나오는 제일 처음의 주소값을 찾아줌 없으면 last반환
		if (pos == s.end()) {
			cout << -1 << ' ';
		}
		else
			cout << (pos-s.begin()) << ' ';
	}
	cout << endl;
	return 0;
}