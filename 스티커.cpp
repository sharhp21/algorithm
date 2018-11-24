#include<iostream>
#include<algorithm>
using namespace std;
long long d[100001][3];
long long a[100001][2];

int main() {
	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++)
			cin >> a[i][0];//첫번째 행의 점수
		for (int i = 1; i <= n; i++)
			cin >> a[i][1];//두번째 행 스티커의 점수

		d[0][0] = d[0][1] = d[0][2] = 0; //0번째 열에서 점수는 0

		for (int i = 1; i <= n; i++) {//열로 봤을때 0 : 안뜯은것, 1 : 위에만 뜯은것, 2 : 아래만 뜯은것
			d[i][0] = max(d[i - 1][0], max(d[i - 1][1], d[i - 1][2]));//n번째열이 0일 경우 n-1열의 0,1,2중에 큰거
			d[i][1] = max(d[i - 1][0], d[i - 1][2]) + a[i][0];//n번째열이 1일 경우 n-1열의 0,2중에 큰거
			d[i][2] = max(d[i - 1][0], d[i - 1][1]) + a[i][1];//n번째열이 2일 경우 n-1열의 0,1중에 큰거
		}

		long long ans = 0;
		ans = max(d[n][0], max(d[n][1], d[n][2]));//n번째 열의 0,1,2중에 가장 큰 점수값

		cout << ans << endl;
	}
	return 0;
}