public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree  = new BinarySearchTree();
        int[] nums = {7,8,9,10,11,12,13};
        BsTNode<Integer> node = BinarySearchTree.createMinimalBST(nums);
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = node;

        tree.insert(10);
        tree.insert(8);
        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(7);
        tree.insert(11);
        tree.insert(13);

        BinaryHeap heap = new BinaryHeap();
        heap.insert(50);
        heap.insert(5);
        heap.insert(4);
        heap.insert(7);
        heap.insert(5);

        Trie trie = new Trie();
        System.out.println(trie.insert("Apple"));
        System.out.println(trie.insert("Apple"));
        System.out.println(trie.insert("Application"));
        System.out.println(trie.insert("Application"));
        System.out.println(trie.insert("App"));
        System.out.println(trie.remove("Zebra"));
        System.out.println(trie.remove("Apple"));
        System.out.println(trie.insert("Apple"));
        System.out.println(trie.isWord("Ap"));

    }
}
