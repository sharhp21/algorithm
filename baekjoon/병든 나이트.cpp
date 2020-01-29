#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int h, w;
	cin >> h >> w;
	int ans = 0;
	if (h == 1)
		ans = 1;
	else if (h == 2) {
		ans = min(4, (w + 1) / 2);
	}
	else {
		if (w >= 7) {
			ans = w - 2;
		}
		else
			ans = min(4, w);
	}
	cout << ans << endl;
	return 0;
}