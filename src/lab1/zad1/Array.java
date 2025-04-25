//За дадена низа од N цели броеви, да се избришат елементите со вредност помала од просекот на сите елементи во низата. На пример за низата 1, 2, 3, 4, 5 просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, што значи треба да се избришат елементите 1 и 2, што значи низата после оваа трансформација ќе биде 3, 4, 5.
//
//Влез: Првиот број од влезот е бројот на елементи во низата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
//
//        Излез: Низата пред и после направената трансформација.

package lab1.zad1;


import java.util.*;
public class Array {

    public static void main(String[] args) {
        Scanner vlez = new Scanner(System.in);
        int n = vlez.nextInt();;

        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            lista.add(vlez.nextInt());
        }

        int suma=0;

        for (int el : lista) {
            suma+=el;
        }

        double prosek =(double) suma/n;

        pechatiLista(lista);
        lista.removeIf(el -> el < prosek);
        pechatiLista(lista);

    }

    private static void pechatiLista(ArrayList<Integer> lista) {
        System.out.print("{");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}