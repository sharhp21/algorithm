#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	vector<int> a(n);
	k -= 1;
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}

	nth_element(a.begin(), a.begin() + k, a.end());

	printf("%d\n", a[k]);
	return 0;
}