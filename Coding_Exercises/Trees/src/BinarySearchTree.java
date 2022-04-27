import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
* Binary Search Trees:
* Each node ha at most two children.
* Specifically, the nodes in every left subtree must be less than their parent
* The nodes in every right subtree must be greater than their parent.
* Balanced: The distribution of nodes is fairly even, but not necessarily perfect.
* Complete: Every level of the tree is completely filled, except for (maybe) the last level. The last level should
* be filled left to right if it is not complete.
* Full: Every node has zero or two children.
* Perfect: All interior nodes have two children and all leaf nodes are at the same level (very rare).
*/
public class BinarySearchTree {
    public BsTNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree insert(Integer value) {
        final BsTNode<Integer> node = new BsTNode<>(value);

        if(Objects.isNull(root)) {
            root = node;
        } else {
            BsTNode<Integer> currentNode = root;
            while(true) {
                if(value.equals(currentNode.value)) {
                    return null;
                }

                if(value.compareTo(currentNode.value) < 0) {
                    if(Objects.isNull(currentNode.left)) {
                        currentNode.left = node;
                        return this;
                    } else {
                        currentNode = currentNode.left;
                    }
                }

                if(value.compareTo(currentNode.value) > 0) {
                    if(Objects.isNull(currentNode.right)) {
                        currentNode.right = node;
                        return this;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        return this;
    }

    public BsTNode<Integer> find(Integer value) {
        if(Objects.isNull(root)) {
            return null;
        }

        BsTNode<Integer> currentNode = root;
        while(!Objects.isNull(currentNode)) {
            if(value.equals(currentNode.value)) {
                return currentNode;
            } else if(value.compareTo(currentNode.value) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    public void breadthFirstSearch() {
        List<BsTNode<Integer>> visited = new ArrayList<>();
        List<BsTNode<Integer>> queue = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            BsTNode<Integer> node = queue.remove(0);
            if(!Objects.isNull(node.left)) {
                queue.add(node.left);
            }
            if(!Objects.isNull(node.right)) {
                queue.add(node.right);
            }

            visited.add(node);
        }

        printList(visited);
    }

    public void breadthFirstSearchR() {
        List<BsTNode<Integer>> visited = new ArrayList<>();
        List<BsTNode<Integer>> queue = new ArrayList<>();

        queue.add(root);
        traverse(queue, visited);
        printList(visited);
    }

    private void traverse(List<BsTNode<Integer>> queue, List<BsTNode<Integer>> visited) {
        BsTNode<Integer> node = queue.remove(0);
        if(!Objects.isNull(node.left)) {
            queue.add(node.left);
        }
        if(!Objects.isNull(node.right)) {
            queue.add(node.right);
        }

        visited.add(node);
        if(!queue.isEmpty()) {
            traverse(queue, visited);
        }
    }

    public void preOrderSearch() {
        List<BsTNode<Integer>> visited = new ArrayList<>();
        preOrderVisit(root, visited);
        printList(visited);
    }

    private void preOrderVisit(BsTNode<Integer> node, List<BsTNode<Integer>> visited) {
        visited.add(node);
        if(!Objects.isNull(node.left)) {
            preOrderVisit(node.left, visited);
        }
        if(!Objects.isNull(node.right)) {
            preOrderVisit(node.right, visited);
        }
    }

    public void inOrderSearch() {
        List<BsTNode<Integer>> visited = new ArrayList<>();
        inOrderVisit(root, visited);
        printList(visited);
    }

    private void inOrderVisit(BsTNode<Integer> node, List<BsTNode<Integer>> visited) {
        if(!Objects.isNull(node.left)) {
            inOrderVisit(node.left, visited);
        }
        visited.add(node);
        if(!Objects.isNull(node.right)) {
            inOrderVisit(node.right, visited);
        }
    }

    public void postOrderSearch() {
        List<BsTNode<Integer>> visited = new ArrayList<>();
        postOrderVisit(root, visited);
        printList(visited);
    }

    private void postOrderVisit(BsTNode<Integer> node, List<BsTNode<Integer>> visited) {
        if(!Objects.isNull(node.left)) {
            postOrderVisit(node.left, visited);
        }
        if(!Objects.isNull(node.right)) {
            postOrderVisit(node.right, visited);
        }
        visited.add(node);
    }

    public static BsTNode<Integer> createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static BsTNode<Integer> createMinimalBST(int[] array, int start, int end) {
        if(end < start) {
            return null;
        }

        int middle = (start + end) / 2;
        BsTNode<Integer> node = new BsTNode<Integer>(array[middle]);
        node.left = createMinimalBST(array, start, middle - 1);
        node.right = createMinimalBST(array, middle + 1, end);

        return node;
    }

    public List<List<BsTNode<Integer>>> createLevelList(BsTNode<Integer> root) {
        List<BsTNode<Integer>> queue = new ArrayList<>();
        List<List<BsTNode<Integer>>> result = new ArrayList<>();
        queue.add(root);

        while(true) {
            List<BsTNode<Integer>> listToAdd = new ArrayList<>();
            while(!queue.isEmpty()) {
                listToAdd.add(queue.remove(0));
            }
            if(listToAdd.isEmpty()) {
                break;
            }

            for(BsTNode<Integer> node : listToAdd) {
                if(!Objects.isNull(node.left)) {
                    queue.add(node.left);
                }
                if(!Objects.isNull(node.right)) {
                    queue.add(node.right);
                }
            }
            result.add(listToAdd);
        }

        return result;
    }

    private void printList(List<BsTNode<Integer>> visited) {
        for(BsTNode<Integer> node : visited) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
