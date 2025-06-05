package SLL.zad15;

import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
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
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
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

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}
class Orderr{
    private int id;
    private int product;
    private int priority;

    public Orderr(int id, int product, int priority) {
        this.id = id;
        this.product = product;
        this.priority = priority;
    }
    public int getId() {
        return id;
    }
    public int getProduct() {
        return product;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setProduct(int product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

//    Во рамки на една фабрика се користи систем за управуване со нарачки. За секоjа нарачка се чува податок за: іd на нарачката
//    (int id), продукт. (int product), како и приоритет (Int priority).
//    Приоритетот е вредност во ранг [1,10], каде што приоритет 1 означува највисок приоритет, а продукт е Id на соодветветниот
//          продукт кој се нарачува

//        Во рамки на еден ден во фабриката стигнуваат многу нарачки кои се чуваат во две еднострано поврзани листи.
//        Во првата листа се чуваат нарачките кои се активни (Active листата), а во втората листа се
//        чуваат нарачките кои се испратени за достава (Shipping листата)

//        Ваша задача е да испроцесирате две нарачки.
//        Процесирањето на нарачка се прави на следниот начин: се отстранува наjприоритетната нарачка од Active листата и
//        се става на крај на shipping листата

//        Внимавајте: Доколку има повеке нарачки со ист приоритет, се зема последната
//         Влез:
//        Во првиот ред е даден броот на нарачки од Active листата
//        Во вториот рел е ладен бро от на нарачки од Shipping листата
//        Во секој следен ред се дадени податоци за една нарачка, одделени со празно место, во формат іd product priorty.
//        Притоа, прво се дадени нарачките од Active листата, по што следуваат податоците за нарачките од Shipping листата

//        Излез:
//        Во првиот ред іd на сите нарачки од Аctive листата
//        Во вториот ред на id сите нарачки on Shipping листата
public class Order {

    public static void orders(SLL<Orderr> active, SLL<Orderr> shipping){
        SLLNode<Orderr> activeIterator = active.getFirst().succ;
        SLLNode<Orderr> najprioritna = active.getFirst();

        while (activeIterator != null) {
            if (activeIterator.element.getPriority() < najprioritna.element.getPriority()){
                najprioritna = activeIterator;
            }
            activeIterator = activeIterator.succ;
        }
        shipping.insertLast(active.delete(najprioritna));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Orderr> active = new SLL<Orderr>();
        SLL<Orderr> shipping  = new SLL<Orderr>();

        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            active.insertLast(new Orderr(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            shipping.insertLast(new Orderr(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        orders(active,shipping);
        System.out.println(active);
        System.out.println(shipping);

    }
}
