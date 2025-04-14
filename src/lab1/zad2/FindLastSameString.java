package lab1.zad2;
import java.util.Scanner;

public class FindLastSameString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the list
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        SLL<String> list = new SLL<>();

        // Input the elements of the list
        for (int i = 0; i < N; i++) {
            String element = scanner.nextLine();
            list.insertLast(element);
        }

        // Input the integer L
        int L = scanner.nextInt(); // Read the integer L

        // Output the original list
        System.out.println(list);

        // Move the last node with exactly L characters to the front
        moveLastLToFront(list, L);

        // Output the modified list
        System.out.println(list);
    }

    public static void moveLastLToFront(SLL<String> list, int L) {
        SLLNode<String> current = list.getFirst();
        SLLNode<String> lastValidNode = null;

        // Traverse the list to find the last node with exactly L characters
        while (current != null) {
            if (current.element.length() == L) {
                lastValidNode = current; // Update lastValidNode
            }
            current = current.succ;
        }

        // If a valid node was found
        if (lastValidNode != null) {
            // Find the previous node to the lastValidNode
            current = list.getFirst();
            SLLNode<String> previous = null;

            while (current != null && current != lastValidNode) {
                previous = current;
                current = current.succ;
            }

            // If lastValidNode is not the first node, we need to remove it
            if (previous != null) {
                previous.succ = lastValidNode.succ; // Remove lastValidNode from its current position
            } else {
                // If it is the first node, just delete it from the front
                list.deleteFirst();
            }

            // Insert lastValidNode at the front of the list
            list.insertFirst(lastValidNode.element);
        }
    }
}

// SLLNode class
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

// SLL class
class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret.append(tmp.element);
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append("->").append(tmp.element);
            }
        } else {
            ret.append("Prazna lista!!!"); // Empty list
        }
        return ret.toString();
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<>(o, null);
        ins.succ = first;
        first = ins;
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<>(o, null);
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
            System.out.println("Listata e prazna"); // The list is empty
            return null;
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }
}