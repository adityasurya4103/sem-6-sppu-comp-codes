import sys

class DijkstraMST:
    def __init__(self, graph, num_vertices):
        self.num_vertices = num_vertices
        self.graph = graph
        self.dist = [sys.maxsize] * num_vertices
        self.visited = [False] * num_vertices

    def dijkstra(self, start_vertex):
        for i in range(self.num_vertices):
            self.dist[i] = sys.maxsize
            self.visited[i] = False

        self.dist[start_vertex] = 0
        for _ in range(self.num_vertices - 1):
            u = self.min_distance(self.dist, self.visited)
            self.visited[u] = True

            for v in range(self.num_vertices):
                if not self.visited[v] and self.graph[u][v] != 0 and self.dist[u] != sys.maxsize and self.dist[u] + self.graph[u][v] < self.dist[v]:
                    self.dist[v] = self.dist[u] + self.graph[u][v]

        self.print_mst(start_vertex)

    @staticmethod
    def min_distance(dist, visited):
        min_dist = sys.maxsize
        min_index = -1

        for i in range(len(dist)):
            if not visited[i] and dist[i] <= min_dist:
                min_dist = dist[i]
                min_index = i

        return min_index

    def print_mst(self, start_vertex):
        print("Vertex \t Distance from Source")
        for i in range(self.num_vertices):
            print(i, "\t", self.dist[i])

if __name__ == "__main__":
    n = int(input("Enter the size of the graph: "))
    graph = []
    for _ in range(n):
        row = []
        for j in range(n):
            weight = int(input("Enter the weight {}->{} of the graph: ".format(_, j)))
            row.append(weight)
        graph.append(row)

    start_vertex = int(input("Enter the starting vertex of the graph: "))

    dijkstra = DijkstraMST(graph, n)
    dijkstra.dijkstra(start_vertex)

"""
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
Enter the starting vertex of the graph: 1
Vertex   Distance from Source
0       2
1       0
2       3
3       8
4       5 
"""