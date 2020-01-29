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
			s.push(i);//'('�� ���ö����� stack�� push ����
		}
		else {
			if (s.top() + 1 == i) {//'('��')'�� ������ ������ '('�Ѱ� pop���ְ� stack�� ������ŭ �߸� �踷��� ���� �߰�
				s.pop();
				ans += s.size();
			}
			else {//������ ���� ������ '('�Ѱ� pop���ְ� �踷��� ���� �ϳ� �߰�
				s.pop();
				ans += 1;
			}
		}
	}
	cout << ans << endl;
	return 0;
}