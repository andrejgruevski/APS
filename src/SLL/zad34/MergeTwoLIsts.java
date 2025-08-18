package SLL.zad34;
//
//import java.util.Scanner;
//
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
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int size() {
//        int listSize = 0;
//        SLLNode<E> tmp = first;
//        while(tmp != null) {
//            listSize++;
//            tmp = tmp.succ;
//        }
//        return listSize;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp.element;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += "->" + tmp.element;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, null);
//        ins.succ = first;
//        //SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//    public void insertBefore(E o, SLLNode<E> before) {
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first==before){
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before && tmp.succ!=null)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                tmp.succ = new SLLNode<E>(o, before);;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = new SLLNode<E>(o, null);
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (!tmp.element.equals(o) && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element.equals(o)) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return null;
//    }
//
//    public void merge (SLL<E> in){
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while(tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = in.getFirst();
//        }
//        else{
//            first = in.getFirst();
//        }
//    }
//
//    public void mirror() {
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            SLLNode<E> tmp = first;
//            SLLNode<E> newsucc = null;
//            SLLNode<E> next;
//
//            while(tmp != null){
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }
//    }
//}
//
public class MergeTwoLIsts {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        SLL<Integer> list1 = new SLL<>();
//        SLL<Integer> list2 = new SLL<>();
//        for (int i = 0; i < n; i++) {
//            list1.insertLast(sc.nextInt());
//        }
//        int m = sc.nextInt();
//        for (int i = 0; i<m; i++){
//            list2.insertLast(sc.nextInt());
//        }
//        SLL<Integer> list3 = new SLL<>();
//        SLLNode<Integer> iterator1 = list1.getFirst();
//        SLLNode<Integer> iterator2 = iterator1.succ;
//
//        while (iterator1.succ != null || iterator2.succ != null) {
////            list3.insertLast(iterator1.element);
////            iterator1 = iterator1.succ;
////            list1.delete(iterator1);
////
////            list3.insertLast(iterator1.element);
////            iterator1 = iterator1.succ;
////            list1.delete(iterator1.succ);
////
////            list3.insertLast(iterator2.element);
////            iterator2 = iterator2.succ;
////            list2.delete(iterator2);
////
////            list3.insertLast(iterator2.element);
////            iterator2 = iterator2.succ;
////            list2.delete(iterator2);
////        }
////
//        SLLNode<Integer> iterator3 = list2.getFirst();
//        SLLNode<Integer> iterator4 = iterator3.succ;
//
//        while (iterator1 != null && iterator3 != null) {
//            list3.insertLast(iterator1.element);
//            list3.insertLast(iterator2.element);
//            list3.insertLast(iterator3.element);
//            list3.insertLast(iterator4.element);
//            iterator1 = iterator1.succ.succ;
//            iterator2 = iterator2.succ.succ;
//            iterator3 = iterator3.succ.succ;
//            iterator4 = iterator4.succ.succ;
//        }
//        System.out.println(list3);
//    }
}
