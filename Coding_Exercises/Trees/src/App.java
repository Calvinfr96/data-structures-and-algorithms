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

        System.out.println(tree);
        System.out.println(tree.root.left);
        System.out.println(tree.root.right);
    }
}
