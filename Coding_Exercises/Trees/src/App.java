public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree  = new BinarySearchTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(7);
        tree.insert(11);
        tree.insert(13);

        BinaryHeap heap = new BinaryHeap();
        heap.insert(4);
        heap.insert(50);
        heap.insert(7);
        heap.insert(5);

        System.out.println(heap.findParent(7));
    }
}
