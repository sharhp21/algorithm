#include<iostream>
using namespace std;
long long d[101][10];
long long mod = 1000000000;

int main() {
	int n;
	cin >> n;
	long long ans = 0;
	for (int i = 1; i <= 9; i++)
		d[1][i] = 1;//길이가 1일때는 개수가 각 하나 밖에 없다
	for (int i = 2; i <= n; i++) {//길이가 2일때부터 n일때 까지
		for (int j = 0; j <= 9; j++) {//마지막 숫자가 0일때 부터 9일때 까지
			if (j == 0) d[i][j] = d[i - 1][j + 1];//j가 0이면 바로 전 숫자는 1일 수 밖에
			else if (j == 9) d[i][j] = d[i - 1][j - 1];//j가 9면 바로 전 숫자는 8일 수 밖에
			else d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];//그외에는 -1, +1 두가지 경우의 수
			d[i][j] %= mod;
		}
	}
	for (int i = 0; i <= 9; i++)
		ans += d[n][i];
	ans %= mod;
	cout << ans << endl;
	return 0;
}