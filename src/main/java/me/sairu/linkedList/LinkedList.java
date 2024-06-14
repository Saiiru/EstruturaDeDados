package me.sairu.linkedList;

import org.w3c.dom.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    private int lenght;

    public LinkedList(String data) {
        lenght = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;

        }

    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void getLenght() {
        System.out.println("lenght: " + lenght);
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("head: " + head.data);
        }
    }

    public void makeEmpity() {
        head = null;
        tail = null;
        lenght = 0;

    }

    public void print() {
        Node aux = head;
        while (aux != null) {
            System.out.println(aux.data);
            aux = aux.next;
        }
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }
        lenght++;
    }

    public Node removeLast() {
        if (lenght == 0) {
            System.out.println("Lista vazia");
            return null;
        } else if (lenght == 1) {
            Node aux = head;
            head = null;
            tail = null;
            lenght--;
            return aux;
        } else {
            Node aux = head;
            while (aux.next != tail) {
                aux = aux.next;
            }
            aux.next = null;
            tail = aux;
            lenght--;
            return aux;
        }
    }

    public void preprend(String data) {
        Node newNode = new Node(data);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        lenght++;
    }

    public Node removeFirst() {
        if (lenght == 0) return null;
        Node aux = head;
        head = head.next;
        aux.next = null;
        lenght--;
        if (lenght == 0) {
            head = null;
            tail = null;
        }
        return aux;


    }

    public Node get(int index) {
        if (index < 0 || index >= lenght) {
            return null;

        }
        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux;
    }

    public boolean insert(int index, String data) {
        if (index < 0 || index > lenght) {
            return false;
        }
        if (index == lenght) {
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node aux = get(index - 1);
        newNode.next = aux.next;
        aux.next = newNode;
        lenght++;
        return true;
    }

    public boolean set(int index, String data) {
        Node aux = get(index);
        if (aux == null) {
            return false;
        }
        aux.data = data;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= lenght) return null;
        if (index == 0) return removeFirst();
        if (index == lenght - 1) return removeLast();

        Node prev = get(index - 1);
        Node aux = prev.next;

        prev.next = aux.next;
        aux.next = null;
        lenght--;

        return aux;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("Sairu");
        list.getHead();
        list.getTail();
        list.getLenght();
        list.append("lol");
        list.append("Batman");
        System.out.println("#########################################");
        list.print();
        System.out.println("#########################################");
        list.getHead();
        list.getTail();
        list.getLenght();
        System.out.println("#########################################");
        list.preprend("Superman");
//        System.out.println(list.removeLast().data );
        list.print();
        System.out.println("#########################################");
        System.out.println(list.removeFirst().data);
        System.out.println("#########################################");
        list.append("Deadpool");
        list.getHead();
        list.getTail();
        list.print();
        System.out.println("#########################################");
        System.out.println(list.get(2).data);
        System.out.println("#########################################");
        list.insert(3, "Hulk");
        list.print();
        System.out.println("#########################################");
        list.print();
        list.set(3, "Ironman");
        System.out.println("#########################################");
        list.print();
        System.out.println("#########################################");
        list.remove(1);
        list.print();

    }
}

