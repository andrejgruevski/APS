package Queue.zad7;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.WeakHashMap;

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
 class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}
class Student {
    public String name,surname;
    int nosiDoc,ind,zemaDoc;

    public Student(String name, String surname, int nosiDoc, int ind, int zemaDoc) {
        this.name = name;
        this.surname = surname;
        this.nosiDoc = nosiDoc;
        this.ind = ind;
        this.zemaDoc = zemaDoc;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedQueue<Student> nosiDokumenti = new LinkedQueue<Student>();
        LinkedQueue<Student> index = new LinkedQueue<Student>();
        LinkedQueue<Student> zemaDokumenti = new LinkedQueue<Student>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int nosiDoc = sc.nextInt();
            int ind = sc.nextInt();
            int zemaDoc = sc.nextInt();

            Student s = new Student(name,surname,nosiDoc,ind,zemaDoc);

            if (nosiDoc == 1) nosiDokumenti.enqueue(s);
            else if (ind == 1 ) index.enqueue(s);
            else if (zemaDoc == 1) zemaDokumenti.enqueue(s);
        }
        while (!nosiDokumenti.isEmpty() || !index.isEmpty() || !zemaDokumenti.isEmpty()){

            for (int i =0; i<2 && !nosiDokumenti.isEmpty(); i++) {
                Student s = nosiDokumenti.dequeue();
                s.nosiDoc = 0;
                if (s.ind == 1) index.enqueue(s);
                else if (s.zemaDoc == 1) zemaDokumenti.enqueue(s);
                else{
                    System.out.println(s.name + " " + s.surname);
                }
            }
            for (int i =0; i<3 && !index.isEmpty(); i++) {
                Student s = index.dequeue();
                s.ind = 0;
                if (s.zemaDoc == 1) zemaDokumenti.enqueue(s);
                else if (s.nosiDoc == 0 && s.zemaDoc == 0) {
                    System.out.println(s.name + " " + s.surname);
                }
            }
            if (!zemaDokumenti.isEmpty()){
                Student s = zemaDokumenti.dequeue();
                s.zemaDoc = 0;
                if (s.nosiDoc == 0 && s.ind == 0){
                    System.out.println(s.name + " " + s.surname);
                }
            }
        }

    }
}
