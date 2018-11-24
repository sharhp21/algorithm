#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<tuple>
using namespace std;

struct Point {
	string name;
	int korean;
	int english;
	int math;
};

bool cmp(const Point &u, const Point &v)
{
	return make_tuple(-u.korean, u.english, -u.math, u.name) < make_tuple(-v.korean, v.english, -v.math, v.name);
}

int main() {
	int n;
	cin >> n;
	vector<Point> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i].name >> a[i].korean >> a[i].english >> a[i].math;
	}
	sort(a.begin(), a.end(), cmp);
	for (int i = 0; i < n; i++) {
		cout << a[i].name << endl;
	}
	return 0;
}