package lab2.zad2;
import java.util.Scanner;
class DLLNode<E> {
    protected E element;
    protected int brPojavuvanja;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.brPojavuvanja=1;
    }

    @Override
    public String toString() {
        return element.toString() + "(Br. Pojavuvanja: " + this.brPojavuvanja + ")";
    }
}

 class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void izvadiDupliIPrebroj() {
        DLLNode<E> tmp = first;
        while(tmp!=null) {
            DLLNode<E> tmp1 = tmp.succ;
            while(tmp1!=null) {
                if(tmp.element.equals(tmp1.element)) {
                    this.delete(tmp1);
                    tmp.brPojavuvanja++;
                }
                tmp1 = tmp1.succ;
            }
            tmp = tmp.succ;
        }
    }

    public void mirror() {

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читање на бројот на елементи
        int N = scanner.nextInt();
        DLL<Integer> list = new DLL<>();

        // Читање на елементите и додавање во листата
        for (int i = 0; i < N; i++) {
            list.insertLast(scanner.nextInt());
        }

        // Читање на бројот на ротации
        int k = scanner.nextInt();

        // Ротација на листата k пати на лево
        rotateLeft(list, k);

        // Печатење на листата по ротацијата без Br. Pojavuvanja
        printListWithoutCount(list);

        scanner.close();
    }

    public static void rotateLeft(DLL<Integer> list, int k) {
        int size = list.getSize();
        k = k % size; // Оптимизација за да избегнеме непотребни ротации ако k е поголем од големината на листата

        for (int i = 0; i < k; i++) {
            Integer firstElement = list.deleteFirst();
            list.insertLast(firstElement);
        }
    }

    // Метод за печатење на листата без Br. Pojavuvanja
    public static void printListWithoutCount(DLL<Integer> list) {
        DLLNode<Integer> node = list.getFirst();
        while (node != null) {
            System.out.print(node.element);
            if (node.succ != null) {
                System.out.print("<->");
            }
            node = node.succ;
        }
        System.out.println();
    }
}