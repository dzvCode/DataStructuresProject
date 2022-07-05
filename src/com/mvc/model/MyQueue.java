package com.mvc.model;

public class MyQueue {
    public static int capacidad = 4;
    public static int contador;
    public static Node front, rear;
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

//    public MyQueue() {
//        front = rear = null;
//        contador = 0;
//    }

    // Metodo para encolar un nodo
    public static void enqueue(int data) {
        if (contador > capacidad) {
            System.out.println("Max capacity");
            return;
        }

        Node newNode = new Node(data);
        // Si la cola esta vacia, el nuevo nodo es front y rear
        if (front == null) {
            front = rear = newNode;
            contador++;
            return;
        }

        // Añade el nuevo nodo al final de la cola y actualiza rear
        rear.next = newNode;
        rear = newNode;
        contador++;
    }

    // Metodo para desencolar un nodo
    public static void dequeue() {
        // Si la cola esta vacia
        if (front == null) return;

        // Guarda front previo y lo mueve un nodo adelante
        //Node temp = front;
        front = front.next;
        contador--;

        // Si front es null, tambien rear es null
        if (front == null) {
            rear = null;
        }
    }

    public static void display() {

        System.out.println("Cantidad: " + Integer.toString(contador));
        if (front == null) {
            System.out.println("Cola vacia");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
