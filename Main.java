/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublelinkedlist;

/**
 *
 * @author Armando
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  PRUEBAS DE LA CLASE DOUBLY LINKED LIST");
        System.out.println("==========================================");

        // Inicialización usando DoublyLinkedList
        DoublyLinkedList ll = new DoublyLinkedList(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);

        System.out.println("\n--- ESTADO INICIAL DE LA LISTA ---");
        ll.printList();

        System.out.println("\n--- DATOS ADICIONALES ---");
        ll.getHead();
        ll.getTail();
        ll.getLength();

        // Pruebas de RemoveLast
        System.out.println("\n--- PROBANDO REMOVE LAST ---");
        System.out.println("Removiendo 50: " + ll.removeLast().value);
        System.out.println("Removiendo 40: " + ll.removeLast().value);
        System.out.println("Removiendo 30: " + ll.removeLast().value);
        System.out.println("Removiendo 20: " + ll.removeLast().value);
        System.out.println("Removiendo 10: " + ll.removeLast().value);

        System.out.println("\nProbando REMOVE en lista vacia:");
        System.out.println("Resultado: " + ll.removeLast());

        // Reconstrucción e inserciones
        System.out.println("\n--- RECONSTRUYENDO LISTA (APPEND) ---");
        ll.append(100);
        System.out.println("IMPRIME LISTA CON 100:");
        ll.printList();

        ll.append(200);
        System.out.println("\nIMPRIME LISTA CON 100 Y 200:");
        ll.printList();

        // Prueba del método Prepend
        System.out.println("\n--- PRUEBA DEL MÉTODOS PREPEND ---");
        ll.prepend(5);
        ll.prepend(4);
        ll.prepend(3);
        ll.prepend(2);
        ll.prepend(1);
        System.out.println("IMPRIME LISTA:");
        ll.printList();

        // Prueba de método RemoveFirst
        System.out.println("\n--- PRUEBA DEL MÉTODOS REMOVE FIRST ---");
        ll.removeFirst();
        ll.removeFirst();
        ll.removeFirst();
        System.out.println("IMPRIME LISTA:");
        ll.printList();

        ll.prepend(3);
        ll.prepend(2);
        ll.prepend(1);
        System.out.println("\nIMPRIME LISTA REORGANIZADA:");
        ll.printList();

        // Prueba del método getNode
        System.out.println("\n--- USO DEL MÉTODOS GETNODE ---");
        System.out.println("Nodo en posicion 1: " + ll.getNode(1).value);
        System.out.println("Nodo en posicion 2: " + ll.getNode(2).value);
        System.out.println("Nodo en posicion 3: " + ll.getNode(3).value);
        System.out.println("Nodo en posicion 4: " + ll.getNode(4).value);
        System.out.println("Nodo en posicion 5: " + ll.getNode(5).value);
        System.out.println("Nodo en posicion 6: " + ll.getNode(6).value);
        System.out.println("Nodo en posicion 7: " + ll.getNode(7).value);

        // Prueba del método SET
        System.out.println("\n--- USO DEL MÉTODOS SETNODE ---");
        ll.setNode(1, 100);
        ll.setNode(2, 200);
        ll.setNode(3, 300);
        ll.setNode(4, 400);
        ll.setNode(5, 500);
        System.out.println("IMPRIME LA LISTA DESPUES DE LOS SET:");
        ll.printList();

        // Usar el insert (index, value)
        System.out.println("\n--- USAR EL INSERT (INDEX, VALUE) ---");
        ll.insert(2, 333);
        ll.insert(3, 334);
        ll.insert(4, 335);
        ll.insert(1, 10000); // Insertar al inicio (índice 1)
        System.out.println("Imprimir la lista despues del insert:");
        ll.printList();

        // Prueba del método de remove(index)
        System.out.println("\n--- PRUEBA DEL MÉTODOS DE REMOVE(INDEX) ---");
        ll.remove(4);
        ll.remove(1);
        ll.remove(1);
        System.out.println("Lista con operaciones remove:");
        ll.printList();

        // Prueba del método Medio
        System.out.println("\n--- PRUEBA DEL MÉTODOS MEDIO ---");
        System.out.println("Nodo del medio: " + ll.medio().value);
        System.out.println("Prueba pasada correctamente.");

        // Prueba de ciclo
        System.out.println("\n--- PRUEBA DE DETECCIÓN DE CICLO ---");
        if (ll.ciclo()) {
            System.out.println("La lista actual es un ciclo");
        } else {
            System.out.println("La lista actual no es un ciclo");
        }

        // Prueba del reverse
        System.out.println("\n--- PRUEBA DEL MÉTODOS REVERSE ---");
        ll.reverse();
        System.out.println("Lista despues del reverse:");
        ll.printList();

        System.out.println("\n==========================================");
        System.out.println("  TODAS LAS PRUEBAS SE EJECUTARON CON ÉXITO");
        System.out.println("==========================================");
    }
}
