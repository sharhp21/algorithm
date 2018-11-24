#include<iostream>
#define max(a,b) (((a)>(b)) ? (a) : (b))
using namespace std;
//2차 다이나믹
/*long long d[10001][3];
long long a[10001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	d[0][0] = d[0][1] = d[0][2] = 0;

	for (int i = 1; i <= n; i++) {
		d[i][0] = max(d[i - 1][0], max(d[i - 1][1], d[i - 1][2]));
		d[i][1] = d[i - 1][0] + a[i];
		d[i][2] = d[i - 1][1] + a[i];
	}

	long long ans;
	ans = max(d[n][0], max(d[n][1], d[n][2]));
	cout << ans << endl;

	return 0;
}*/

//1차 다이나믹
long long d[10001];
long long a[10001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	d[0] = 0;
	d[1] = a[1];//포도주 잔이 1개일땐 1번 연속마시는게 최대
	d[2] = a[1] + a[2];//포도주 잔이 2개일땐 2번 연속마시는게 최대

	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 1];//i번째가 0번연속 잔이면 i-1번째까지 최대로 마신양과 같음
		if (d[i] < d[i - 2] + a[i]) {
			d[i] = d[i - 2] + a[i];//i번째가 1번연속 잔이면 i-2번째까지 최대로 마신양 + i잔의 량 / i-1번째잔은 0번연속잔
		}
		if (d[i] < d[i - 3] + a[i] + a[i - 1]) {
			d[i] = d[i - 3] + a[i] + a[i - 1];//i번째가 2번연속 잔이면 i-3번째까지 최대로 마신양 + i잔의 량 + i-1잔의 량 / i-2번째잔은 1번연속잔
		}
	}

	cout << d[n] << endl;

	return 0;
}