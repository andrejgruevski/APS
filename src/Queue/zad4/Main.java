package Queue.zad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа првин се услужени студентите кои чекаат ред за книга од тип Наука, потоа студентите кои чекаат ред за книга од тип научна фантастика и на крај студентите кои чекаат ред за книга од тип Историја.
//
//Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
//
//
//Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
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
//значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
//
//Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedQueue<String> science = new LinkedQueue<String>();
        LinkedQueue<String> scfi = new LinkedQueue<String>();
        LinkedQueue<String> history = new LinkedQueue<String>();

        try {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String name = br.readLine();

                int s = Integer.parseInt(br.readLine());
                int sf = Integer.parseInt(br.readLine());
                int h = Integer.parseInt(br.readLine());

                if (s == 1) science.enqueue(name);
                if (s == 2) scfi.enqueue(name);
                if (s == 3) history.enqueue(name);
            }
            while (!science.isEmpty()){
                System.out.println(science.dequeue());
            }
            while (!scfi.isEmpty()){
                System.out.println(scfi.dequeue());
            }
            while (!history.isEmpty()){
                System.out.println(history.dequeue());
            }
        }catch (Exception e){
            System.out.println("Input error.");
        }

    }
}
