package Queue.zad25;

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

//Наредени луѓе со број на барања, им се извршува едно барање и се враќаат назад во редот. Печати редослед на завршување на луѓето.
//
//Input
//5
//Nenad 3
//Slave 1
//Martin 2
//Ana 1
//Igor 2
//
//Output
//Slave
//Ana
//Martin
//Igor
//Nenad
class Person {
    public String name;
    public int br;

    public Person(String name, int br) {
        this.name = name;
        this.br = br;
    }

    @Override
    public String toString() {
        return name + " " + br;
    }

    public int getBr() {
        return br;
    }

    public String getName() {
        return name;
    }
}

public class Waiting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedQueue<Person> queue = new LinkedQueue<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            String name = line[0];
            int br = Integer.parseInt(line[1]);
            queue.enqueue(new Person(name, br));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Person p = queue.dequeue();
            p.br--;
            if (p.br == 0) sb.append(p.name).append("\n");
            else queue.enqueue(p);
        }
        System.out.println(sb);
    }
}
