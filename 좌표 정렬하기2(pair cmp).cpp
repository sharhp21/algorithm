#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, int> &u, const pair<int, int> &v) {
	if (u.second == v.second) return u.first < v.first;
	else return u.second < v.second;
}

int main() {
	int n;
	cin >> n;
	vector<pair<int, int>> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i].first >> a[i].second;
	}
	sort(a.begin(), a.end(), cmp);

	for (int i = 0; i < a.size(); i++) {
		cout << a[i].first << " " << a[i].second << endl;
	}
	return 0;
}