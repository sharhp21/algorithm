#include<iostream>
#include<vector>
using namespace std;

vector<int> turn(vector<int> magnet, int direction);

int main(int argc, char** argv)
{
	int test_case;
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int K;
		int num, dir;
		int score = 0;
		vector<int> magnet_1(8);
		vector<int> magnet_2(8);
		vector<int> magnet_3(8);
		vector<int> magnet_4(8);
		cin >> K;

		for (int i = 0; i < 8; i++) {
			cin >> magnet_1[i];
		}
		for (int i = 0; i < 8; i++) {
			cin >> magnet_2[i];
		}
		for (int i = 0; i < 8; i++) {
			cin >> magnet_3[i];
		}
		for (int i = 0; i < 8; i++) {
			cin >> magnet_4[i];
		}

		while (K--) {
			cin >> num >> dir;
			
			int dir2;
			if (dir == 1) dir2 = -1;
			else if (dir == -1) dir2 = 1;

			switch (num) {
			case 1:			
				if (magnet_1.at(2) == magnet_2.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) == magnet_3.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					magnet_2 = turn(magnet_2, dir2);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					magnet_4 = turn(magnet_4, dir2);
					break;
				}
			case 2:
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) == magnet_3.at(6)) {
					magnet_2 = turn(magnet_2, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) == magnet_3.at(6)) {
					magnet_1 = turn(magnet_1, dir2);
					magnet_2 = turn(magnet_2, dir);
					break;
				}
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir2);
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					break;
				}
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					magnet_4 = turn(magnet_4, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir2);
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					magnet_4 = turn(magnet_4, dir);
					break;
				}
			case 3:
				if (magnet_2.at(2) == magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_3 = turn(magnet_3, dir);
					break;
				}
				if (magnet_2.at(2) == magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_3 = turn(magnet_3, dir);
					magnet_4 = turn(magnet_4, dir2);
					break;
				}
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					break;
				}
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					magnet_4 = turn(magnet_4, dir2);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) == magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir);
					magnet_2 = turn(magnet_2, dir2);
					magnet_3 = turn(magnet_3, dir);
					magnet_4 = turn(magnet_4, dir2);
					break;
				}
			case 4:
				if (magnet_3.at(2) == magnet_4.at(6)) {
					magnet_4 = turn(magnet_4, dir);
					break;
				}
				if (magnet_2.at(2) == magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_3 = turn(magnet_3, dir2);
					magnet_4 = turn(magnet_4, dir);
					break;
				}
				if (magnet_1.at(2) == magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					magnet_4 = turn(magnet_4, dir);
					break;
				}
				if (magnet_1.at(2) != magnet_2.at(6) && magnet_2.at(2) != magnet_3.at(6) && magnet_3.at(2) != magnet_4.at(6)) {
					magnet_1 = turn(magnet_1, dir2);
					magnet_2 = turn(magnet_2, dir);
					magnet_3 = turn(magnet_3, dir2);
					magnet_4 = turn(magnet_4, dir);
					break;
				}
			default:
				break;
			}
		}
		score = magnet_1.front() + magnet_2.front() * 2 + magnet_3.front() * 4 + magnet_4.front() * 8;
		cout << '#' << test_case << ' ' << score << endl;
	}
	return 0;
}

vector<int> turn(vector<int> magnet, int direction) {
	if(direction == 1){
		magnet.insert(magnet.begin(), magnet.back());
		magnet.pop_back();
		return magnet;
	}
	else if (direction == -1) {
		magnet.push_back(magnet.front());
		magnet.erase(magnet.begin());
		return magnet;
	}
}