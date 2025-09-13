public class Test_LinkedBinTree {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> left = tree.addLeft(root, "B");
        Position<String> right = tree.addRight(root, "C");
        tree.addLeft(left, "D");
        tree.addRight(left, "E");
        tree.addLeft(right, "F");
        tree.addRight(right, "G");

        System.out.println("Size: " + tree.size()); // Size: 7
        System.out.println("Root: " + tree.root().getElement()); // Root: A
        System.out.println("Left child of root: " + tree.left(root).getElement()); // Left child of root: B
        System.out.println("Right child of root: " + tree.right(root).getElement()); // Right child of root: C
        System.out.println("Parent of left child: " + tree.parent(left).getElement());
        System.out.println();
    }
    
}
