#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	string ans = "";
	
	while (n != 0 && n != -1 && n != 1) {
		int r;
		if(n%2 == 0 || n > 0) r = n % (-2);
		else r = 1;
		ans += (char)(r + '0');
		if (n > 0 || n%2 == 0) n = n / (-2);
		else n = (n - 1) / (-2);
	}
	if (n == -1) {
		ans += '1';
		ans += '1';
	}
	else if (n == 1)
		ans += '1';

	reverse(ans.begin(), ans.end());
	if (n == 0) cout << "0" << endl;
	else cout << ans << endl;
	return 0;
}