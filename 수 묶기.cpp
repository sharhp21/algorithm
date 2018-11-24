#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int a[10000];

int main() {
	int n;
	cin >> n;
	vector<int> plus;
	vector<int> minus;
	int one = 0;
	int zero = 0;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		if (a[i] == 1) {
			one += 1;
		}
		else if (a[i] == 0) {
			zero += 1;
		}
		else if (a[i] > 0) {
			plus.push_back(a[i]);
		}
		else if (a[i] < 0) {
			minus.push_back(a[i]);
		}
	}
	int ans = one;
	sort(plus.begin(), plus.end());
	reverse(plus.begin(), plus.end());
	sort(minus.begin(), minus.end());
	if (plus.size() % 2 != 0) {
		plus.push_back(1);
	}
	for (int i = 0; i < plus.size(); i += 2) {
		ans += plus[i] * plus[i + 1];
	}
	if (minus.size() % 2 != 0) {
		if (zero == 0) {
			minus.push_back(1);
		}
		else minus.pop_back();
	}
	for (int i = 0; i < minus.size(); i += 2) {
		ans += minus[i] * minus[i + 1];
	}
	cout << ans << endl;
	return 0;
}