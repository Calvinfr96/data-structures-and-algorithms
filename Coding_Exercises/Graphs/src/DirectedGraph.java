import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
  Map<Node, List<Node>> adjacencyList;
  
  public DirectedGraph() {
      adjacencyList = new HashMap<>();
  }

  public boolean addVertex(Node node) {
      if(adjacencyList.containsKey(node)) {
          return false;
      }

      adjacencyList.put(node, new ArrayList<>());
      return true;
  }

  public boolean deleteVertex(Node node) {
      if(!adjacencyList.containsKey(node)) {
          return false;
      }

      List<Node> neighbors = adjacencyList.get(node);
      while(!neighbors.isEmpty()) {
          deleteEdge(node, neighbors.get(0));
      }
      adjacencyList.remove(node);

      return true;
  }

  public boolean addEdge(Node nodeA, Node nodeB) {
      if(adjacencyList.containsKey(nodeA) && adjacencyList.containsKey(nodeB)) {
          if(!adjacencyList.get(nodeA).contains(nodeB)) {
              adjacencyList.get(nodeA).add(nodeB);
              return true;
          }
      }

      return false;
  }

  public boolean deleteEdge(Node nodeA, Node nodeB) {
      if(adjacencyList.containsKey(nodeA) && adjacencyList.containsKey(nodeB)) {
          if(!adjacencyList.get(nodeA).contains(nodeB)) {
              adjacencyList.get(nodeA).remove(nodeB);
              return true;
          }
      }

      return false;
  }

  public List<Node> breadthFirstSearch(Node node) {
      if(!adjacencyList.containsKey(node)) {
          return null;
      }

      List<Node> queue = new ArrayList<>();
      Map<Node, Boolean> visited = new HashMap<>();
      List<Node> results = new ArrayList<>();

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

  public List<Node> depthFirstSearch(Node node) {
      if(!adjacencyList.containsKey(node)) {
          return null;
      }

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

  @Override
  public String toString() {
      return adjacencyList.toString();
  }
}
