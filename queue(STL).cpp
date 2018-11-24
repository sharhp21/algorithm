#include<iostream>
#include<queue>
#include<string>
using namespace std;

int main() {
	int data[10000];
	queue<int> q;
	int n;
	cin >> n;

	while (n--) {
		string cmd;
		cin >> cmd;

		if (cmd == "push") {
			int num;
			cin >> num;
			q.push(num);
		}
		else if (cmd == "pop") {
			cout << (q.empty() ? -1 : q.front()) << endl;
			if (!q.empty())
				q.pop();
		}
		else if (cmd == "size")
			cout << q.size() << endl;
		else if (cmd == "empty")
			cout << q.empty() << endl;
		else if (cmd == "front")
			cout << (q.empty() ? -1 : q.front()) << endl;
		else if (cmd == "back")
			cout << (q.empty() ? -1 : q.back()) << endl;
	}
	return 0;
}