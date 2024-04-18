#include <iostream>
#include <vector>
#include <queue>
#include <stdlib.h>
#include <limits>
#include <algorithm>
using namespace std;

struct Node {
    int vertex;
    int fScore;

    Node(int vertex, int fScore) : vertex(vertex), fScore(fScore) {}

    bool operator<(const Node& other) const {
        return fScore > other.fScore;
    }
};

struct Edge {
    int dest;
    int weight;

    Edge(int dest, int weight) : dest(dest), weight(weight) {}
};

class Graph {
private:
    int numVertices;
    vector<vector<Edge>> adjList;

public:
    Graph(int numVertices) : numVertices(numVertices), adjList(numVertices) {}

    void addEdge(int source, int destination, int weight) {
        adjList[source].emplace_back(destination, weight);
    }

    vector<int> aStarAlgorithm(int start, int goal, const vector<int>& heuristic) {
        vector<int> g(numVertices, numeric_limits<int>::max()); 
        vector<int> f(numVertices, numeric_limits<int>::max()); 
        vector<int> parent(numVertices, -1); 

        g[start] = 0;
        f[start] = heuristic[start];

        priority_queue<Node> openList;
        openList.emplace(start, f[start]);

        while (!openList.empty()) {
            Node current = openList.top();
            openList.pop();
            int currentVertex = current.vertex;

            if (currentVertex == goal) {
            	
                vector<int> path;
                int vertex = goal;
                while (vertex != -1) {
                    path.push_back(vertex);
                    vertex = parent[vertex];
                }
                reverse(path.begin(), path.end());
                
                int pathCost = g[goal];  
    			cout << "Path cost: " << pathCost << endl;
                return path;
            }
            
			
            for (const Edge& neighbor : adjList[currentVertex]) {
                int neighborVertex = neighbor.dest;
                int tentativeG = g[currentVertex] + neighbor.weight;

                if (tentativeG < g[neighborVertex]) {
                	
                    parent[neighborVertex] = currentVertex;
                    g[neighborVertex] = tentativeG;
                    f[neighborVertex] = g[neighborVertex] + heuristic[neighborVertex];
                    openList.emplace(neighborVertex, f[neighborVertex]);
                }
                
            }
            
        }
		
        return {}; 
    }
};

int main() {
	int n;
    cout << "Enter the size of the graph: ";
    cin >> n;
    Graph graph(n);
    int size;
    cout << "Enter the size of input: ";
    cin >> size;

    cout << "Enter edges of the graph:" << endl;
    for (int i = 0; i < size; i++) {
        int j, k, w;
        cout << "Enter the value of " << (i + 1) << " edge and its weight: ";
        cin >> j >> k >> w;
        if (j < n && k < n) {
            graph.addEdge(j, k, w);
        } else {
            cout << "Invalid Input" << endl;
        }
    }
    vector<int> heuristic(n);
    cout << "Enter the heuristic values for the vertices of the graph:" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Enter " << i << " vertex's heuristic value: ";
        cin >> heuristic[i];
    }

    int startVertex, goalVertex;
    cout << "Enter the starting vertex of the graph: ";
    cin >> startVertex;
    cout << "Enter the ending vertex of the graph: ";
    cin >> goalVertex;

   	vector<int> path = graph.aStarAlgorithm(startVertex, goalVertex, heuristic);
	if (!path.empty()) {
    cout << "Optimal path found:";
		for (int vertex : path) {
			cout << " " << vertex;
		}
	}
	else {
    	cout << "Path not found!" << endl;
	}
    
return 0;
}
/*
Enter the size of the graph: 5
Enter the size of input: 7
Enter edges of the graph:
Enter the value of 1 edge and its weight: 0 1 4
Enter the value of 2 edge and its weight: 0 2 2
Enter the value of 3 edge and its weight: 1 2 1
Enter the value of 4 edge and its weight: 1 3 5
Enter the value of 5 edge and its weight: 2 3 8
Enter the value of 6 edge and its weight: 2 4 10
Enter the value of 7 edge and its weight: 3 4 2
Enter the heuristic values for the vertices of the graph:
Enter 0 vertex's heuristic value: 7
Enter 1 vertex's heuristic value: 6
Enter 2 vertex's heuristic value: 2
Enter 3 vertex's heuristic value: 1
Enter 4 vertex's heuristic value:0
Enter the starting vertex of the graph: 0
Enter the ending vertex of the graph: 4
Path cost: 11
Optimal path found: 0 1 3 4
*/

