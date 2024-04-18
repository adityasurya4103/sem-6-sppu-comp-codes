import java.util.*;

class Graph
{   private int V; 
    private LinkedList<Integer> adj[];  
    public Graph(int v)
    {   
        V=v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
        {
          adj[i] = new LinkedList();
    	}
    }        
    void addEdge(int v, int w)
    {
        adj[v].add(w);                              
    }
    void DFSUtil(int vertex, boolean visit[])
    {

        visit[vertex] = true;                         
        System.out.print(vertex + " ");
        int a = 0;
        for (int i = 0; i < adj[vertex].size(); i++)  
            {
                a = adj[vertex].get(i);
                if (!visit[a])                   
                {
                    DFSUtil(a, visit);
                }
            }  
    }

    void DFS(int v)
    {
        boolean already[] = new boolean[V];             
        DFSUtil(v, already);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        BFSUtil(s, visited);
    }

    void BFSUtil(int s, boolean visited[]) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
 
class Main
{
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter the size of the graph: ");
        int n = in.nextInt();
        System.out.print("Enter the size of input: ");
        int size=in.nextInt();
        Graph g=new Graph(n);
        for(int i=0;i<size;i++){
            System.out.print("Enter edges  "+(i+1)+ " of graph: ");
            int j=in.nextInt();
            int k=in.nextInt();
            if(j<n && k<n){
               g.addEdge(j, k);
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        System.out.println("Enter the starting vertex: ");
        int start=in.nextInt();
        System.out.println("DFS of Graph");
        g.DFS(start);
        System.out.println();
        System.out.println("BFS of Graph");
        g.BFS(start);
    }
}

/*
Enter the size of the graph: 5  
Enter the size of input: 6  
Enter edges 1 of graph: 0 1
Enter edges 2 of graph: 0 2
Enter edges 3 of graph: 0 3
Enter edges 4 of graph: 1 2
Enter edges 5 of graph: 2 4
Enter edges 6 of graph: 3 4  
Enter the starting vertex:0
BFS of Graph  0 1 2 3 4
DFS of Graph  0 1 2 4 3
*/