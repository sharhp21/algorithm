#include<iostream>
#include<algorithm>//min
#include<cmath>//sqrt, abs
using namespace std;

int main() {
	double x, y, c;
	while (cin >> x >> y >> c) {
		double left = 0;
		double right = min(x, y);
		while (abs(right - left) > 1e-6) {//right, left 실수 이므로 같아질 수 없다. 1e-6 = 0.000001
			double mid = (left + right) / 2.0;
			double d = mid;//임의의 중앙값 d
			//h를 구하는 과정
			double h1 = sqrt(x*x - d*d);
			double h2 = sqrt(y*y - d*d);
			double h = (h1 * h2) / (h1 + h2);
			if (h > c) {
				left = mid;//d가 더 커야하므로 d값을 최소값으로 잡는다
			}
			else {
				right = mid;//d가 더 작아야하므로 d값을 최대값으로 잡는다
			}
		}
		printf("%.3lf\n", right);//소수점3째자리까지 출력
	}
	return 0;
}