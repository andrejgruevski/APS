package Queue.zad16;

import java.util.NoSuchElementException;
import java.util.Scanner;

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

class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue() {
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
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

class Student {
    public String name;
    public String surname;
    public int d; // prilozhva dokumenti
    public int ind; // index;
    public int sd; // sredno dokumenti

    public Student(String name, String surname, int d, int ind, int sd) {
        this.name = name;
        this.surname = surname;
        this.d = d;
        this.ind = ind;
        this.sd = sd;
    }
}

public class StudentService2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedQueue<Student> nosiDokumenti = new LinkedQueue<Student>();
        LinkedQueue<Student> indeks = new LinkedQueue<Student>();
        LinkedQueue<Student> srednoDokumenti = new LinkedQueue<Student>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int d = sc.nextInt();
            int ind = sc.nextInt();
            int sd = sc.nextInt();

            Student student = new Student(name, surname, d, ind, sd);

            if (d == 1) {
                nosiDokumenti.enqueue(student);
            } else if (ind == 1) {
                indeks.enqueue(student);
            } else if (sd == 1) {
                srednoDokumenti.enqueue(student);
            }
        }

        while (!nosiDokumenti.isEmpty() || !indeks.isEmpty() || !srednoDokumenti.isEmpty()) {


                for (int i = 0; i < 2 && !nosiDokumenti.isEmpty(); i++) {
                    Student student = nosiDokumenti.dequeue();
                    student.d = 0;
                    if (student.ind == 1) {
                        indeks.enqueue(student);
                    } else if (student.sd == 1) {
                        srednoDokumenti.enqueue(student);
                    } else {
                        System.out.println(student.name + " " + student.surname);
                    }
                }


                for (int i = 0; i < 3 && !indeks.isEmpty(); i++) {
                    Student student = indeks.dequeue();
                    student.ind = 0;
                    if (student.sd == 1) {
                        srednoDokumenti.enqueue(student);
                    } else {
                        System.out.println(student.name + " " + student.surname);
                    }
                }

            if (!srednoDokumenti.isEmpty()) {
                Student student = srednoDokumenti.dequeue();
                student.sd = 0;
                System.out.println(student.name+" "+student.surname);

            }
        }

    }
}
