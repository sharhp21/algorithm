#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;
	int len = s.size();
	int sum;

	for (int i = 0; i < len; i++) {
		sum += 1;
	}
	printf("%d\n", sum);
}