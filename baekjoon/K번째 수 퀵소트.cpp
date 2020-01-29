#include<iostream>
#include<algorithm>
using namespace std;
int a[5000000];

int choosePivot(int low, int high){
	return low + (high - low) / 2;
}
int partition(int low, int high) {
	int pivotIndex = choosePivot(low, high);
	int pivotValue = a[pivotIndex];
	swap(a[pivotIndex], a[high]);
	int storeIndex = low;
	for (int i = low; i < high; i++) {
		if (a[i] < pivotValue) {
			swap(a[i], a[storeIndex]);
			storeIndex += 1;
		}
	}
	swap(a[storeIndex], a[high]);
	return storeIndex;
}

void quicksort(int low, int high, int k) {
	if (low < high) {
		int pivot = partition(low, high);
		if(k < pivot) quicksort(low, pivot - 1, k);
		else quicksort(pivot + 1, high, k);
	}
}

int main() {
	int n, k;
	cin >> n >> k;
	k -= 1;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	quicksort(0, n - 1, k);
	cout << a[k] << endl;
	return 0;
}