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
        //A Binary Heap is a complete Binary Tree, so to insert a node, you need to make sure all nodes are filled
        //optimally (have two children). To insert a node, you perform a BFS on the heap until you find a node with
        //a null left child or a null right child. Once an empty slot is found, you add the node there.

        //After inserting the node, you need to adjust its position such that the Binary Heap property is maintained
        //(every node is greater than the root of its left and right subtree).

        //To maintain this property, you nned to 'bubble up' the newly inserted node as long as it is greater than its parent node.
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
        //If the heap is empty, return null
        if(Objects.isNull(root)) {
            return null;
        }
        
        //If the root has no children, set it to null.
        Integer value = root.value;
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            root = null;
            return value;
        }

        //Gets the last node in the heap.
        Node lastNode = getLastNode();
        //Replaces the root's value with the last node's value.
        root.value = lastNode.value;
        //Deletes the last node in the heap.
        deleteNode(lastNode);
        //You maintain the Binary Heap property by 'sinking' the root node down into its proper position
        sink();

        return value;
    }

    private void bubble(Node node) {
        //We are constructing a Min Binary Heap, so we need to bubble up as long as a child node is less than its parent
        Node current = node;

        //while the child is less than the parent, we swap their values and update current to be current.parent.
        while(!Objects.isNull(current.parent) && current.value.compareTo(current.parent.value) < 0) {
            Integer value = current.value;
            current.value = current.parent.value;
            current.parent.value = value;

            current = current.parent;
        }
    }

    private void sink() {
        Node current = root;
        //You find the nodes child that has the lowest value.
        Node child = lesserChild(current);
        
        //While the child node is not null, you swap the current node with its child node and repeat the process,
        //looking for the child node's lesser child and swapping it.
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
        //Gets the last node in the heap, which is the right-most leaf node.
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

        //If both children are null (a leaf node), return null.
        if(Objects.isNull(leftChild) && Objects.isNull(rightChild)) {
            return null;
        } else if(Objects.isNull(leftChild)) {
            //If the left child is null, the right child must be less than the current node's value.
            if(!Objects.isNull(rightChild) && rightChild.value.compareTo(node.value) < 0) {
                return rightChild;
            }
            //If the left child is null and the right child is greater than the current node, there is no lesser child.
            return null;
        } else if(Objects.isNull(rightChild)) {
            //If the right child is nul, the left child must be less than the current node.
            if(!Objects.isNull(leftChild) && leftChild.value.compareTo(node.value) < 0) {
                return leftChild;
            }
            //If this is not the case, there is no lesser child.
            return null;
        } else {
            //If neither child node is null, return the one with the lower value.
            return leftChild.value.compareTo(rightChild.value) < 0 ? leftChild : rightChild;
        }
    }

    @Override
    public String toString() {
        if(Objects.isNull(root)) {
            return "empty";
        }
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