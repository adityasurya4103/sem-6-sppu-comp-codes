import java.util.*;

public class PrimMST {

    public static void prim(int[][] graph, int numVertices) {
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        boolean[] mstSet = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        
        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        int sum=0;
        for (int i = 0; i < numVertices; i++) {
            sum += key[i];
        }
        printMST(parent, graph,sum);
    }
    
    public static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        
        for (int i = 0; i < key.length; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    
    public static void printMST(int[] parent, int[][] graph,int sum) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
        System.out.println("Minimum weight of MST: " + sum);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the  size of the graph: ");
        int n = in.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("Enter the weight "+i+ "-> "+j+" of the graph: ");
                graph[i][j]=in.nextInt();
            }
        }    
        prim(graph, n);
    }

}

/*
Enter the  size of the graph: 5
Enter the weight 0-> 0 of the graph: 0
Enter the weight 0-> 1 of the graph: 2
Enter the weight 0-> 2 of the graph: 0
Enter the weight 0-> 3 of the graph: 6
Enter the weight 0-> 4 of the graph: 0
Enter the weight 1-> 0 of the graph: 2
Enter the weight 1-> 1 of the graph: 0
Enter the weight 1-> 2 of the graph: 3
Enter the weight 1-> 3 of the graph: 8
Enter the weight 1-> 4 of the graph: 5
Enter the weight 2-> 0 of the graph: 0
Enter the weight 2-> 1 of the graph: 3
Enter the weight 2-> 2 of the graph: 0
Enter the weight 2-> 3 of the graph: 0
Enter the weight 2-> 4 of the graph: 7
Enter the weight 3-> 0 of the graph: 6
Enter the weight 3-> 1 of the graph: 8
Enter the weight 3-> 2 of the graph: 0
Enter the weight 3-> 3 of the graph: 0
Enter the weight 3-> 4 of the graph: 9
Enter the weight 4-> 0 of the graph: 0
Enter the weight 4-> 1 of the graph: 5
Enter the weight 4-> 2 of the graph: 7
Enter the weight 4-> 3 of the graph: 9
Enter the weight 4-> 4 of the graph: 0
Edge	Weight
0 - 1   2
1 - 2   3
0 - 3   6
1 - 4   5
Minimum weight of MST: 16
*/
