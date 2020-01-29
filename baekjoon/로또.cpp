#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	while (1) {
		int k;
		cin >> k;
		vector<int> a(k);
		for (int i = 0; i < k; i++) {
			cin >> a[i];
		}
		vector<int> d;
		for (int i = 0; i < k - 6; i++) {
			d.push_back(0);
		}
		for (int i = 0; i < 6; i++) {
			d.push_back(1);
		}
		do {
			for (int i = 0; i < k; i++) {
				cout << a[i] << ' ';
			}
			cout << '\n';
		} while (next_permutation(a.begin(), a.end()));
		if (k == 0) break;
	}
	return 0;
}