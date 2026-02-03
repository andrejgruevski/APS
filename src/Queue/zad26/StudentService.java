package Queue.zad26;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StudentService {
    static class Student {
        private String fullName;
        private int sme;
        private int index;
        private int fS;

        public Student(String fullName, int sme, int index, int fS) {
            this.fullName = fullName;
            this.sme = sme;
            this.index = index;
            this.fS = fS;
        }

        public String getFullName() {
            return fullName;
        }

        public int getSme() {
            return sme;
        }

        public int getIndex() {
            return index;
        }

        public int getfS() {
            return fS;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Student> semester = new LinkedList<>();
        Queue<Student> gettingIndex = new LinkedList<>();
        Queue<Student> ftStudent = new LinkedList<>();

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String fullName = sc.nextLine();

            int sme = sc.nextInt();
            int index = sc.nextInt();
            int fS = sc.nextInt();
            sc.nextLine();


            Student s = new Student(fullName, sme, index, fS);
            if (sme == 1) {
                semester.add(s);
            } else if (index == 1) {
                gettingIndex.add(s);
            } else if (fS == 1) {
                ftStudent.add(s);
            }
        }

        int counter = 0;
        while (!semester.isEmpty() || !gettingIndex.isEmpty() || !ftStudent.isEmpty()) {

            for (int i = 0; i < 2 && !semester.isEmpty(); i++) {
                Student student = semester.remove();
                student.sme = 0;
                if (student.index == 1) {
                    gettingIndex.add(student);
                } else if (student.fS == 1) {
                    ftStudent.add(student);
                } else {
                    System.out.println(student.fullName);
                }
            }
            if (!gettingIndex.isEmpty()) {
                Student student = gettingIndex.remove();
                student.index = 0;
                if (student.fS == 1) {
                    ftStudent.add(student);
                } else {
                    System.out.println(student.fullName);
                }
            }
            if (!ftStudent.isEmpty()) {
                Student student = ftStudent.remove();
                student.fS = 0;
                System.out.println(student.fullName);
            }
        }


    }
}
