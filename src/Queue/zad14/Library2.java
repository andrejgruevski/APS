package Queue.zad14;

import java.util.NoSuchElementException;
import java.util.Scanner;

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
class Student{
     public String name;
     public String surname;
     public int s;
     public int sf;
     public int h;

     public Student(String name, String surname, int s,int sf,int h){
         this.name=name;
         this.surname=surname;
         this.s=s;
         this.sf = sf;
         this.h = h;
     }
}


public class Library2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedQueue<Student> science = new LinkedQueue<>();
        LinkedQueue<Student> scfi = new LinkedQueue<>();
        LinkedQueue<Student> history = new LinkedQueue<>();

        for (int i =0; i<n; i++){
            String name = sc.next();
            String surname = sc.next();
            int s = sc.nextInt();
            int sf = sc.nextInt();
            int h = sc.nextInt();

            Student student = new Student(name,surname,s,sf,h);

            if (s == 1){
                science.enqueue(student);
            }else if (sf == 1){
                scfi.enqueue(student);
            }else if (h == 1){
                history.enqueue(student);
            }
        }

        while (!science.isEmpty() || !scfi.isEmpty() || !history.isEmpty()){

                for (int i =0; i<2 && !science.isEmpty(); i++ ){
                    Student student = science.dequeue();
                    student.s = 0;
                    if (student.sf == 1) scfi.enqueue(student);
                    else if (student.h == 1) history.enqueue(student);
                    else{
                        System.out.println(student.name +" "+student.surname);
                    }
                }
                if (!scfi.isEmpty()){
                    Student student = scfi.dequeue();
                    student.sf = 0;
                    if (student.h == 1) history.enqueue(student);
                    else if ( student.s == 0 && student.h == 0){
                        System.out.println(student.name +" "+student.surname);
                    }
                }
                for (int i =0; i<2 && !history.isEmpty(); i++ ){
                    Student student = history.dequeue();
                    student.h = 0;
                    if (student.s == 0 && student.sf == 0){
                        System.out.println(student.name+ " "+student.surname);
                    }
                }
        }


    }
}
