package Actividades.Avltree;
import Actividades.Exceptions.ItemDuplicated;

public class BSTree<E extends Comparable<E>> {

    protected Node<E> root;

    // Inserción en BST sin balanceo
    public void insert(E x) throws ItemDuplicated {
        root = insert(x, root);
    }

    protected Node<E> insert(E x, Node<E> node) throws ItemDuplicated {
        if (node == null) return new Node<>(x);

        int cmp = x.compareTo(node.data);
        if (cmp < 0)
            node.left = insert(x, node.left);
        else if (cmp > 0)
            node.right = insert(x, node.right);
        else
            throw new ItemDuplicated(x + " ya se encuentra en el árbol...");
        return node;
    }

    // Búsqueda de un valor
    public Node<E> search(E x) {
        return search(x, root);
    }

    private Node<E> search(E x, Node<E> node) {
        if (node == null || node.data.equals(x)) return node;
        return x.compareTo(node.data) < 0 ? search(x, node.left) : search(x, node.right);
    }

    // Altura del árbol
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Recorrido preorden (para depuración)
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}