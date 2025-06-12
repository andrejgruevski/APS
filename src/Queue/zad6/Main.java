package Queue.zad6;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.NoSuchElementException;
import java.util.Scanner;
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

//Студентска служба е посетена од студентите со цел да приложат/земат документи. Студентот може да приложи документи, да побара да си го земе индексот или пак да побара да си ги земе документите од средно. Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (еден студент што приложува документи, па еден студент што сака да си го земе индексот, па еден студент што сака да си ги земе документите од средно).
//
//Доколку студент чека ред за повеќе услуги кај студентската служба, тој чека ред првин во редицата за приложување на документи, потоа во редицата за земање на индекс и на крај во редицата за земање на документи од средно.
//
//
//Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат услужени од студентската служба. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали има потреба од дадена услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема потреба од услуга од тој тип.
//
//Пример:
//
//Иван Ивановски
//
//1
//
//1
//
//0
//
//значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.
//
//Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.

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

        LinkedQueue<Student> nosiDokumenti = new LinkedQueue<>();
        LinkedQueue<Student> index = new LinkedQueue<>();
        LinkedQueue<Student> zemaDokumenti = new LinkedQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int nosiDoc = sc.nextInt();
            int ind = sc.nextInt();
            int zemaDoc = sc.nextInt();
            Student student = new Student(name, surname, nosiDoc, ind, zemaDoc);

            if (nosiDoc == 1) nosiDokumenti.enqueue(student);
            else if (ind == 1) index.enqueue(student);
            else if (zemaDoc == 1) zemaDokumenti.enqueue(student);
        }

        while (!nosiDokumenti.isEmpty() || !index.isEmpty() || !zemaDokumenti.isEmpty()) {

            if (!nosiDokumenti.isEmpty()) {
                Student student = nosiDokumenti.dequeue();
                student.nosiDoc = 0;
                if (student.ind ==1) index.enqueue(student);
                else if (student.zemaDoc==1) {
                    zemaDokumenti.enqueue(student);
                }else{
                    System.out.println(student.name + " " + student.surname);
                }
            }
            if (!index.isEmpty()) {
                Student student = index.dequeue();
                student.ind = 0;
                if (student.zemaDoc == 1) {
                    zemaDokumenti.enqueue(student);
                }
                else if (student.nosiDoc == 0 && student.zemaDoc == 0){
                    System.out.println(student.name + " " + student.surname);
                }
            }

            if (!zemaDokumenti.isEmpty()) {
                Student student = zemaDokumenti.dequeue();
                student.zemaDoc = 0;
                if (student.nosiDoc == 0 && student.ind == 0){
                    System.out.println(student.name + " " + student.surname);
                }
            }
        }
    }

}
