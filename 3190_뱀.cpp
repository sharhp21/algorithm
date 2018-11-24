#include<iostream>
#include<vector>
using namespace std;
#define MAX 10000

int main() {
	int n, k;
	cin >> n >> k;

	bool **apple = new bool *[n];
	int **bam = new int *[n];
	for (int i = 0; i < n; i++) {
		apple[i] = new bool[n];
		bam[i] = new int[n];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			apple[i][j] = false;
			if (i == 0 && j == 0) bam[i][j] = 1;
			else bam[i][j] = 0;
		}
	}

	int a, b;
	for (k; k > 0; k--) {
		cin >> a >> b;
		apple[a - 1][b - 1] = true;
	}

	int L;
	cin >> L;
	int c;
	char d;
	
	char move[MAX] = { };
	for (L; L > 0; L--) {
		cin >> c;
		cin >> d;
		move[c] = d;
	}

	//for (int i = 0; i < 100; i++) {
	//	cout << move[i] << endl;
	//}

	char dir[] = { 'R', 'D', 'L', 'U' };
	int direct = 0;
	int time = 0;
	int row = 0, col = 0;
	int tail[] = { 0, 0 };
	int applenum = 0;
	while (true) {
		// << time << ' ' << tail[0] << tail[1] << ' ' << row << col << endl;
		if (time == 0) {
			col++;
			bam[row][col] = 2;
			time++;
			if (!apple[row][col]) {
				bam[row][col - 1] = 0;
				tail[0] = 0;
				tail[1] = 1;
			}
			else {
				applenum++;
				apple[row][col] = false;
			}
		}
		else {
			if (move[time] == 'D') {
				direct++;
				if (direct > 3) direct = direct - 4;
			}
			else if (move[time] == 'L') {
				direct--;
				if (direct < 0) direct = direct + 4;
			}
			else move[time] = 'A';

			switch (dir[direct]) {
			case 'R':
				col++;
				break;
			case 'D':
				row++;
				break;
			case 'L':
				col--;
				break;
			case 'U':
				row--;
				break;
			default:
				break;
			}

			if (row >= n || col >= n || row < 0 || col < 0) break;
			else if (bam[row][col] != 0) break;
			else bam[row][col] = time + 2;

			if (!apple[row][col]) {
				bam[tail[0]][tail[1]] = 0;
				//applenum + 1 = ¹ìÀÇ±æÀÌ
				//¹ìÀÇ ²¿¸® °ª = time - applenum + 1
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						if (bam[i][j] == (time - applenum + 2)) {
							tail[0] = i;
							tail[1] = j;
						}
					}
			}
			else {
				applenum++;
				apple[row][col] = false;
			}
			time++;
		}
	}

	cout << ++time << endl;

	delete[] apple;
	delete[] bam;
	return 0;
}