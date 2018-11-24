#include<iostream>
#include<algorithm>
using namespace std;
int n, m;
int a[500000];

int BinarySearch(int num) {
	int start = 0;
	int end = n - 1;
	while (start <= end) {
		int mid = (start + end) / 2;
		if (a[mid] == num) {
			return 1;
		}
		else if (a[mid] > num) {
			end = mid - 1;
		}
		else start = mid + 1;
	}
	return 0;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a, a + n);
	cin >> m;
	while (m--) {
		int num;
		cin >> num;
		cout << BinarySearch(num) << " ";
	}
	cout << endl;
	return 0;
}