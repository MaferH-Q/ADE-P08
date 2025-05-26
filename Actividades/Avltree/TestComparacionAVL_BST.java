package Actividades.Avltree;
import Actividades.Exceptions.ItemDuplicated;

public class TestComparacionAVL_BST {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        int[] datos = {1, 2, 3, 4, 5, 6, 7};

        // Insertar los mismos datos en ambos árboles
        try {
            for (int val : datos) {
                bst.insert(val);
                avl.insert(val);
            }
        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }

        // Mostrar alturas
        System.out.println("Altura BST  : " + bst.height());
        System.out.println("Altura AVL  : " + avl.height());

        // Buscar el elemento 4
        System.out.println("Buscar 4 en BST: " + (bst.search(4) != null ? "Encontrado" : "No encontrado"));
        System.out.println("Buscar 4 en AVL: " + (avl.search(4) != null ? "Encontrado" : "No encontrado"));
    }
}
