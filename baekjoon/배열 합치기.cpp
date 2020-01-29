#include<iostream>
#include<vector>
using namespace std;

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	vector<int> a(n);
	vector<int> b(m);
	vector<int> c(n + m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (int i = 0; i < m; i++) {
		scanf("%d", &b[i]);
	}
	int i = 0;
	int j = 0;
	int k = 0;
	while (i < n && j < m) {
		if (a[i] < b[j]) c[k++] = a[i++];
		else c[k++] = b[j++];
	}
	while (i < n) c[k++] = a[i++];
	while (j < m) c[k++] = b[j++];
	for (int i = 0; i < n + m; i++) {
		printf("%d ", c[i]);
	}
	puts("");
	return 0;
}