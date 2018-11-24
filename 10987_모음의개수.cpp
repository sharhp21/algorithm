#include<iostream>
#include<string>
using namespace std;

int main() {
	string word;
	cin >> word;
	int ans = 0;

	for (int i = 0; i < word.length(); i++) {
		if (word.at(i) == 'a' || word.at(i) == 'e' || word.at(i) == 'i' || word.at(i) == 'o' || word.at(i) == 'u') {
			ans++;
		}
	}

	cout << ans << endl;
	return 0;
}