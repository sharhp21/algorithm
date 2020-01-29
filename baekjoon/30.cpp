#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main() {
	string s;
	cin >> s;
	int three = 0;
	bool zero = false;
	bool thirty = false;
	for (int i = 0; i < s.size(); i++) {
		three += (s[i] - '0');
		if (s[i] == '0')
			zero = true;
	}
	if (three % 3 == 0 && zero == true) {
		thirty = true;
	}
	if (thirty == true) {
		sort(s.begin(), s.end());
		reverse(s.begin(), s.end());
		cout << s << endl;
	}
	else if (thirty == false) cout << -1 << endl;
	return 0;
}