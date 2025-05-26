package Actividades.Avltree;
import Actividades.Exceptions.ItemDuplicated;
import java.util.Scanner;

public class TestAVL {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- MENÚ AVL ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Mostrar recorrido PreOrder");
            System.out.println("3. Ejecutar casos de prueba (RSR, RSL, RDL, RDR)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a insertar: ");
                    int dato = sc.nextInt();
                    try {
                        tree.insert(dato);
                        System.out.println("Elemento insertado correctamente.");
                    } catch (ItemDuplicated e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Recorrido PreOrder:");
                    tree.preOrder();
                    break;

                case 3:
                    ejecutarCasosDePrueba(tree);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void ejecutarCasosDePrueba(AVLTree<Integer> tree) {
        try {
            System.out.println("\nEjecutando caso RSR:");
            tree.insert(30);
            tree.insert(20);
            tree.insert(10);
            tree.preOrder();

            System.out.println("\nEjecutando caso RSL:");
            tree.insert(40);
            tree.insert(50);
            tree.preOrder();

            System.out.println("\nEjecutando caso RDL:");
            tree.insert(60);
            tree.insert(55);
            tree.preOrder();

            System.out.println("\nEjecutando caso RDR:");
            tree.insert(5);
            tree.insert(8);
            tree.preOrder();

            System.out.println("\nRotaciones extra:");
            tree.insert(1);
            tree.insert(70);
            tree.insert(54);
            tree.insert(6);
            tree.preOrder();

        } catch (ItemDuplicated e) {
            System.err.println("Dato duplicado en los casos de prueba: " + e.getMessage());
        }
    }
}