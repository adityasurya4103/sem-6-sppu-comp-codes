#include <iostream>
#include <vector>
#include <algorithm>

struct Edge {
    int src, dest, weight;

    bool operator<(const Edge& other) const {
        return weight < other.weight;
    }
};

int find(std::vector<int>& parent, int i) {
    if (parent[i] != i) {
        parent[i] = find(parent, parent[i]);
    }
    return parent[i];
}

void kruskal(std::vector<std::vector<int>>& graph, int numVertices) {
    std::vector<Edge> edges;
    for (int i = 0; i < numVertices; i++) {
        for (int j = i + 1; j < numVertices; j++) {
            if (graph[i][j] != 0) {
                Edge edge;
                edge.src = i;
                edge.dest = j;
                edge.weight = graph[i][j];
                edges.push_back(edge);
            }
        }
    }

    std::sort(edges.begin(), edges.end());

    std::vector<int> parent(numVertices);
    for (int i = 0; i < numVertices; i++) {
        parent[i] = i;
    }

    std::vector<Edge> mst;
    int sum = 0;

    for (const Edge& edge : edges) {
        int srcParent = find(parent, edge.src);
        int destParent = find(parent, edge.dest);
        if (srcParent != destParent) {
            mst.push_back(edge);
            parent[srcParent] = destParent;
            sum += edge.weight;
        }
    }

    std::cout << "Edges in the MST:\n";
    for (const Edge& edge : mst) {
        std::cout << edge.src << " - " << edge.dest << " : " << edge.weight << "\n";
    }
    std::cout << "Minimum weight of MST: " << sum << "\n";
}

int main() {
    int n;
    std::cout << "Enter the size of the graph: ";
    std::cin >> n;

    std::vector<std::vector<int>> graph(n, std::vector<int>(n));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            std::cout << "Enter the weight " << i << "->" << j << " of the graph: ";
            std::cin >> graph[i][j];
        }
    }


    kruskal(graph, n);

    return 0;
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