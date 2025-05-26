package Actividades.Exceptions;

// Excepción personalizada cuando el árbol está vacío
public class ExceptionIsEmpty extends Exception {

    // Constructor con mensaje personalizado
    public ExceptionIsEmpty(String msg) {
        super(msg);
    }

    // Constructor sin mensaje
    public ExceptionIsEmpty() {
        super("El árbol está vacío");
    }
}