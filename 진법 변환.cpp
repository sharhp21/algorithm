#include<iostream>
#include<string>
using namespace std;

int main() {
	string n;
	int b;
	cin >> n >> b;
	int ans = 0;
	int r = n.size();

	for (int i = 0; i < r - 1; i++) {
		if (n[i] >= '0' && n[i] <= '9') {
			ans += (n[i] - '0');
			ans *= b;
		}
		else {
			ans += (n[i] - 'A' + 10);
			ans *= b;
		}
	}

	if (n[r - 1] >= '0' && n[r - 1] <= '9')
		ans += (n[r - 1] - '0');
	else
		ans += (n[r - 1] - 'A' + 10);
	cout << ans << endl;
	return 0;
}