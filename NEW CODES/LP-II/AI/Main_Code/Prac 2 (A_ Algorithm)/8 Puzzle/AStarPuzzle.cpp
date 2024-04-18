#include <iostream>
#include <cmath>
using namespace std;

void print(int puzzle[]) {
    for (int i = 0; i < 9; i++) {
        if (i % 3 == 0)
            cout << endl;
        if (puzzle[i] == -1)
            cout << "_ ";
        else
            cout << puzzle[i] << " ";
    }
    cout << endl;
}

void moveLeft(int start[], int position) {
    int temp = start[position];
    start[position] = start[position - 1];
    start[position - 1] = temp;
}

void moveRight(int start[], int position) {
    int temp = start[position];
    start[position] = start[position + 1];
    start[position + 1] = temp;
}

void moveUp(int start[], int position) {
    int temp = start[position];
    start[position] = start[position - 3];
    start[position - 3] = temp;
}

void moveDown(int start[], int position) {
    int temp = start[position];
    start[position] = start[position + 3];
    start[position + 3] = temp;
}

void copy(int temp[], int real[]) {
    for (int i = 0; i < 9; i++) {
        temp[i] = real[i];
    }
}

int heuristic(int start[], int goal[]) {
    int h = 0;
    for (int i = 0; i < 9; i++) {
        if (start[i] == -1)
            continue;
        int rowStart = i / 3;
        int colStart = i % 3;
        for (int j = 0; j < 9; j++) {
            if (start[i] == goal[j]) {
                int rowGoal = j / 3;
                int colGoal = j % 3;
                h += abs(rowGoal - rowStart) + abs(colGoal - colStart);
            }
        }
    }
    return h;
}

void moveTile(int start[], int goal[]) {
    int emptyAt = 0;
    for (int i = 0; i < 9; i++) {
        if (start[i] == -1) {
            emptyAt = i;
            break;
        }
    }
    int t1[9], t2[9], t3[9], t4[9];
    int f1 = INT_MAX, f2 = INT_MAX, f3 = INT_MAX, f4 = INT_MAX;
    copy(t1, start);
    copy(t2, start);
    copy(t3, start);
    copy(t4, start);
    int row = emptyAt / 3;
    int col = emptyAt % 3;
    if (col - 1 >= 0) {
        moveLeft(t1, emptyAt);
        f1 = heuristic(t1, goal);
    }
    if (col + 1 < 3) {
        moveRight(t2, emptyAt);
        f2 = heuristic(t2, goal);
    }
    if (row + 1 < 3) {
        moveDown(t3, emptyAt);
        f3 = heuristic(t3, goal);
    }
    if (row - 1 >= 0) {
        moveUp(t4, emptyAt);
        f4 = heuristic(t4, goal);
    }
    if (f1 <= f2 && f1 <= f3 && f1 <= f4) {
        moveLeft(start, emptyAt);
    } else if (f2 <= f1 && f2 <= f3 && f2 <= f4) {
        moveRight(start, emptyAt);
    } else if (f3 <= f1 && f3 <= f2 && f3 <= f4) {
        moveDown(start, emptyAt);
    } else {
        moveUp(start, emptyAt);
    }
}

void solveEight(int start[], int goal[]) {
    static int g = 0;
    g++;
    moveTile(start, goal);
    print(start);
    int f = heuristic(start, goal) + g;
    cout<<"f(n):"<<f<<endl;
    if (f == g) {
        cout << "\nSolved in " << g << " moves" << endl;
        return;
    }
    solveEight(start, goal);
}

bool solvable(int start[]) {
    int invrs = 0;
    for (int i = 0; i < 9; i++) {
        if (start[i] <= 1)
            continue;
        if (start[i] == -1)
            continue;
        for (int j = i + 1; j < 9; j++) {
            if (start[j] == -1)
                continue;
            if (start[i] > start[j])
                invrs++;
        }
    }
    return invrs % 2 == 0;
}

int main() {
    int start[9], goal[9];
    cout << "Enter the start state (Enter -1 for empty): ";
    for (int i = 0; i < 9; i++) {
        cin >> start[i];
    }

    cout << "Enter the goal state (Enter -1 for empty): ";
    for (int i = 0; i < 9; i++) {
        cin >> goal[i];
    }

    print(start);
    if (solvable(start)) {
        solveEight(start, goal);
    } else {
        cout << "\nImpossible To Solve" << endl;
    }

    return 0;
}

/*
Enter the start state (Enter -1 for empty): 1 2 3 -1 4 6 7 5 8
Enter the goal state (Enter -1 for empty): 1 2 3 4 5 6  7 8 -1

1 2 3
_ 4 6
7 5 8


1 2 3
4 _ 6
7 5 8


1 2 3
4 5 6
7 _ 8


1 2 3
4 5 6
7 8 _

Solved in 3 moves
 */
