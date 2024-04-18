#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

class NQueensProblem {
private:
    vector<int> queens;
    int numSolutions;

public:
    NQueensProblem(int n) : queens(n), numSolutions(0) {}

    void solve() {
        solve(0);
    }

private:
    void solve(int row) {
        if (row == queens.size()) {
            numSolutions++;
            printSolution();
        } else {
            for (int col = 0; col < queens.size(); col++) {
                queens[row] = col;
                if (isValid(row, col)) {
                    solve(row + 1);
                }
            }
        }
    }

    bool isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            int diff =  abs(queens[i] - col);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    void printSolution() {
        if (numSolutions == 1) {
             cout << "Solution: ";
            for (int i = 0; i < queens.size(); i++) {
                 cout << queens[i] << " ";
            }
             cout <<  endl;
             cout << "The Matrix Representation:" <<  endl;
             vector< vector<int>> arr(queens.size(),  vector<int>(queens.size(), 0));
            for (int i = 0; i < queens.size(); i++) {
                arr[i][queens[i]] = 1;
            }
            for (int i = 0; i < queens.size(); i++) {
                for (int j = 0; j < queens.size(); j++) {
                     cout << arr[i][j] << " ";
                }
                 cout <<  endl;
            }
        }
    }
};

int main() {
    cout << "Enter N Queens Problem: ";
    int n;
    cin >> n;

    NQueensProblem nQueensProblem(n);
    nQueensProblem.solve();

    return 0;
}


/*Enter N Queens Problem: 4  
Solution: 1 3 0 2
The Matrix Representation:  
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
Enter N Queens Problem: 6  
Solution: 1 3 5 0 2 4
The Matrix Representation:
0 1 0 0 0 0
0 0 0 1 0 0
0 0 0 0 0 1
1 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 1 0
Enter N Queens Problem: 8  
Solution: 0 4 7 5 2 6 1 3  
The Matrix Representation:  1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0
*/
