#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	int n;
	cin >> n;
	int b;
	cin >> b;
	string ans = "";

	while (n > 0) {
		int a = n % b;
		if (0 <= a && a <= 9)
			ans += (char)(a + '0');
		if (10 <= a && a <= 35)
			ans += (char)(a - 10 + 'A');
		n /= b;
	}

	reverse(ans.begin(), ans.end());
	cout << ans << endl;
	return 0;
}