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

	for (int i = 0; i < n; i++) a.push_back(i); // a에다가 문자열 s의 길이만큼 push_back 해준다

	sort(a.begin(), a.end(), [&s](int u, int v) {//a * = s , &s = a // s의 첫 주소값에 u나 v를 더해준것을 비교해서 -1을 리턴하는 u와 v값을 통해 a에 정렬
		return strcmp(s.c_str() + u, s.c_str() + v) < 0; // a를 비교 정렬해준다, s.c_str() : s의 맨 처음을 가르키는 포인터     +u, +v 시켜줘서 -1이 나오는 것이 앞
	});
	
	for (auto &x : a)
		cout << s.substr(x) << endl; // 정렬된 주소값a를 처음부터 끝까지 for문을 돌린다 substr(x) x부터 부분 문자열 출력
}