/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublelinkedlist;

/**
 *
 * @author Armando
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    /**
     * Clase interna que representa cada elemento (nodo) de la lista
     */
    class Node {
        int value;
        Node next;     
        Node prev; // Nuevo puntero hacia el nodo anterior
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    /**
     * Constructor que inicializa la lista con un primer nodo
     */
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }
    
    // ==========================================
    // MÉTODOS DE IMPRESIÓN Y LECTURA
    // ==========================================

    public void getHead() {
        if (head != null) System.out.println("Head: " + head.value);
    }

    public void getTail() {
        if (tail != null) System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
    
    /**
     * Imprime todos los valores de la lista en orden (hacia adelante)
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    // ==========================================
    // MÉTODOS DE INSERCIÓN
    // ==========================================

    /**
     * Agrega un nodo al final de la lista
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail; // Se enlaza hacia atrás
            tail = newNode;
        }
        length++;
    }
    
    /**
     * Agrega un nodo al inicio de la lista
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode; // Se enlaza el antiguo inicio hacia atrás
            head = newNode;
        }
        length++;
    }
    
    /**
     * Inserta un nodo en un índice específico
     */
    public boolean insert(int index, int value) {
        if (index < 1 || index > length + 1) return false;
        if (index == 1) {
            prepend(value);
            return true;
        } if (index == length + 1) {
            append(value);
            return true;
        }
        Node before = head;
        for (int i = 1; i < index - 1; i++) {
            before = before.next;
        }
        Node after = before.next;
        Node newNode = new Node(value);
        // Enlaces del nuevo nodo
        newNode.prev = before;
        newNode.next = after;
        // Actualizamos los nodos circundantes
        before.next = newNode;
        if (after != null) {
            after.prev = newNode;
        }
        length++;
        return true;
    }
    // ==========================================
    // MÉTODOS DE ELIMINACIÓN
    // ==========================================

    /**
     * Elimina el último nodo de la lista
     * Optimizado a O(1) gracias al puntero 'prev'
     */
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null; // Rompemos el enlace del nodo eliminado
        }
        length--;
        return temp;
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null; // Rompemos el enlace hacia atrás
            temp.next = null; // Aislar el nodo extraído
        }
        length--;
        return temp;
    }
    
    /**
     * Elimina un nodo en un índice específico (basado en 1)
     */
    public Node remove(int index) {
        if (index < 1 || index > length) return null;
        if (index == 1) return removeFirst();
        if (index == length) return removeLast();
        Node temp = getNode(index); // Utilizamos getNode para ubicarlo
        // Enlazamos el nodo anterior con el siguiente, saltando 'temp'
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        // Limpiamos los punteros de 'temp'
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    // ==========================================
    // MÉTODOS DE BÚSQUEDA Y UTILIDAD
    // ==========================================

    /**
     * Retorna el nodo ubicado en un índice específico
     */
    public Node getNode(int idx) {
        if (idx < 1 || idx > length) return null;
        Node tmp = head;
        // Optimización: si está en la primera mitad, busca desde head, sino desde tail
        if (idx <= length / 2) {
            for (int i = 1; i < idx; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = tail;
            for (int i = length; i > idx; i--) {
                tmp = tmp.prev;
            }
        }
        return tmp;
    }

    /**
     * Actualiza el valor de un nodo en un índice específico
     */
    public void setNode(int idx, int value) {
        Node tmp = getNode(idx);
        if (tmp != null) {
            tmp.value = value;
        }
    }

    /**
     * Encuentra el nodo central usando el algoritmo de la tortuga y la liebre
     */
    public Node medio() {
        Node pt1 = head;
        Node pt2 = head;
        while (pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
        }
        return pt1;
    }
    
    /**
     * Detecta si existe un ciclo infinito en la lista enlazada
     */
    public boolean ciclo() {
        Node pt1 = head;
        Node pt2 = head;
        while (pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
            if (pt1 == pt2) return true;
        } 
        return false;
    }
    
    /**
     * Invierte la dirección de los punteros de la lista
     */
    public void reverse() {
        if (length <= 1) return; 
        Node current = head;
        Node temp = null;
        // Intercambiar 'next' y 'prev' para todos los nodos
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            // Avanzar al siguiente nodo (que ahora es 'prev')
            current = current.prev;
        }
        // Finalmente, intercambiamos head y tail
        temp = head;
        head = tail;
        tail = temp;
    }
}
