#include <iostream>
#include <vector>
#include <climits>

int minKey(const std::vector<int>& key, const std::vector<bool>& mstSet) {
    int min = INT_MAX, minIndex = -1;

    for (int i = 0; i < key.size(); i++) {
        if (mstSet[i] == false && key[i] < min) {
            min = key[i];
            minIndex = i;
        }
    }

    return minIndex;
}

void printMST(const std::vector<int>& parent, const std::vector<std::vector<int>>& graph, int sum) {
    std::cout << "Edge \tWeight\n";
    for (int i = 1; i < parent.size(); i++) {
        std::cout << parent[i] << " - " << i << "\t" << graph[i][parent[i]] << "\n";
    }
    std::cout << "Minimum weight of MST: " << sum << "\n";
}

void prim(const std::vector<std::vector<int>>& graph, int numVertices) {
    std::vector<int> parent(numVertices);
    std::vector<int> key(numVertices);
    std::vector<bool> mstSet(numVertices);

    for (int i = 0; i < numVertices; i++) {
        key[i] = INT_MAX;
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

    int sum = 0;
    for (int i = 0; i < numVertices; i++) {
        sum += key[i];
    }

    printMST(parent, graph, sum);
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

    prim(graph, n);

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
