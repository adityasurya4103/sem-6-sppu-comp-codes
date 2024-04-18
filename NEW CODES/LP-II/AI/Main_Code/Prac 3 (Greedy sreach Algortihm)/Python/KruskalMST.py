class Edge:
    def __init__(self, src, dest, weight):
        self.src = src
        self.dest = dest
        self.weight = weight

    def __lt__(self, other):
        return self.weight < other.weight

def find(parent, i):
    if parent[i] != i:
        parent[i] = find(parent, parent[i])
    return parent[i]

def kruskal(graph, numVertices):
    edges = []
    for i in range(numVertices):
        for j in range(i + 1, numVertices):
            if graph[i][j] != 0:
                edge = Edge(i, j, graph[i][j])
                edges.append(edge)

    edges.sort()

    parent = list(range(numVertices))
    mst = []
    total_weight = 0

    for edge in edges:
        src_parent = find(parent, edge.src)
        dest_parent = find(parent, edge.dest)
        if src_parent != dest_parent:
            mst.append(edge)
            parent[src_parent] = dest_parent
            total_weight += edge.weight

    print("Edges in the MST:")
    for edge in mst:
        print(edge.src, "-", edge.dest, ":", edge.weight)
    print("Minimum weight of MST:", total_weight)

n = int(input("Enter the size of the graph: "))
graph = []
for i in range(n):
    row = []
    for j in range(n):
        weight = int(input("Enter the weight " + str(i) + "->" + str(j) + " of the graph: "))
        row.append(weight)
    graph.append(row)

kruskal(graph, n)

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
Edge	Weight
0 - 1   2
1 - 2   3
0 - 3   6
1 - 4   5
Minimum weight of MST: 16
"""