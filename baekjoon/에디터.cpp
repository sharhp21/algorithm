#include <iostream>
#include <stack>
#include <string.h>
using namespace std;
char a[600000];

int main() {
	cin >> a;
	int h = strlen(a);

	stack<char> left, right;

	for (int i = 0; i < h; i++)
		left.push(a[i]);

	int n;
	cin >> n;

	while (n--) {
		char w;
		cin >> w;
		if (w == 'L') {
			if (!left.empty()) {
				right.push(left.top());
				left.pop();
			}
		}
		else if (w == 'D') {
			if (!right.empty()) {
				left.push(right.top());
				right.pop();
			}
		}
		else if (w == 'B') {
			if (!left.empty()) {
				left.pop();
			}
		}
		else if (w == 'P') {
			char c;
			cin >> c;
			left.push(c);
		}
	}

	while (!left.empty()) {
		right.push(left.top());
		left.pop();
	}

	while (!right.empty()) {
		cout << right.top();
		right.pop();
	}
	cout << endl;
	return 0;
}