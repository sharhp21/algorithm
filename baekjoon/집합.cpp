#include<iostream>
using namespace std;
char b[222];

int main() {
	int n = 20;
	int m;
	cin >> m;
	int s = 0;
	int x;
	while (m--) {
		cin >> b;
		if (!strcmp(b, "add")) {
			cin >> x;
			x--;
			s = (s | (1 << x));
		}
		else if (!strcmp(b, "remove")) {
			cin >> x;
			x--;
			s = (s & ~(1 << x));
		}
		else if (!strcmp(b, "check")) {
			cin >> x;
			x--;
			int res = (s & (1 << x));
			if (res) {
				puts("1");
			}
			else puts("0");
		}
		else if (!strcmp(b, "toggle")) {
			cin >> x;
			x--;
			s = (s ^ (1 << x));
		}
		else if (!strcmp(b, "all")) {
			s = (1 << n) - 1;
		}
		else if (!strcmp(b, "empty")) {
			s = 0;
		}
	}
	return 0;
}