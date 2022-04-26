import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static boolean search(DirectedGraph graph, Node nodeA, Node nodeB) {
        if(nodeA.equals(nodeB)) {
            return true;
        }

        if(graph.adjacencyList.containsKey(nodeA) && graph.adjacencyList.containsKey(nodeA)) {
            List<Node> queue = new ArrayList<>();
            Map<Node, Boolean> visited = new HashMap<>();

            queue.add(nodeA);
            visited.put(nodeA, true);

            while(!queue.isEmpty()) {
                Node current = queue.remove(0);

                for(Node neighbor : graph.adjacencyList.get(current)) {
                    if(neighbor.equals(nodeB)) {
                        return true;
                    }

                    queue.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        DirectedGraph graph = new DirectedGraph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        graph.addVertex(nodeA);
        graph.addVertex(nodeB);
        graph.addVertex(nodeC);
        graph.addVertex(nodeD);
        graph.addVertex(nodeE);
        graph.addVertex(nodeF);

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeC, nodeE);
        graph.addEdge(nodeD, nodeE);
        graph.addEdge(nodeD, nodeF);
        graph.addEdge(nodeE, nodeF);
        System.out.println(graph);
        System.out.println(search(graph, nodeA, nodeD));
    }
}
