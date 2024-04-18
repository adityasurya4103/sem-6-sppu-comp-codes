from collections import deque


class Graph:
    def __init__(self, v):
        self.V = v
        self.adj = [[] for _ in range(v)]

    def addEdge(self, v, w):
        self.adj[v].append(w)

    def DFSUtil(self, vertex, visited):
        visited[vertex] = True
        print(vertex, end=" ")

        for a in self.adj[vertex]:
            if not visited[a]:
                self.DFSUtil(a, visited)

    def DFS(self, v):
        visited = [False] * self.V
        self.DFSUtil(v, visited)

    def BFS(self, s):
        visited = [False] * self.V
        queue = deque()
        visited[s] = True
        queue.append(s)

        while queue:
            s = queue.popleft()
            print(s, end=" ")

            for n in self.adj[s]:
                if not visited[n]:
                    visited[n] = True
                    queue.append(n)


n = int(input("Enter the size of the graph: "))
g = Graph(n)

size = int(input("Enter the size of input: "))
for i in range(size):
    j, k = map(int, input(f"Enter edges {i + 1} of graph: ").split())

    if j < n and k < n:
        g.addEdge(j, k)
    else:
        print("Invalid Input")

start = int(input("Enter the starting vertex: "))
print("DFS of Graph")
g.DFS(start)
print()
print("BFS of Graph")
g.BFS(start)

"""
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
"""