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
    public BsTNode<Integer> root;

    public BinaryHeap() {
        root = null;
    }

    public BinaryHeap insert(Integer value) {
        add(value);
        return this;
    }

    public BsTNode<Integer> remove() {
        return null;
    }

    private void add(Integer value) {
        BsTNode<Integer> node = new BsTNode<>(value);
        if(Objects.isNull(root)) {
            root = node;
        } else {
            List<BsTNode<Integer>> queue = new ArrayList<>();
            queue.add(root);
    
            while(!queue.isEmpty()) {
                BsTNode<Integer> currentNode = queue.remove(0);
                if(!Objects.isNull(currentNode.left)) {
                    queue.add(currentNode.left);
                }
                if (Objects.isNull(currentNode.left)) {
                    currentNode.left = node;
                    break;
                }
    
                if(!Objects.isNull(currentNode.right)) {
                    queue.add(currentNode.right);
                }
                if (Objects.isNull(currentNode.right)) {
                    currentNode.right = node;
                    break;
                }
            }
        }
    }

    public BsTNode<Integer> findParent(Integer value) {
        List<BsTNode<Integer>> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BsTNode<Integer> parent = queue.remove(0);
            if(!Objects.isNull(parent.left)) {
                if(parent.left.value.equals(value)) {
                    return parent;
                }
                queue.add(parent.left);
            }
            if(!Objects.isNull(parent.right)) {
                if(parent.right.value.equals(value)) {
                    return parent;
                }
                queue.add(parent.right);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}