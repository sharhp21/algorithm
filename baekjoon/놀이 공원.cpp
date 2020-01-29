#include<iostream>
using namespace std;
int a[10001];

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> a[i];
	}
	if (n <= m) {
		cout << n << '\n';
		return 0;
	}
	long long left = 0;
	long long right = 2000000000LL * 30LL;
	while (left <= right) {
		long long mid = (left + right) / 2;
		long long begin, end;
		begin = end = 0;
		end = m;
		for (int i = 0; i < m; i++) {
			end += mid / a[i];
		}
		begin = end;
		for (int i = 0; i < m; i++) {
			if (mid % a[i] == 0) {
				begin -= 1;
			}
		}
		begin += 1;
		if (n < begin) {
			right = mid - 1;
		}
		else if (n > end) {
			left = mid + 1;
		}
		else {
			for (int i = 0; i < m; i++) {
				if (mid % a[i] == 0) {
					if (n == begin) {
						cout << i + 1 << '\n';
						return 0;
					}
					begin += 1;
				}
			}
		}
	}
	return 0;
}