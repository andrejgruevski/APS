package Queue.zad10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

public class middtermSession {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayQueue<String> redMath = new ArrayQueue<>(10000);
        ArrayQueue<String> redOstanati = new ArrayQueue<>(10000);
        LinkedList<String> listRealMath = new LinkedList<>();

        int kapacitet = Integer.parseInt(br.readLine().trim());

        int brStudentiMath = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < brStudentiMath; i++) {
            String vlez = br.readLine().trim();
            redMath.enqueue(vlez);
        }

        int brOstanati = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < brOstanati; i++) {
            String vlez = br.readLine().trim();
            redOstanati.enqueue(vlez);
        }

        int brRealMath = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < brRealMath; i++) {
            String vlez = br.readLine().trim();
            listRealMath.add(vlez);
        }

        int termin = 1;

        while (!redMath.isEmpty() || !redOstanati.isEmpty()) {
            int filled = 0;
            StringBuilder out = new StringBuilder();

            while (filled < kapacitet && (!redMath.isEmpty() || !redOstanati.isEmpty())) {
                if (!redMath.isEmpty()) {
                    String s = redMath.peek();
                    if (listRealMath.contains(s)) {
                        out.append(s).append('\n');
                        redMath.dequeue();
                        filled++;
                    } else {
                        // мамел → префрли го на крај од „било кој термин“
                        redOstanati.enqueue(redMath.dequeue());
                    }
                } else {
                    // нема повеќе math → полни од останати
                    out.append(redOstanati.dequeue()).append('\n');
                    filled++;
                }
            }

            if (filled > 0) {
                System.out.println(termin);
                System.out.print(out.toString());
                termin++;
            } else {
                // Нема кој да се смести (теоретски ретко), излези
                break;
            }
        }
    }
}
