#include<iostream>
using namespace std;

int main() {
	int A, B, C;
	int in[3], out[3];
	int start = 100;
	int finish = 0;
	int fee = 0;
	cin >> A >> B >> C;
	
	for (int i = 0; i < 3; i++) {
		cin >> in[i] >> out[i];
	}

	for (int i = 0; i < 3; i++){
		if (in[i] < start) start = in[i];
		if (out[i] > finish) finish = out[i];
	}
	
	int **tmp = new int *[3];
	for (int i = 0; i < 3; i++) {
		tmp[i] = new int[finish - start];
	}

	for(int i = 0; i < 3; i++)
		for (int j = 0; j < finish - start; j++) {
			tmp[i][j] = 0;
			if (j >= in[i] - start && j < out[i] - start) {
				tmp[i][j] = 1;
			}
		}

	for (int i = 0; i < finish - start; i++) {
		int cnt = 0;
		for (int j = 0; j < 3; j++) {
			if (tmp[j][i] == 1) cnt++;
		}
		switch (cnt) {
		case 1:
			fee += A;
			break;
		case 2:
			fee += B * 2;
			break;
		case 3:
			fee += C * 3;
			break;
		default:
			break;
		}
	}

	cout << fee << endl;
	/*for (int i = 0; i < 3; i++) {
		for (int j = 0; j < finish - start; j++)
			cout << tmp[i][j] << ' ';
		cout << endl;
	}*/
}