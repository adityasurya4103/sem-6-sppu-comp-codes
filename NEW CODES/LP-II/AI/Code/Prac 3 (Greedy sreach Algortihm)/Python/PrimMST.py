def minKey(key, mstSet):
    min = float('inf')
    minIndex = -1

    for i in range(len(key)):
        if not mstSet[i] and key[i] < min:
            min = key[i]
            minIndex = i

    return minIndex


def printMST(parent, graph, sum):
    print("Edge \tWeight")
    for i in range(1, len(parent)):
        print(parent[i], "-", i, "\t", graph[i][parent[i]])
    print("Minimum weight of MST:", sum)


def prim(graph, numVertices):
    parent = [0] * numVertices
    key = [float('inf')] * numVertices
    mstSet = [False] * numVertices

    key[0] = 0
    parent[0] = -1

    for count in range(numVertices - 1):
        u = minKey(key, mstSet)
        mstSet[u] = True

        for v in range(numVertices):
            if graph[u][v] != 0 and not mstSet[v] and graph[u][v] < key[v]:
                parent[v] = u
                key[v] = graph[u][v]

    sum = 0
    for i in range(numVertices):
        sum += key[i]

    printMST(parent, graph, sum)


n = int(input("Enter the size of the graph: "))
graph = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        graph[i][j] = int(input("Enter the weight {}->{} of the graph: ".format(i, j)))

prim(graph, n)

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
