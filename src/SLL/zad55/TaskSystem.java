package SLL.zad55;

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
class Task {
    public int id;
    public int hours;
    public int priority;
    public Task(int id, int hours, int priority){
        this.id = id;
        this.hours=hours;
        this.priority=priority;
    }

    public String toString(){
        return id +" " + hours +" "+ priority;
    }
    double importance(){
        return 2 * hours * priority;
    }
}

public class TaskSystem {
    public static void work(SLL<Task> toDo, SLL<Task> inProgress){
        SLLNode<Task> iterator1 = toDo.getFirst();
        SLLNode<Task> iterator2 = inProgress.getFirst();

        SLLNode<Task> najbiten = null;
        SLLNode<Task> najNebiten = null;
        while (iterator1 !=null){

            if (iterator1.element.importance() > iterator1.succ.element.importance()){
                najbiten = iterator1;
            }
            iterator1 = iterator1.succ;
        }
        while (iterator2!=null){
            if (iterator2.element.importance() < iterator2.succ.element.importance()){
                najNebiten =iterator2;
            }
            iterator2 = iterator2.succ;
        }
        iterator1 = toDo.getFirst();
        iterator2 = inProgress.getFirst();

        while (iterator1!=null){
            if (iterator1.element.equals(najbiten.element)){
                inProgress.insertFirst(iterator1.element);
                toDo.delete(iterator1);
            }
            iterator1 = iterator1.succ;
        }
        while (iterator2!=null){
            if (iterator2.element.equals(najNebiten.element)){
                toDo.insertLast(iterator2.element);
                inProgress.delete(iterator2);
            }
            iterator2 = iterator2.succ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        SLL<Task> toDo = new SLL<>();
        SLL<Task> inProgress = new SLL<>();

        for (int i = 0; i < n; i++) {
//            String []line = sc.nextLine().trim().split(" ");
            int id  = sc.nextInt();
            int hours = sc.nextInt();
            int priority = sc.nextInt();
            Task toDoTasks = new Task(id, hours, priority);
            toDo.insertLast(toDoTasks);
        }
        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int hours = sc.nextInt();
            int priority = sc.nextInt();
            Task inProgressTask = new  Task(id, hours, priority);
            inProgress.insertLast(inProgressTask);
        }


        SLLNode<Task> curr = toDo.getFirst();
        while (curr != null) {
            System.out.print(curr.element.id);
            if (curr.succ != null) System.out.print(" ");
            curr = curr.succ;
        }
        System.out.println();

        curr = inProgress.getFirst();
        while (curr != null) {
            System.out.print(curr.element.id);
            if (curr.succ != null) System.out.print(" ");
            curr = curr.succ;
        }
        System.out.println();
    }

//3
//3
//111 1 1
//222 2 4
//333 1 1
//444 2 7
//555 4 6
//666 2 9
}
