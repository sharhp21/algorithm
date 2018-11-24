#include<iostream>
using namespace std;
int d[1000000];

//Top-down방식

/*int go(int n) {
	if (n == 1) return 0;
	if (d[n] > 0) return d[n];//memoization
	d[n] = go(n-1) + 1;//n에서 1을 뺄 경우 연산 횟수 : go(n-1)+1
	if (n % 3 == 0) {
		int temp = go(n / 3) + 1;
		if (d[n] > temp) d[n] = temp;//3으로 나누어줬는데 그 연산횟수가 1을 뺄 경우보다 작으면 그것이 최소연산 횟수
	}
	if (n % 2 == 0){
		int temp = go(n / 2) + 1;
		if (d[n] > temp) d[n] = temp;//2로 나누어줄때가 3으로 나누어줄때보다 연산횟수가 작으면 그것이 최소연산
	}
	return d[n];
}*/

//Bottom_up방식

int go(int n) {
	d[1] = 0;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0 && d[i] > d[i / 2] + 1)
			d[i] = d[i / 2] + 1;
		if (i % 3 == 0 && d[i] > d[i / 3] + 1)
			d[i] = d[i / 3] + 1;
	}
	return d[n];
}

int main() {
	int n;
	cin >> n;
	cout << go(n) << endl;
}