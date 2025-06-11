package Hash.zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

class MapEntry<K extends Comparable<K>, E> {
    // Each MapEntry object is a pair consisting of a key (a Comparable object)
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

 class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which iff any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
    }
}


//Потребно е да се направи компјутерска апликација со која ќе се забрза работењето на една аптека.
// Притоа апликацијата треба да му овозможи на корисникот (фармацевтот) брзо да пребарува низ огромното множество со лекови кои се внесени во системот.
// Начинот на кој тој треба да пребарува е следен: доволно е да ги внесе првите 3 букви од името на лекот за да може да му се излиста листа од лекови кои ги има во системот. Работата на фармацевтот е да провери дали внесениот лек го има во системот и да му даде информација на клиентот. Информацијата што треба да му ја даде на клиентот е дали лекот се наоѓа на позитивната листа на лекови, која е цената и колку парчиња од лекот има на залиха. Доколку лекот постои клиентот го нарачува со што кажува колку парчиња ќе купи. Оваа акција фармацевтот треба да ја евидентира на системот (односно да ја намали залихата на лекови за онолку парчиња колку што му издал на клиентот). Доколку нарачката на клиентот е поголема од залихата на лекот што ја има во системот, не се презема никаква акција.
//
//Влез: Од стандарден влез прво се дава број N кој претставува број на лекови кои ќе бидат внесени во системот.
// Во наредните N реда се дадени имињата на лековите, дали ги има на позитивната листа (1/0), цената и број на парчиња, сите разделени со по едно празно место.
// Потоа се даваат редови со имиња на лекови и број на парчиња нарачани од клиентот. За означување на крај се дава зборот KRAJ.
//
//Излез: На стандарден излез треба да се испечати за секој од влезовите следната информација: IME POZ/NEG CENA BR_LEKOVI.
// Доколку лекот не е најден се печати Nema takov lek. Доколку нарачката на клиентот е поголема од залихата се печати Nema dovolno lekovi инаку
// Napravena naracka.
//
//Забелешка: Задачата да се реши со хeш табела. Функцијата со која се врши мапирање на имињата на лековите во број е следна: h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780 каде зборот w=c1c2c3c4c5…. е составен од сите големи букви.
//
//Исто така за лековите да се направи посебна класа која како атрибути ќе ги има наведените карактеристики на лекот во системот.
//
//Име на класата: cbht.Apteka.
//
//For example:
//
//Input
//20
//ACEROLA 0 100 1000
//ACIKLOVIR 1 1650 87
//ACIPAN 1 300 25
//ADIMICIN 0 500 0
//VENTOR 1 0 25
//VALSACOR 1 1090 10
//TYVERB 0 62696 1
//ULCODIN 1 47 100
//TRICAL 0 0 0
//RUBENS 0 2315 0
//IBALGIN 1 0 100
//HYDROCYKLIN 0 55 10
//GENTAMICIN 1 152 90
//FORTEO 1 0 0
//FORVITAC 1 0 150
//CHIROCAINE 1 0 10
//BRONLES 1 0 0
//BELOGENT 0 143 30
//BEDOXIN 1 0 100
//HYDROCYKLIN20 0 113 20
//hydroCyklinn
//2
//hydroCyklin20
//2
//KRAJ
//
//Output Nema takov lek HYDROCYKLIN20 NEG 113 20 Napravena naracka

class Lek{
    public String ime;
    public  int zaliha;
    public int cena;
    public int kolichina;

    public Lek(String ime, int zaliha,int cena, int kolichina) {
        this.ime = ime;
        this.zaliha = zaliha;
        this.cena=cena;
        this.kolichina = kolichina;
    }
    boolean narachaj(int kolichina){
        if (kolichina > this.kolichina){
            return false;
        }else{
            this.kolichina -= kolichina;
            return true;
        }
    }
    public String toString(){
        return String.format("%s\n%s\n%d\n%d",ime.toUpperCase(), zaliha == 1 ? "POZ" : "NEG",cena,kolichina);
    }
}

public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        CBHT<String, Lek> cbht = new CBHT<String, Lek>(n);

        for (int i = 0; i < n; i++) {
            String [] s = br.readLine().split(" ");
            Lek lek = new Lek(s[0],Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));

            cbht.insert(lek.ime.toUpperCase(),lek);
        }

        while (true){
            String line = br.readLine();

            if (line.equals("KRAJ")){
                break;
            }

            int kolichina = Integer.parseInt(br.readLine());

            SLLNode<MapEntry<String, Lek>>  searchForKey = cbht.search(line.toUpperCase());
            if (searchForKey != null){
                Lek lek = searchForKey.element.value;
                System.out.println(lek);
                if (lek.narachaj(kolichina) ){
                    System.out.println("Narachkata e napravena");
                }else{
                    System.out.println("Nema dovolno lekovi");
                }
            }else{
                System.out.println("Nema takov lek");
            }

        }
    }
}
