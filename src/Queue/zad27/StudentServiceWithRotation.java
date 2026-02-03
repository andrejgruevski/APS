package Queue.zad27;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StudentServiceWithRotation {
    static class Student {
        String fullName;
        int doc;
        int idx;
        int sr;
        public Student(String fullName, int doc, int idx, int sr) {
            this.fullName = fullName;
            this.doc = doc;
            this.idx = idx;
            this.sr = sr;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Student> document = new LinkedList<Student>();
        Queue<Student> index = new LinkedList<Student>();
        Queue<Student> school = new LinkedList<Student>();
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String name = sc.nextLine();

            int doc = sc.nextInt();
            int idx = sc.nextInt();
            int sr = sc.nextInt();
            sc.nextLine();
            Student s = new Student(name,doc,idx,sr);

            if (doc == 1){
                document.add(s);
            }else if (idx == 1){
                index.add(s);
            }else if (sr == 1){
                school.add(s);
            }
        }

        int cycle = 0;
        while (!document.isEmpty() || !index.isEmpty() ||  !school.isEmpty()){
            if (cycle == 0){
                if (!document.isEmpty()){
                    Student student = document.remove();
                    student.doc = 0;
                    if (student.idx == 1){
                        index.add(student);
                    }else if (student.sr == 1){
                        school.add(student);
                    }else {
                        System.out.println(student.fullName);
                    }
                }

                if (!index.isEmpty()){
                    Student student = index.remove();
                    student.idx = 0;
                    if (student.sr == 1){
                        school.add(student);
                    }else {
                        System.out.println(student.fullName);
                    }
                }
                if (!school.isEmpty()){
                    Student student = school.remove();
                    student.sr = 0;
                    System.out.println(student.fullName);
                }
            }else if (cycle == 1){

                for (int i=0; i<2; i++){
                    if (!document.isEmpty()){
                        Student student = document.remove();
                        student.doc = 0;
                        if (student.idx == 1){
                            index.add(student);
                        }else if (student.sr == 1){
                            school.add(student);
                        }else {
                            System.out.println(student.fullName);
                        }
                    }
                }
                if (!index.isEmpty()){
                    Student student = index.remove();
                    student.idx = 0;
                    if (student.sr == 1){
                        school.add(student);
                    }else {
                        System.out.println(student.fullName);
                    }
                }
            }else if (cycle == 2){
                for (int i=0; i<2; i++){
                    if (!index.isEmpty()){
                        Student student = index.remove();
                        student.idx = 0;
                        if (student.sr == 1){
                            school.add(student);
                        }else {
                            System.out.println(student.fullName);
                        }
                    }
                }
                if (!school.isEmpty()){
                    Student student = school.remove();
                    student.sr = 0;
                    System.out.println(student.fullName);
                }
            }
            cycle = (cycle+1)%3;
        }
    }
}
