package array.zad1;
import java.util.Scanner;
class SLLNode<E>{
    E element;
    SLLNode<E> succ;
    public SLLNode(E e, SLLNode<E> succ){
        this.element = e;
        this.succ = succ;
    }
}
class SLL<E>{
    SLLNode<E> first;

    //konstruktor za first (prviot)
    public SLL(){
        this.first = null;
    }

    public void vmetniPrv(E el){
        SLLNode<E> nov = new SLLNode(el, first);
        first = nov;
    }

    public String toString(){
        String s= new String();
        while(first != null){
            s += first.element + " ";
            first = first.succ;
        }
        return s;
    }
}

public class insertFirst {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //prajme lista so integeri
        SLL<Integer> lista = new SLL<Integer>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            //go vnesuvame sekoj element vo jazolot od listata
            int el = input.nextInt();
            lista.vmetniPrv(el);
        }
        System.out.println(lista.toString());
    }

}


