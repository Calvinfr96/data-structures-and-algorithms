import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UnweightedGraph {
    public Map<Node, List<Node>> adjacencyList;

    public UnweightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public boolean addVertex(Node node) {
        List<Node> previousList = adjacencyList.putIfAbsent(node, new ArrayList<>());

        if(Objects.isNull(previousList)) {
            return true;
        }

        return false;
    }

    public boolean deleteVertex(Node node) {
        if(adjacencyList.containsKey(node)) {
            List<Node> neighbors = adjacencyList.get(node);

            while(!neighbors.isEmpty()) {
                deleteEdge(node, neighbors.get(0));
            }
            adjacencyList.remove(node);
            return true;
        }

        return false;
    }

    public boolean addEdge(Node nodeA, Node nodeB) {
        if(nodeA.equals(nodeB)) {
            return false;
        }

        if(adjacencyList.containsKey(nodeA) && adjacencyList.containsKey(nodeB)) {
            if(!adjacencyList.get(nodeA).contains(nodeB)) {
                adjacencyList.get(nodeA).add(nodeB);
                adjacencyList.get(nodeB).add(nodeA);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEdge(Node nodeA, Node nodeB) {
        if(nodeA.equals(nodeB)) {
            return false;
        }

        if(adjacencyList.containsKey(nodeA) && adjacencyList.containsKey(nodeB)) {
            if(adjacencyList.get(nodeA).contains(nodeB)) {
                adjacencyList.get(nodeA).remove(nodeB);
                adjacencyList.get(nodeB).remove(nodeA);
                return true;
            }
        }
        return false;
    }

    public List<Node> depthFirstSearch(Node node) {
        if(adjacencyList.containsKey(node)) {
            List<Node> stack = new ArrayList<>();
            List<Node> results = new ArrayList<>();
            Map<Node, Boolean> visited = new HashMap<>();

            stack.add(node);
            visited.put(node, true);
            while(!stack.isEmpty()) {
                Node current = stack.remove(stack.size() - 1);
                results.add(current);
                List<Node> neighbors = adjacencyList.get(current);

                for(Node neighbor : neighbors) {
                    if(!visited.containsKey(neighbor)) {
                        stack.add(neighbor);
                        visited.put(neighbor, true);

                    }
                }
            }

            return results;
        }
        return null;
    }

    public List<Node> breadthFirstSearch(Node node) {
        if(adjacencyList.containsKey(node)) {
            List<Node> queue = new ArrayList<>();
            List<Node> results = new ArrayList<>();
            Map<Node, Boolean> visited = new HashMap<>();
    
            queue.add(node);
            visited.put(node, true);
            while(!queue.isEmpty()) {
                Node current = queue.remove(0);
                results.add(current);
                List<Node> neighbors = adjacencyList.get(current);
    
                for(Node neighbor : neighbors) {
                    if(!visited.containsKey(neighbor)) {
                        queue.add(neighbor);
                        visited.put(neighbor, true);
    
                    }
                }
            }
            return results;
        }

        return null;
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }
}
