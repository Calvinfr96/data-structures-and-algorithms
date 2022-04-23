import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
* A Binary Heap can be a Min Binary Heap or a Max Binary Heap. The difference between the two is the ordering
* of the nodes. In a Max Heap, the root is the largest value. In a Min Heap, the root is the smallest value.
* Both heaps are considered complete binary trees.
* An important difference between Heaps and BSTs are that Heaps do not have guaranteed ordering amoung child nodes,
* whereas in BSTs child nodes are always in ascending order from left to right.
*/
public class BinaryHeap {
    public Node root;

    public BinaryHeap() {
        root = null;
    }

    public BinaryHeap insert(Integer value) {
        Node node = new Node(value);

        if(Objects.isNull(root)) {
            root = node;
        } else {
            List<Node> queue = new ArrayList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                Node current = queue.remove(0);
                if(!Objects.isNull(current.left)) {
                    queue.add(current.left);
                }
                if(Objects.isNull(current.left)) {
                    current.left = node;
                    node.parent = current;
                    break;
                }

                if(!Objects.isNull(current.right)) {
                    queue.add(current.right);
                }
                if(Objects.isNull(current.right)) {
                    current.right = node;
                    node.parent = current;
                    break;
                }
            }

            bubble(node);
        }
        return this;
    }

    public Integer remove() {
        Integer value = root.value;

        if(Objects.isNull(root)) {
            return null;
        }
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            root = null;
            return value;
        }

        Node lastNode = getLastNode();
        root.value = lastNode.value;
        deleteNode(lastNode);
        sink();

        return value;
    }

    private void bubble(Node node) {
        Node current = node;

        while(!Objects.isNull(current.parent) && current.value.compareTo(current.parent.value) < 0) {
            Integer value = current.value;
            current.value = current.parent.value;
            current.parent.value = value;

            current = current.parent;
        }
    }

    private void sink() {
        Node current = root;
        Node child = lesserChild(current);

        while(!Objects.isNull(child)) {
            Integer currentValue = current.value;
            current.value = child.value;
            child.value = currentValue;

            current = child;
            child = lesserChild(current);
        }
    }

    private List<Integer> breadthFirstSearch() {
        List<Integer> visited = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.remove(0);
            if(!Objects.isNull(current.left)) {
                queue.add(current.left);
            }
            if(!Objects.isNull(current.right)) {
                queue.add(current.right);
            }

            visited.add(current.value);
        }

        return visited;
    }

    private Node getLastNode() {
        List<Node> queue = new ArrayList<>();
        queue.add(root);

        Node current = null;
        while(!queue.isEmpty()) {
            current = queue.remove(0);
            if(!Objects.isNull(current.left)) {
                queue.add(current.left);
            }
            if(!Objects.isNull(current.right)) {
                queue.add(current.right);
            }
        }

        return current;
    }

    private void deleteNode(Node node) {
        Node parent = node.parent;
        if(!Objects.isNull(parent.left) && parent.left.value.equals(node.value)) {
            parent.left = null;
        }
        if(!Objects.isNull(parent.right) && parent.right.value.equals(node.value)) {
            parent.right = null;
        }
    }

    private Node lesserChild(Node node) {
        Node leftChild = node.left;
        Node rightChild = node.right;

        if(Objects.isNull(leftChild)) {
            if(!Objects.isNull(rightChild) && rightChild.value.compareTo(node.value) < 0) {
                return rightChild;
            }
            return null;
        } else if(Objects.isNull(rightChild)) {
            if(!Objects.isNull(leftChild) && leftChild.value.compareTo(node.value) < 0) {
                return leftChild;
            }
            return null;
        } else if(Objects.isNull(leftChild) && Objects.isNull(rightChild)) {
            return null;
        } else {
            return leftChild.value.compareTo(rightChild.value) < 0 ? leftChild : rightChild;
        }
    }

    @Override
    public String toString() {
        List<Integer> nodes = breadthFirstSearch();
        return nodes.toString();
    }

    public static class Node {
        public Integer value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        @Override
        public String toString() {
            return String.format("value: %d", value);
        }
    }
}