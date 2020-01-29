#include<iostream>
#include<string>
#include<cstring>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	string s;
	cin >> s;
	int n = s.size();

	vector<int> a;

	for (int i = 0; i < n; i++) a.push_back(i); // a���ٰ� ���ڿ� s�� ���̸�ŭ push_back ���ش�

	sort(a.begin(), a.end(), [&s](int u, int v) {//a * = s , &s = a // s�� ù �ּҰ��� u�� v�� �����ذ��� ���ؼ� -1�� �����ϴ� u�� v���� ���� a�� ����
		return strcmp(s.c_str() + u, s.c_str() + v) < 0; // a�� �� �������ش�, s.c_str() : s�� �� ó���� ����Ű�� ������     +u, +v �����༭ -1�� ������ ���� ��
	});
	
	for (auto &x : a)
		cout << s.substr(x) << endl; // ���ĵ� �ּҰ�a�� ó������ ������ for���� ������ substr(x) x���� �κ� ���ڿ� ���
}