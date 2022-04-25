public class App {
    public static void main(String[] args) throws Exception {
        UnweightedGraph graph = new UnweightedGraph();
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
        System.out.println(graph.breadthFirstSearch(nodeA));
        System.out.println(graph.breadthFirstSearch(nodeC));
    }
}
