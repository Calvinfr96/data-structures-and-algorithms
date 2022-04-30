public class App {
    public static void minimalTree() {
        int[] nums = {7,8,9,10,11,12,13};
        BsTNode<Integer> node = BinarySearchTree.createMinimalBST(nums);
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = node;
        tree2.breadthFirstSearch();
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree tree  = new BinarySearchTree();
        minimalTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(7);
        tree.insert(11);
        tree.insert(13);
        tree.insert(30);
        tree.insert(31);

        BinaryHeap heap = new BinaryHeap();
        heap.insert(50);
        heap.insert(5);
        heap.insert(4);
        heap.insert(7);
        heap.insert(5);

        Trie trie = new Trie();
        trie.insert("Apple");
        trie.insert("Apple");
        trie.insert("Application");
        trie.insert("Application");
        trie.insert("App");
        trie.remove("Zebra");
        trie.remove("Apple");
        trie.insert("Apple");
        trie.isWord("Ap");

        //List of Depths
        System.out.println(tree.checkBalanced(tree.root));
    }
}
