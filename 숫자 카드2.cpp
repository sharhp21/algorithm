#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
vector<int> a(500000);

/*int main() {
	int n, m;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a.begin(), a.end());
	cin >> m;
	while (m--) {
		int num;
		cin >> num;
		auto p = equal_range(a.begin(), a.end(), num);//p.first에 num의 첫 위치, p.second에 num의 마지막 위치+1을 저장해줌
		cout << p.second - p.first << " ";
		auto r = lower_bound(a.begin(), a.end(), num);//lower_bound에 num의 첫 위치
		auto l = upper_bound(a.begin(), a.end(), num);//upper_bound에 num의 마지막 위치+1을 저장해줌
		printf("%d ", l - r);
	}
	cout << '\n';
	return 0;
}*/

int main() {
	int n;
	cin >> n;
	multiset<int> s;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		s.insert(x);//x원소 삽입
	}
	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		cout << s.count(x) << " ";
	}
	cout << endl;
	return 0;
}