#include<iostream>
using namespace std;
#define MAX 1000000
bool c[MAX + 1];

int main() {
	c[0] = c[1] = true;//0,1 은 지운다
	for (int i = 2; i*i <= MAX; i++) {//2부터 루트MAX까지 지워졌는지 검사
		if (c[i] == false) {//안 지워졌으면
			for (int j = i + i; j <= MAX; j += i) {//i의 두배부터 j의 i배수를 차례차례 지워준다
				c[j] = true;//지운다
			}
		}
	}
	int m, n;
	cin >> m >> n;

	for (int i = 1; i <= n; i++) {
		if(c[i] == false)//지워지지 않았을때
			cout << i << endl;
	}
	return 0;
}