#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

struct Point {
	int x, y;
	Point() {
	}
	Point(int x, int y) : x(x), y(y) {
	}
	bool operator < (const Point &v) const {
		if (x == v.x) {
			return y < v.y;
		}
		else return x < v.x;
	}
};

bool cmp(const Point &u, const Point &v) {
	return u.y < v.y;
}

int dist(Point p1, Point p2) {
	return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
}

int brute_force(vector<Point> &a, int x, int y) {
	int ans = -1;
	for (int i = x; i <= y - 1; i++) {
		for (int j = i + 1; j <= y; j++) {
			int d = dist(a[i], a[j]);
			if (ans == -1 || d < ans) {
				ans = d;
			}
		}
	}
	return ans;
}

int closest(vector<Point> &a, int x, int y) {
	int n = y - x + 1;
	if (n <= 3) {
		return brute_force(a, x, y);
	}
	int mid = (x + y) / 2;
	int left = closest(a, x, mid);
	int right = closest(a, mid, y);
	int ans = min(left, right);
	vector<Point> b;
	for (int i = x; i <= y; i++) {
		int d = a[i].x - a[mid].x;
		if (d * d < ans) {
			b.push_back(a[i]);
		}
	}
	sort(b.begin(), b.end(), cmp);
	int m = b.size();
	for (int i = 0; i < m - 1; i++) {
		for (int j = i + 1; j < m; j++) {
			int y = b[j].y - b[i].y;
			if (y * y < ans) {
				int d = dist(b[i], b[j]);
				if (d < ans) {
					ans = d;
				}
			}
			else break;
		}
	}
	return ans;
}

int main() {
	int n;
	cin >> n;
	vector<Point> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i].x >> a[i].y;
	}
	sort(a.begin(), a.end());
	cout << closest(a, 0, n - 1) << '\n';
	return 0;
}