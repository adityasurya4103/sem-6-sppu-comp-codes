import java.util.Arrays;
import java.util.Scanner;

public class AStarPuzzle {
    static int g = 0;

    static void print(int[] puzzle) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println();
            if (puzzle[i] == -1) System.out.print("_ ");
            else System.out.print(puzzle[i] + " ");
        }
        System.out.println("\n");
    }

    static void moveLeft(int[] start, int position) {
        int temp = start[position];
        start[position] = start[position - 1];
        start[position - 1] = temp;
    }

    static void moveRight(int[] start, int position) {
        int temp = start[position];
        start[position] = start[position + 1];
        start[position + 1] = temp;
    }

    static void moveUp(int[] start, int position) {
        int temp = start[position];
        start[position] = start[position - 3];
        start[position - 3] = temp;
    }

    static void moveDown(int[] start, int position) {
        int temp = start[position];
        start[position] = start[position + 3];
        start[position + 3] = temp;
    }

    static void copy(int[] temp, int[] real) {
        System.arraycopy(real, 0, temp, 0, 9);
    }

    static int heuristic(int[] start, int[] goal) {
        int h = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (start[i] == goal[j] && start[i] != -1) {
                    h += Math.abs((j - i) / 3) + Math.abs((j - i) % 3);
                }
            }
        }
        return h + g;
    }

    static void moveTile(int[] start, int[] goal) {
        int emptyAt = 0;
        for (int i = 0; i < 9; i++) {
            if (start[i] == -1) {
                emptyAt = i;
                break;
            }
        }
        int[] t1 = new int[9];
        int[] t2 = new int[9];
        int[] t3 = new int[9];
        int[] t4 = new int[9];
        int f1 = Integer.MAX_VALUE;
        int f2 = Integer.MAX_VALUE;
        int f3 = Integer.MAX_VALUE;
        int f4 = Integer.MAX_VALUE;
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

    static void solveEight(int[] start, int[] goal) {
        g++;
        moveTile(start, goal);
        print(start);
        int f = heuristic(start, goal);
        System.out.println("f(n):"+f);
        if (f == g) {
            System.out.println("Solved in " + f + " moves");
            return;
        }
        solveEight(start, goal);
    }

    static boolean solvable(int[] start) {
        int invrs = 0;
        for (int i = 0; i < 9; i++) {
            if (start[i] <= 1) continue;
            if (start[i] == -1) continue;
            for (int j = i + 1; j < 9; j++) {
                if (start[j] == -1) continue;
                if (start[i] > start[j]) invrs++;
            }
        }
        return (invrs & 1) == 0;
    }

    public static void main(String[] args) {
        int[] start = new int[9];
        int[] goal = new int[9];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start state (Enter -1 for empty): ");
        for (int i = 0; i < 9; i++) {
            start[i] = scanner.nextInt();
        }

        System.out.print("Enter the goal state (Enter -1 for empty): ");
        for (int i = 0; i < 9; i++) {
            goal[i] = scanner.nextInt();
        }

        print(start);
        if (solvable(start)) {
            solveEight(start, goal);
        } else {
            System.out.println("\nImpossible To Solve");
        }
    }
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
