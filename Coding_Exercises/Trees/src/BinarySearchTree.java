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
            node.parent = null;
        } else {
            BsTNode<Integer> currentNode = root;
            while(true) {
                if(value.equals(currentNode.value)) {
                    return null;
                }

                if(value.compareTo(currentNode.value) < 0) {
                    if(Objects.isNull(currentNode.left)) {
                        currentNode.left = node;
                        node.parent = currentNode;
                        return this;
                    } else {
                        currentNode = currentNode.left;
                    }
                }

                if(value.compareTo(currentNode.value) > 0) {
                    if(Objects.isNull(currentNode.right)) {
                        currentNode.right = node;
                        node.parent = currentNode;
                        return this;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        return this;
    }

    public BinarySearchTree remove(Integer value) {
        BsTNode<Integer> node = find(value);
        if(Objects.isNull(node)) {
            return this;
        }
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            root = null;
        }

        //If the node is a leaf node
        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            //If the node is left child, remove the left reference from its parent.
            if(node.equals(node.parent.left)) {
                node.parent.left = null;
            //If the node is right child, remove the right reference from its parent.
            } else {
                node.parent.right = null;
            }
        //If the node has two children
        } else if(!Objects.isNull(node.left) && !Objects.isNull(node.right)) {
            Integer successor = leftMostChild(node.right).value;
            remove(successor);
            node.value = successor;
        //If the node has one child
        } else {
            if(Objects.isNull(node.right)) {
                if(node.equals(node.parent.left)) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                }
            } else {
                if(node.equals(node.parent.left)) {
                    node.parent.left = node.right;
                } else {
                    node.parent.right = node.right;
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

    public boolean checkBalanced(BsTNode<Integer> node) {
        //A Binary tree is balanced if all nodes satisfy the following condition: The left and right subtrees cannot differ in height by more than one level.
        //The height of a node can be thought of simply as the number of nodes you can go down before hitting a leaf node.
        //A leaf node has a height of zero.
        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return true;
        }

        int leftHeight = !Objects.isNull(node.left) ? getHeight(node.left) : 0;
        int rightHeight = !Objects.isNull(node.right) ? getHeight(node.right) : 0;

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public int getHeight(BsTNode<Integer> node) {
        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return 0;
        }

        int leftHeight = !Objects.isNull(node.left) ? getHeight(node.left) + 1 : 0;
        int rightHeight = !Objects.isNull(node.right) ? getHeight(node.right) + 1 : 0;

        return Math.max(leftHeight, rightHeight);
    }

    public boolean validateBST(BsTNode<Integer> node) {
        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return true;
        }

        boolean leftResult  = !Objects.isNull(node.left) ? validateBST(node.left) : true;
        if(!leftResult) {
            return false;
        }
        boolean rightResult = !Objects.isNull(node.right) ? validateBST(node.right) : true;
        if(!rightResult) {
            return false;
        }

        boolean leftChild = !Objects.isNull(node.left) ? node.left.value < node.value : true;
        boolean rightChild = !Objects.isNull(node.right) ? node.right.value > node.value : true;

        return leftChild && rightChild;

        //NOTE: This solution doesn't work because it only checks the immediate children for validity and not the tree as whole.
        //Instead, you can run an in-order depth-first search and see if the list of nodes is sorted.
    }

    public BsTNode<Integer> inOrderSuccessor(BsTNode<Integer> node) {
        //The In-Order successor of a node is the leftmost node of its right subtree. This means that, when doing an In-Order traversal of a tree, it is the first node you visit on the node's right side.
        if(Objects.isNull(node)) {
            return null;
        }
        if(!Objects.isNull(node.right)) {
            return leftMostChild(node.right);
        } else {
            //If the node doesn't have a right subtree, it's in-order successor is the node for which it is a left child
            BsTNode<Integer> child = node;
            BsTNode<Integer> parent = child.parent;

            while(!Objects.isNull(parent) && parent.left != child) {
                child = parent;
                parent = parent.parent;
            }

            return parent;
        }
    }

    private BsTNode<Integer> leftMostChild(BsTNode<Integer> node) {
        if(Objects.isNull(node)) {
            return null;
        }

        while(!Objects.isNull(node.left)) {
            node = node.left;
        }
        return node;
    }

    public BsTNode<Integer> commonAncestor(BsTNode<Integer> a, BsTNode<Integer> b) {
        int delta = getDepth(a) - getDepth(b);
        BsTNode<Integer> shallowNode = delta > 0 ? b :a;
        BsTNode<Integer> deepNode = delta > 0 ? a : b;
        shallowNode = goUpBy(shallowNode, Math.abs(delta));

        while(shallowNode != deepNode && !Objects.isNull(shallowNode) && !Objects.isNull(deepNode)) {
            shallowNode = shallowNode.parent;
            deepNode = deepNode.parent;
        }

        return Objects.isNull(shallowNode) || Objects.isNull(deepNode) ? null : shallowNode;
    }

    private int getDepth(BsTNode<Integer> node) {
        int depth = 0;

        while(!Objects.isNull(node)) {
            node = node.parent;
            depth++;
        }

        return depth;
    }

    private BsTNode<Integer> goUpBy(BsTNode<Integer> node, int delta) {
        while(delta > 0 && !Objects.isNull(node)) {
            node = node.parent;
            delta--;
        }

        return node;
    }

    //Same problem, but without using a reference to the parent node.
    public BsTNode<Integer> commonAncestor(BsTNode<Integer> root, BsTNode<Integer> a, BsTNode<Integer> b) {
        if(!covers(root, a) || !covers(root, b)) {
            return null;
        }

        return commonAncestorHelper(root, a, b);
    }

    private BsTNode<Integer> commonAncestorHelper(BsTNode<Integer> root, BsTNode<Integer> a, BsTNode<Integer> b) {
        if(Objects.isNull(root) || root == a || root == b) {
            return root;
        }

        boolean aIsOnLeft = covers(root.left, a);
        boolean bIsOnLeft = covers(root.left, b);
        if(aIsOnLeft != bIsOnLeft) {
            return root;
        }

        BsTNode<Integer> childSide = aIsOnLeft ? root.left : root.right;
        return commonAncestorHelper(childSide, a, b);
    }

    private boolean covers(BsTNode<Integer> root, BsTNode<Integer> node) {
        if(Objects.isNull(root)) {
            return false;
        }
        if(root == node) {
            return true;
        }

        return covers(root.left, node) || covers(root.right, node);
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
