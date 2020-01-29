#include<iostream>
#include<algorithm>//min
#include<cmath>//sqrt, abs
using namespace std;

int main() {
	double x, y, c;
	while (cin >> x >> y >> c) {
		double left = 0;
		double right = min(x, y);
		while (abs(right - left) > 1e-6) {//right, left �Ǽ� �̹Ƿ� ������ �� ����. 1e-6 = 0.000001
			double mid = (left + right) / 2.0;
			double d = mid;//������ �߾Ӱ� d
			//h�� ���ϴ� ����
			double h1 = sqrt(x*x - d*d);
			double h2 = sqrt(y*y - d*d);
			double h = (h1 * h2) / (h1 + h2);
			if (h > c) {
				left = mid;//d�� �� Ŀ���ϹǷ� d���� �ּҰ����� ��´�
			}
			else {
				right = mid;//d�� �� �۾ƾ��ϹǷ� d���� �ִ밪���� ��´�
			}
		}
		printf("%.3lf\n", right);//�Ҽ���3°�ڸ����� ���
	}
	return 0;
}