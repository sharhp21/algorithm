#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	string a;
	cin >> a;
	int ans = 0;
	int n = a.size();
	stack<int> s;
	for (int i = 0; i < n; i++) {
		if (a[i] == '(') {
			s.push(i);//'('가 나올때마다 stack에 push 해줌
		}
		else {
			if (s.top() + 1 == i) {//'('와')'가 인접해 있으면 '('한개 pop해주고 stack의 개수만큼 잘린 쇠막대기 갯수 추가
				s.pop();
				ans += s.size();
			}
			else {//인접해 있지 않으면 '('한개 pop해주고 쇠막대기 갯수 하나 추가
				s.pop();
				ans += 1;
			}
		}
	}
	cout << ans << endl;
	return 0;
}