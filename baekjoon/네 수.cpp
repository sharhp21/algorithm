#include<iostream>
#include<string>
using namespace std;

int main() {
	int a, b, c, d;
	cin >> a >> b >> c >> d;

	string s1 = to_string(a) + to_string(b);//to_string으로 숫자를 문자열로 바꿔준후 두 문자열을 붙힘
	string s2 = to_string(c) + to_string(d);

	long long n1 = stoll(s1);//붙힌 문자열을 long long 의 숫자로 바꿔줌
	long long n2 = stoll(s2);

	cout << n1 + n2 << endl;
	return 0;
}