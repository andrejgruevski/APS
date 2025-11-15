package Queue.zad23;


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

class Student{
    public String name;
    public String surname;
    public int sci;
    public int sf;
    public int h;

    public Student(String name,String surname, int sci, int sf, int h) {
        this.name = name;
        this.surname= surname;
        this.sci =  sci;
        this.sf = sf;
        this.h = h;
    }

}
public class Library {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayQueue<Student> science = new ArrayQueue<>(100);
        ArrayQueue<Student> scfi = new ArrayQueue<>(100);
        ArrayQueue<Student> history = new ArrayQueue<>(100);

        for (int i =0; i<n; i++){
//            String parts[] = sc.next().trim().split(" ");

            String name = sc.next();
            String surname = sc.next();

            int sci = sc.nextInt();
            int sf = sc.nextInt();
            int h = sc.nextInt();
            Student student = new Student(name,surname,sci,sf,h);
            if (sci == 1) science.enqueue(student);
            else if (sf == 1) scfi.enqueue(student);
            else if (h == 1) history.enqueue(student);
        }

        while (!science.isEmpty()){
           Student student = science.dequeue();
           if (student.sf != 0){
               scfi.enqueue(student);
           }else if (student.h != 0){
               history.enqueue(student);
           }else{
               System.out.println(student.name +" "+student.surname);
           }
        }
        while (!scfi.isEmpty()){
            Student student = scfi.dequeue();
            if (student.h != 0){
                history.enqueue(student);
            }else{
                System.out.println(student.name +" "+student.surname);
            }
        }
        while (!history.isEmpty()){
            Student student = history.dequeue();
            System.out.println(student.name +" "+student.surname);
        }
    }
}
