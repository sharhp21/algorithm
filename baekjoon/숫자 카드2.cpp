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
		auto p = equal_range(a.begin(), a.end(), num);//p.first�� num�� ù ��ġ, p.second�� num�� ������ ��ġ+1�� ��������
		cout << p.second - p.first << " ";
		auto r = lower_bound(a.begin(), a.end(), num);//lower_bound�� num�� ù ��ġ
		auto l = upper_bound(a.begin(), a.end(), num);//upper_bound�� num�� ������ ��ġ+1�� ��������
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
		s.insert(x);//x���� ����
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