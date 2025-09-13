public class Node<E> {
    private E element; // an element stored at this node
    private Node<E> parent; // a reference to the parent node (if any)
    private Node<E> left; // a reference to the left child (if any)
    private Node<E> right; // a reference to the right child (if any)

    public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
        element = e;
        parent = above;
        left = leftChild;
        right = rightChild;
    }

    public E getElement() throws IllegalStateException {
        if (parent == this) // convention for defunct node
            throw new IllegalStateException("Position no longer valid");
        return element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setElement(E e) {
        element = e;
    }

    public void setParent(Node<E> parentNode) {
        parent = parentNode;
    }

    public void setLeft(Node<E> leftChild) {
        left = leftChild;
    }

    public void setRight(Node<E> rightChild) {
        right = rightChild;
    }
} 
