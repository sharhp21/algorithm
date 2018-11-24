#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct Time {
	int start, end;
};
bool cmp(const Time &u, const Time &v) {
	if (u.end == v.end) return u.start < v.start;
	else return u.end < v.end;
}

int main() {
	int n;
	cin >> n;
	vector<Time> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i].start >> a[i].end;
	}
	sort(a.begin(), a.end(), cmp);
	int now = 0;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		if (now <= a[i].start) {
			now = a[i].end;
			ans += 1;
		}
	}
	cout << ans << endl;
	return 0;
}