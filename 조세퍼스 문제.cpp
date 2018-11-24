#include<iostream>
#include<queue>
#include<string>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;

	queue<int> q;

	for (int i = 1; i <= n; i++)
		q.push(i);//q에 사람 push
	cout << "<";
	for (int i = 0; i < n - 1; i++) {//n-1번째 사람까지 반복
		for (int j = 0; j < m - 1; j++) {//m-1번째 사람까지는 그사람을 맨 뒤로 옮겨주고 앞에서 제거
			q.push(q.front());
			q.pop();
		}
		cout << q.front() << ", ";
		q.pop();
	}
	cout << q.front() << ">";
	return 0;
}