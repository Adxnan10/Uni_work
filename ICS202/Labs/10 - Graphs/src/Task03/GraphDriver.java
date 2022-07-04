package Task03;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3),  Edge.getEdge(1, 0),
                                             Edge.getEdge(1, 2),  Edge.getEdge(1, 4),
                                             Edge.getEdge(2, 7),  Edge.getEdge(3, 4),
                                             Edge.getEdge(3, 5), Edge.getEdge(4, 3),
                                             Edge.getEdge(4, 6), Edge.getEdge(5, 6),
                                             Edge.getEdge(6, 7));
 
        // Number of nodes in the graph (labelled from 0 to N-1)
        int numVertices = 8;
        Graph graph = new Graph(edges, numVertices);
        // To be completed by students
        System.out.print("Enter the source vertex [0 - 7]: ");
        int input1 = scanner.nextInt();
        System.out.print("Enter the source vertex [0 - 7]: ");
        int input2 = scanner.nextInt();
        if (graph.isReachable(input1, input2))
        	System.out.print("Path exists from " + input1 + " to " + input2);
        else 
        	System.out.print("No path exists from " + input1 + " and " + input2);
    }
}