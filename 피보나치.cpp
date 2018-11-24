#include<iostream>
using namespace std;

//Top_down 방식
/*int memo[100];

int fibonacci(int n) {
	if (n <= 1)
		return n;
	else {
		if (memo[n] > 0)
			return memo[n];
		else {
			memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
			return memo[n];
		}
	}
}*/

//Botton_up 방식
int d[100];

int fibonacci(int n) {
	d[0] = 0;
	d[1] = 1;
	for (int i = 2; i <= n; i++)
		d[i] = d[i - 1] + d[i - 2];
	return d[n];
}
int main() {
	int n;
	cin >> n;
	cout << fibonacci(n) << endl;
}