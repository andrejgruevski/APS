package Queue.zad13;

import java.io.*;
import java.util.*;
import java.util.NoSuchElementException;
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
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
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
class Student {
    public String name, surname;
    int s, sf, h;

    public Student(String name, String surname, int s, int sf, int h) {
        this.name = name;
        this.surname = surname;
        this.s = s;
        this.sf = sf;
        this.h = h;
    }
}

public class Library {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayQueue<Student> science = new ArrayQueue<>(100);
        ArrayQueue<Student> scfi = new ArrayQueue<>(100);
        ArrayQueue<Student> histroy = new ArrayQueue<>(100);

        for (int i =0; i<n; i++){
            String parts[] = br.readLine().trim().split(" ");

            String name = parts[0];
            String surname = parts[1];

            int s = Integer.parseInt(br.readLine().trim());
            int sf = Integer.parseInt(br.readLine().trim());
            int h = Integer.parseInt(br.readLine().trim());

            Student student = new Student(name,surname,s,sf,h);
            if (s == 1) science.enqueue(student);
            else if (sf == 1) scfi.enqueue(student);
            else if (h == 1) histroy.enqueue(student);
        }

        while (!science.isEmpty()) {
            Student student = science.dequeue();
            if (student.sf != 0){
                scfi.enqueue(student);
            }else if (student.h != 0){
                histroy.enqueue(student);
            }else{
                System.out.println(student.name +" "+student.surname);
            }
        }

        while (!scfi.isEmpty()) {
            Student student = scfi.dequeue();
            if (student.h != 0){
                histroy.enqueue(student);
            }else{
                System.out.println(student.name +" "+student.surname);
            }
        }
        while (!histroy.isEmpty()){
            Student student = histroy.dequeue();
            System.out.println(student.name +" "+student.surname);
        }

    }
}
