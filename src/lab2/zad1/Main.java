package lab2.zad1;

import java.util.Scanner;
class Node{
    int data;
    Node prev, next;

    public Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;
    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int prosekNaElementi() {
        int brojach = 0;
        int totalSuma = 0;

        Node segashen  = head;
        while (segashen != null) {
            totalSuma += segashen.data;
            segashen = segashen.next;
        }

        int sumaPred=0;
        int brojachPred=0;

        segashen = head;
        while (segashen != null) {
            int sumaPosle = totalSuma - sumaPred - segashen.data;
            int brojachPosle = size - brojachPred - 1;

            double prosekPred = (brojachPred == 0) ? Double.MIN_VALUE: (double) sumaPred / brojachPred;
            double prosekPosle = (brojachPosle == 0) ? Double.MAX_VALUE : (double) sumaPosle / brojachPosle;

            if (prosekPred > prosekPosle) {
                brojach++;
            }
            sumaPred += segashen.data;
            brojachPred++;
            segashen = segashen.next;
        }
        return brojach;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DoublyLinkedList lista = new DoublyLinkedList();

        for (int i = 0; i < n; i++) {
            lista.add(input.nextInt());
        }
        int rezultat = lista.prosekNaElementi();
        System.out.println(rezultat);
    }
}