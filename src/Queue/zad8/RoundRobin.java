package Queue.zad8;

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

 class Process{
    public String name;
    public int executionTime;
    public int arrivalTime;

    Process(String name, int executionTime, int arrivalTime) {
        this.name = name;
        this.executionTime = executionTime;
        this.arrivalTime = arrivalTime;
    }

}

public class RoundRobin {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        Process[] processes = new Process[N];

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            String name = parts[0];
            int executionTime = Integer.parseInt(parts[1]);
            int arrivalTime = Integer.parseInt(parts[2]);
            processes[i] = new Process(name, executionTime, arrivalTime);
        }

        int T = Integer.parseInt(br.readLine().trim());

        Arrays.sort(processes, (a, b) -> {
            if (a.arrivalTime != b.arrivalTime)
                return Integer.compare(a.arrivalTime, b.arrivalTime);
            return Integer.compare(b.executionTime, a.executionTime);
        });

        ArrayQueue<Process> ready = new ArrayQueue<>(N);
        StringBuilder sb = new StringBuilder();

        int time = 0;
        int index = 0;

        if (N > 0 && processes[0].arrivalTime > time) {
            time = processes[0].arrivalTime;
        }

        while (index < N && processes[index].arrivalTime <= time) {
            ready.enqueue(processes[index++]);
        }

        while (!ready.isEmpty() || index < N) {
            if (ready.isEmpty()) {
                time = Math.max(time, processes[index].arrivalTime);
                while (index < N && processes[index].arrivalTime <= time) {
                    ready.enqueue(processes[index++]);
                }
                continue;
            }

            Process p = ready.dequeue();

            if (sb.length() > 0) sb.append(' ');
            sb.append(p.name);

            int run = Math.min(T, p.executionTime);
            p.executionTime -= run;
            time += run;

            while (index < N && processes[index].arrivalTime <= time) {
                ready.enqueue(processes[index++]);
            }

            if (p.executionTime > 0) {
                ready.enqueue(p);
            }
        }

        System.out.println(sb.toString());
    }
}