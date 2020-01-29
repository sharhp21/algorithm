#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;

	while (getline(cin, s)) {//한줄을 받아옴
		int small = 0;
		int big = 0;
		int num = 0;
		int space = 0;
		
		for (int i = 0; i < s.size(); i++) {
			if (s[i] >= 'a' && s[i] <= 'z')
				small += 1;
			else if (s[i] >= 'A' && s[i] <= 'Z')
				big += 1;
			else if (s[i] >= '0' && s[i] <= '9')
				num += 1;
			else if (s[i] == ' ')
				space += 1;
		}
		cout << small << ' ' << big << ' ' << num << ' ' << space << endl;
	}
	return 0;
}