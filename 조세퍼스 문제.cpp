#include<iostream>
#include<queue>
#include<string>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;

	queue<int> q;

	for (int i = 1; i <= n; i++)
		q.push(i);//q�� ��� push
	cout << "<";
	for (int i = 0; i < n - 1; i++) {//n-1��° ������� �ݺ�
		for (int j = 0; j < m - 1; j++) {//m-1��° ��������� �׻���� �� �ڷ� �Ű��ְ� �տ��� ����
			q.push(q.front());
			q.pop();
		}
		cout << q.front() << ", ";
		q.pop();
	}
	cout << q.front() << ">";
	return 0;
}