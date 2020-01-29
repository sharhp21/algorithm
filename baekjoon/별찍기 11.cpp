#include<iostream>
using namespace std;
#define BLANK 0
#define STAR 1

void go(char **a, int x, int y, int n, int color) {
	int newColor;
	if (color == BLANK) {
		int k = 2 * n - 1;
		for (int i = x; i < x + n; i++) {
			for (int j = 0; j < k; j++) {
				a[i][j + i - x + y] = ' ';
			}
		}
	}
}
