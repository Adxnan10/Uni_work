package Task03;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;
 
    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
 
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge edge: edges){
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
        }
    }
  
    public boolean isReachable(int src, int dest){
      boolean[] visited = new boolean[numVertices];
      return isReachable(src, dest, visited);
    }
    
    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    /*
     * BreadthFirst(G, v)
 	   enqueue the starting vertex v; mark it as visited; 2 while(queue is not empty){
		dequeue a vertex v from the queue; visit v.
		enqueue vertices adjacent to v that are not marked visited;
  	}

     * */
    private boolean isReachable(int src, int dest, boolean[] visited)
    {
        ArrayList<Integer> queue = new ArrayList<Integer>();
 
        // Mark the source node as visited and enqueue it
        visited[src]=true;
        queue.add(src);
        
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and make it current vertex.
        	int v = queue.remove(0);
            // for each adjacent of the dequeued vertex
            // If the adjacent is destination then return true;
        	// else if the adjacent not been visited, then mark it
            // visited and enqueue it
        	for (int i = 0; i < adjList.get(v).size(); i++) {
        		int elm = adjList.get(v).get(i);
        		if (elm == dest) return true;
        		if(!visited[elm]) {
        			visited[elm] = true;
        			queue.add(elm);
        		}
        	}
            
        }
        return false; // Destination was not found in any path starts from the source.
    }
}