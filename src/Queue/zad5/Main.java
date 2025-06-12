package Queue.zad5;

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
//Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги.
// Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја.
// Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите
// три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги бараат книга од тип Наука, па еден
// студент што бара книга од тип Научна фантастика, па два студенат што бараат книга од тип Историја).

//Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука,
// потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).

//Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга.
// Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3
// редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно),
// каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
//
//Пример:
//Иван Ивановски
//1
//1
//0
//значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
//Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.

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

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedQueue<Student> nauchna = new LinkedQueue<Student>();
        LinkedQueue<Student> scifi = new LinkedQueue<Student>();
        LinkedQueue<Student> istorija = new LinkedQueue<Student>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int s = sc.nextInt();
            int sf = sc.nextInt();
            int h = sc.nextInt();

            Student student = new Student(name, surname, s, sf, h);

            if (s == 1) nauchna.enqueue(student);
            else if (sf == 1) scifi.enqueue(student);
            else if (h == 1) istorija.enqueue(student);

        }

        while (!nauchna.isEmpty() || !scifi.isEmpty() || !istorija.isEmpty()) {

            for (int i = 0; i < 2 && !nauchna.isEmpty(); i++) {
                Student s = nauchna.dequeue();
                s.s = 0;
                if (s.sf == 1) scifi.enqueue(s);
                else if (s.h == 1) istorija.enqueue(s);
                else {
                    System.out.println(s.name + " " + s.surname);
                }
            }
            if (!scifi.isEmpty()) {
                Student s = scifi.dequeue();
                s.sf = 0;
                if (s.h == 1) istorija.enqueue(s);
                else if (s.s == 0 && s.h == 0) {
                    System.out.println(s.name + " " + s.surname);
                }
            }
            for (int i = 0; i < 2 && !istorija.isEmpty(); i++) {
                Student s = istorija.dequeue();
                s.h = 0;
                if (s.s == 0 && s.sf == 0) {
                    System.out.println(s.name + " " + s.surname);
                }
            }


        }


    }
}
