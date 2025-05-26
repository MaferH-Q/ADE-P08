package Actividades.Exceptions;
// Excepción personalizada para cuando un dato no se encuentra en el BST
public class ItemNoFound extends Exception {

    // Constructor con mensaje personalizado
    public ItemNoFound(String msg) {
        super(msg);
    }

    // Constructor sin mensaje
    public ItemNoFound() {
        super("Elemento no encontrado en el árbol");
    }
}