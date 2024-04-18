import java.util.*;
public class NQueensProblem {
    private int[] queens;
    private int numSolutions;

    public NQueensProblem(int n) {
        queens = new int[n];
    }

    public void solve() {
        solve(0);
    }
    
    private void solve(int row) {
        if (row == queens.length) {
            numSolutions++;
            printSolution();
        } else {
            for (int col = 0; col < queens.length; col++) {
                queens[row] = col;
                if (isValid(row, col)) {
                    solve(row + 1);
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(queens[i] - col);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        if(numSolutions==1){
            System.out.print("Solution: ");
        for (int i = 0; i < queens.length; i++) {
            System.out.print(queens[i] + " ");
        }
        System.out.println();
        System.out.println("The Matrix Representation:");
        int [][]arr=new int[queens.length][queens.length];
        for(int i=0;i< queens.length;i++){
            for(int j=0;j<queens.length;j++){
                if((j)==queens[i]){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=0;
                }
            }
        }
        for(int i=0;i< queens.length;i++){
            for(int j=0;j<queens.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        }
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
    System.out.print("Enter N Queens Problem: ");
    int n = in.nextInt();
        NQueensProblem NQueensProblem = new NQueensProblem(n);
        NQueensProblem.solve();
    }
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
