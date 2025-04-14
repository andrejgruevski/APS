package Voved_vo_Java;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Vnesi eden cel broj");
        int broj=input.nextInt();
//        System.out.println("Vneseniot broj e: "+broj);


        Box<Integer> kutija1=new Box<Integer>();
        kutija1.setObjekt(broj);
        Box<String>kutija2= new Box<String>(" Zhaaaba ");

        System.out.println(kutija1.toString());
        System.out.println(kutija2.toString());

        Box<Televizor>kutijaSoTElevizor= new Box<Televizor>(); //napravete kutija koja mozhime vo nea da stavime televizor
        Televizor   t1=new Televizor("LG",40,true); // megjuvreme pravime televizor i kazhuvame primer (neka bide lg neka e smart)
        kutijaSoTElevizor.setObjekt(t1); // vo kutijata televizor setiraj go objektot , stavi go televizorot

        System.out.println("Televizorot e "+t1);
        System.out.println("Kutija so televizor: "+kutijaSoTElevizor);
    }

    }

