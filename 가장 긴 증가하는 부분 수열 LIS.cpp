#include<iostream>
using namespace std;
long long d[1001];
long long a[1001];

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) {
		d[i] = 1;//a[i]가 무조건 포함되어야 하므로 길이는 1부터 시작
		for (int j = 1; j < i; j++) {//j < i
			if (a[j] < a[i] && d[i] < d[j] + 1)// a[j] < a[i] 이고, d[j]+1중에 제일 큰 값을 return
				d[i] = d[j] + 1;//길이이므로 1을 더해준다
		}
	}
	long long ans = 0;
	for (int i = 1; i <= n; i++) {//d[n]은 a[n]이 무조건 포함되어있는 값이므로 모든 d[n]중에 최대값을 구한다
		if (ans < d[i])
			ans = d[i];
	}

	cout << ans << endl;
}