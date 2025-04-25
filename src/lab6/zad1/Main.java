package lab6.zad1;

//import java.util.Scanner;
//
//class Person {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "<<" + name + ", " + age + ">";
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && name.equals(person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return age * (int) name.charAt(0);
//    }
//}
//
//class Project {
//    private int time;
//    private int rate;
//
//    public Project(int time, int rate) {
//        this.time = time;
//        this.rate = rate;
//    }
//
//    public int getTotalPay() {
//        return time * rate;
//    }
//
//    @Override
//    public String toString() {
//        return "<" + time + ", " + rate + ">>";
//    }
//}
//
//class MapEntry<K, E> {
//    public K key;
//    public E value;
//
//    public MapEntry(K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    @Override
//    public String toString() {
//        return key + "," + value;
//    }
//}
//
//class SLLNode<E> {
//    public E element;
//    public SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//}
//
//class CBHT<K, E> {
//    private SLLNode<MapEntry<K, E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K, E>> search(K targetKey) {
//        int b = hash(targetKey);
//        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (curr.element.key.equals(targetKey))
//                return curr;
//        }
//        return null;
//    }
//
//    public void insert(K key, E val) {
//        int b = hash(key);
//        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (curr.element.key.equals(key)) {
//                curr.element.value = val;
//                return;
//            }
//        }
//        buckets[b] = new SLLNode<>(new MapEntry<>(key, val), buckets[b]);
//    }
//
//    public void delete(K key) {
//        int b = hash(key);
//        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
//            if (curr.element.key.equals(key)) {
//                if (pred == null)
//                    buckets[b] = curr.succ;
//                else
//                    pred.succ = curr.succ;
//                return;
//            }
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < buckets.length; i++) {
//            sb.append(i).append(":");
//            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
//                sb.append(curr.element).append(" ");
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Читање на бројот N
//        int N = Integer.parseInt(scanner.nextLine().trim());
//
//        CBHT<Person, Project> table = new CBHT<>(10);
//
//        for (int i = 0; i < N; i++) {
//            String[] input = scanner.nextLine().trim().split("\\s+");
//            String name = input[0];
//            int age = Integer.parseInt(input[1]);
//            int time = Integer.parseInt(input[2]);
//            int rate = Integer.parseInt(input[3]);
//
//            Person person = new Person(name, age);
//            Project project = new Project(time, rate);
//
//            int totalPay = project.getTotalPay();
//
//            if (table.search(person) == null) {
//                table.insert(person, project);
//            } else {
//                MapEntry<Person, Project> currentEntry = table.search(person).element;
//                if (currentEntry.value.getTotalPay() < totalPay) {
//                    table.insert(person, project);
//                }
//            }
//        }
//
//        System.out.println(table);
//    }
//}
//// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:
//// The following classes are already imported, copying classes here is not allowed, use them directly as when they are available in other local files:
//
//// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани
//// CBHT, OBHT, MapEntry, SLLNode are already imported
import java.util.Scanner;

// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи

// Create the helper classes for key and value here
// Fulfill the requirements from the text for the toString methods
// Additionally, make sure that your key class will implement the required
// hashCode and equals methods
class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
     this.name = name;
     this.age = age;
    }

    @Override
    public String toString() {
        // имплементирајте го toString методот според барањето во текстот
        // implement the toString method as requested in the text
        return "<<" + name + ", " + age + ">>";
    }

    // имплементирајте ги следните два методи за да работи табелата правилно
    // implement the following two methods to make the table work properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
    @Override
    public int hashCode() {
        return age * (int) name.charAt(0);
    }
}

class Project {
    private int time;
    private int rate;

    public Project(int time, int rate) {
        this.time = time;
        this.rate = rate;
    }
    public int getTotalPlay(){
        return time * rate;
    }


    @Override
    public String toString() {
        return "<" + time + ", " + rate + ">>";
    }
}
class MapEntry<K, E>{
    public K key;
    public E value;
    public MapEntry(K key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "," + value;
    }
}

class SLLNode<E>{
    public E element;
    public SLLNode<E> succ;
    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}
class CBHT<K,E>{
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash (K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search (K targetKey){
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ)
        {
            if (curr.element.key.equals(targetKey))
                return curr;
        }
        return null;
    }
    public void insert (K key, E val){
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ){
            if (curr.element.key.equals(key)){
                curr.element.value = val;
                return;
            }
        }
        buckets[b] = new SLLNode<>(new MapEntry<>(key,val),buckets[b]);
    }

    public void delete (K key){
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ){
            if (curr.element.key.equals(key)){
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            sb.append(i).append(":");
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr!=null; curr = curr.succ){
                sb.append(curr.element).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        CBHT<Person, Project> table = new CBHT<>(10);

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);
            int rate = Integer.parseInt(input[3]);
            Person person = new Person(name, age);
            Project project = new Project(time, rate);

            int totalPay = project.getTotalPlay();

            if (table.search(person) == null){
                table.insert(person, project);
            }else{
                MapEntry<Person, Project> currentEntry = table.search(person).element;
                if (currentEntry.value.getTotalPlay() < totalPay){
                    table.insert(person,project);
                }
            }
        }
        System.out.println(table);
    }
}