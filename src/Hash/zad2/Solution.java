package Hash.zad2;

import java.util.Scanner;

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return "<" + name + ", " + age + ">";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return this.age == person.age && this.name.equals(person.name);
    }
    @Override
    public int hashCode() {
        return name.charAt(0)  * age;
    }
}

class Project {
    int time;
    int rate;

    public Project(int time, int rate) {
        this.time = time;
        this.rate = rate;
    }

    public int salary(){
        return time * rate;
    }

    @Override
    public String toString() {
        return "<" + time + ", " + rate + ">";
    }
}

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        CBHT<Person,Project> table = new CBHT<>(10);


//        System.out.println(table);
    }
}

