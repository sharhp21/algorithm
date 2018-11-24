#include<iostream>
using namespace std;

//1차 다이나믹
long long d[91];

int main() {
	int n;
	cin >> n;
	d[1] = 1;
	d[2] = 1;
	for (int i = 3; i <= n; i++)
		d[i] = d[i - 1] + d[i - 2]; //n번째가 0이면 n-1번째는 둘다 올수 있고 n번째가 1이면 n-번째는 0이 와야하므로 n-2번째에 둘다 올 수 있다.
	cout << d[n] << endl;
	return 0;
}

//2차 다이나믹
/*long long d[91][2];

int main() {
	int n;
	cin >> n;
	long long ans = 0;

	d[1][0] = 0;
	d[1][1] = 1;
	d[2][0] = 1;
	d[2][1] = 0;

	for (int i = 3; i <= n; i++) {
		d[i][0] = d[i - 1][0] + d[i - 1][1];
		d[i][1] = d[i - 1][0];
	}

	ans = d[n][0] + d[n][1];

	cout << ans << endl;
	return 0;
}*/