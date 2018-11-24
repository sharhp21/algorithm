#include<iostream>
using namespace std;
//2차 다이나믹
/*long long d[201][201];
long long mod = 1000000000;

int main() {
	int n, k;
	cin >> n >> k;
	
	d[0][0] = 1LL;//d[0]은 1로 정해주면 다이나믹 프로그래밍의 풀이가 간단해짐
	for (int i = 1; i <= k; i++) {//k를 1부터 증가(항의 개수)
		for (int j = 0; j <= n; j++) {//j를 0부터 증가
			for (int l = 0; l <= j; l++) {//맨 마지막 항의 숫자는 0부터 j까지
				d[i][j] += d[i - 1][j - l];//맨 마지막 항의 숫자에 따라 직전항까지의 경우의 수가 모두 달라지므로 다 합침
				d[i][j] %= mod;
			}
		}
	}
	cout << d[k][n] << endl;
	return 0;
}*/

//1차 다이나믹
long long d[201];
long long mod = 1000000000;

int main() {
	int n, k;
	cin >> n >> k;

	d[0] = 1;

	for (int i = 1; i <= k; i++) {
		for (int j = n; j >= 0; j--) {
			for (int l = 1; l <= j; l++) {
				d[j] += d[j - l];
				d[j] %= mod;
			}
		}
	}
	cout << d[n] << endl;
	return 0;
}