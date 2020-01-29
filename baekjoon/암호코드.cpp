#include<iostream>
#include<string>
using namespace std;
int d[5001];
int mod = 1000000;

int main() {
	string s;
	cin >> s;
	int n = s.size();//s의 크기를 n이라 한다
	s = " " + s;//s[0]부터 s[4]까지를 s[1]부터 s[5]로 한칸씩 밀어줌

	d[0] = 1;
	for (int i = 1; i <= n; i++) {
		int x = s[i] - '0';//문자를 숫자로 바꿔줌
		if (x >= 1 && x <= 9) {
			d[i] += d[i - 1];//i-1까지 해석했을 때 가지 수를 +
			d[i] %= mod;
		}
		if (i == 1) continue;//i가 1이면 계속
		if (s[i - 1] == '0') continue;//i-1의 자리가 0이면 계속
		x = (s[i - 1] - '0') * 10 + (s[i] - '0');
		if (10 <= x && x <= 26) {
			d[i] += d[i - 2];//i-2까지 해석했을 때 가지 수를 +
			d[i] %= mod;
		}
	}

	cout << d[n] << endl;
	return 0;
}
