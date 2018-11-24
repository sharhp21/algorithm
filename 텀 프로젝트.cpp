#include<iostream>
using namespace std;
int a[100001];
int d[100001];
int s[100001];
int n;
int dfs(int x, int cnt, int &step) {//step�� �ѹ� �湮�ߴ� ������ ����Ű�°��� ��� s[x]�� �����ϰ� �ٸ� �������� �����ϴ� �̾����� �ʴ� ������ ���� �� �װ��� �����ϱ� ���� �Ķ����
	while (true) {
		if (d[x] != 0) {
			if (step != s[x]) {
				return 0;//�̾����� �ʴ� �����̸� ����Ŭ�� �ƴϹǷ� ��ȯ����Ŭ�� �������� �����Ƿ� 0��ȯ
			}
			return cnt - d[x];//�̾��� �����̸� ����Ŭ�� ���� cnt���� d[x]�� ���ذ��� ����Ŭ�� ���� ������ ����
		}
		d[x] = cnt;
		s[x] = step;//step�� ���� �̾��� ������ �����ϴ� ��� ������ ����
		x = a[x];
		cnt += 1;
	}
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			d[i] = 0;
			s[i] = 0;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] == 0) {
				ans += dfs(i, 1, i);//����Ŭ�� ���� ������ ������ ��� �����ش�
			}
		}
		cout << n - ans << endl;//��ü �������� ����Ŭ�� ���� ������ ������ ���ָ� �װ��� ����
	}
	return 0;
}