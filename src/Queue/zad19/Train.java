package Queue.zad19;

import java.util.*;

//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
//}
//
// interface Queue<E> {
//    // Elementi na redicata se objekti od proizvolen tip.
//    // Metodi za pristap:
//    public boolean isEmpty();
//    // Vrakja true ako i samo ako redicata e prazena.
//
//    public int size();
//    // Ja vrakja dolzinata na redicata.
//
//    public E peek();
//    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
//
//    // Metodi za transformacija:
//
//    public void clear();
//    // Ja prazni redicata.
//
//    public void enqueue(E x);
//    // Go dodava x na kraj od redicata.
//
//    public E dequeue();
//    // Go otstranuva i vrakja pochetniot element na redicata.
//}
// class LinkedQueue<E> implements Queue<E> {
//
//    // Redicata e pretstavena na sledniot nacin:
//    // length go sodrzi brojot na elementi.
//    // Elementite se zachuvuvaat vo jazli dod SLL
//    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
//    SLLNode<E> front, rear;
//    int length;
//
//    // Konstruktor ...
//
//    public LinkedQueue () {
//        clear();
//    }
//
//    public boolean isEmpty () {
//        // Vrakja true ako i samo ako redicata e prazena.
//        return (length == 0);
//    }
//
//    public int size () {
//        // Ja vrakja dolzinata na redicata.
//        return length;
//    }
//
//    public E peek () {
//        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
//        if (front == null)
//            throw new NoSuchElementException();
//        return front.element;
//    }
//
//    public void clear () {
//        // Ja prazni redicata.
//        front = rear = null;
//        length = 0;
//    }
//
//    public void enqueue (E x) {
//        // Go dodava x na kraj od redicata.
//        SLLNode<E> latest = new SLLNode<E>(x, null);
//        if (rear != null) {
//            rear.succ = latest;
//            rear = latest;
//        } else
//            front = rear = latest;
//        length++;
//    }
//
//    public E dequeue () {
//        // Go otstranuva i vrakja pochetniot element na redicata.
//        if (front != null) {
//            E frontmost = front.element;
//            front = front.succ;
//            if (front == null)  rear = null;
//            length--;
//            return frontmost;
//        } else
//            throw new NoSuchElementException();
//    }
//
//}
//class Voz{
//    public String registracija;
//    public String model;
//    public String operator;
//
//    public Voz(String reg, String model, String operator){
//        this.registracija = reg;
//        this.model=model;
//        this.operator=operator;
//    }
//}
public class Train {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,String> mapa = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[]parts = s.split(" ");
            String reg = parts[0];
            String model = parts[1];
            String operator = parts[2];

            mapa.put(reg, model + " "+ operator);
        }
        int w = Integer.parseInt(sc.nextLine());
        while (true){
            String s = sc.nextLine();
            String[]parts = s.trim().split(" ");
            if (s.equals("-1 closed")) break;
            int weight = Integer.parseInt(parts[0]);
            String tablica = parts[1];
            if (weight<w){
                System.out.println(mapa.get(tablica));
            }
        }
    }
}
