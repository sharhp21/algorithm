#include<iostream>
using namespace std;
int cnt[10001];

int main() {
	int n;
	cin >> n;
	int temp = 0;
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		cnt[temp] += 1;
	}
	for (int i = 1; i <= 10000; i++) {
		while (cnt[i]--) {
			cout << i << '\n';
		}
	}
	return 0;
}