package Queue.zad11;

import java.io.*;
import java.util.*;


import java.util.NoSuchElementException;

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}


public class Consultations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nAps =  Integer.parseInt(br.readLine().trim());
        ArrayQueue<String> queueAps  = new ArrayQueue<String>(nAps);
        ArrayQueue<String> type = new ArrayQueue<String>(nAps);

        for (int i = 0; i < nAps; i++) {
            String[]parts = br.readLine().trim().split("\\s+");
            String name = parts[0];
            String t = parts[1];
            queueAps.enqueue(name);
            type.enqueue(t);

        }

        int nMMS =  Integer.parseInt(br.readLine().trim());
        ArrayQueue<String> queueMMS = new ArrayQueue<>(nMMS);
        for (int i = 0; i < nMMS; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            String name = parts[0];
            queueMMS.enqueue(name);
        }

        String name, pomTip, tip ="";
        if (!queueAps.isEmpty()){
            name =  queueAps.dequeue();
            System.out.println(name);
            tip = type.dequeue();
        }

        while (!queueAps.isEmpty()){
            name = queueAps.dequeue();
            pomTip = type.dequeue();
            if (tip.equals(pomTip)){
                queueAps.enqueue(name);
                type.enqueue(pomTip);
                if (!queueMMS.isEmpty()){
                    name =  queueMMS.dequeue();
                    System.out.println(name);
                }
            }else {
                System.out.println(name);
                tip = pomTip;
            }
        }

        while (!queueMMS.isEmpty()){
            name = queueMMS.dequeue();
            System.out.println(name);
        }



    }
}
