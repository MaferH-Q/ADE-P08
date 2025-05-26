package Actividades.Avltree;

// Clase base Node para BST y AVL, con atributos protegidos
public class Node<E> {
    protected E data;
    protected Node<E> left;
    protected Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}