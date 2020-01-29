#include <iostream>
using namespace std;

int main() {
	int L, A, B, C, D;
	int tmpA, tmpB, tmp;

	cin >> L >> A >> B >> C >> D;

	if (A % C == 0) tmpA = A / C;
	else tmpA = A / C + 1;

	if (B % D == 0) tmpB = B / D;
	else tmpB = B / D + 1;

	if (tmpA > tmpB) tmp = tmpA;
	else tmp = tmpB;

	cout << L - tmp << endl;
	return 0;
}