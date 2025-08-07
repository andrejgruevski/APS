package Stack.zad12;
import java.util.*;

class Book{
    public String title;
    public int count;

    Book(String title,int count){
        this.title=title;
        this.count=count;
    }
    @Override
    public String toString(){
        return title + " " + count;
    }
}
public class ExamSesion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //number of books;
        int n = sc.nextInt(); // number of exams
        sc.nextLine();

        String [] books = sc.nextLine().split(" ");
        String [] exams  = sc.nextLine().split(" ");

        Stack<Book> stack = new Stack<Book>();
        Stack<Book> tmp = new Stack<Book>();

        Book[]bookArray = new Book[m];
        for (int i = 0; i < m; i++) {
            bookArray[i]= new Book(books[i],0);
            stack.push(bookArray[i]);
        }

        for (String exam : exams) {

            while (!stack.isEmpty() && !stack.peek().title.equals(exam)){
                Book book = stack.pop();
                book.count++;
                tmp.push(book);
            }

            Book kniga = stack.pop();
            kniga.count++;

            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
            stack.push(kniga);
        }
        for (Book book : bookArray) {
            System.out.println(book);
        }

    }
}
