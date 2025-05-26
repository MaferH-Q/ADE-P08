package Actividades.Exceptions;
// Excepción personalizada para datos duplicados en el BST o AVL
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String msg) {
        super(msg);
    }

    public ItemDuplicated() {
        super("Elemento duplicado en el árbol");
    }
}