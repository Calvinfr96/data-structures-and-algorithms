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

    

    @Override
    public String toString() {
        return root.toString();
    }
}
