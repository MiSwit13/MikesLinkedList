import static java.lang.System.*;

public class MikesLinkedListApp {

    public static void main(String[] args) {
        out.println("Creating linked list");
        LinkedList ll = new LinkedList();
        ll.printListValues();

        LinkedListNode node1 = new LinkedListNode(5);
        out.println("adding node 1 to list");
        ll.addFirst(node1);
        ll.printListValues();

        LinkedListNode node2 = new LinkedListNode(7);
        out.println("adding node 2 to list");
        ll.addFirst(node2);
        ll.printListValues();

        LinkedListNode node3 = new LinkedListNode(9);
        out.println("adding node 3 to list");
        ll.addFirst(node3);
        ll.printListValues();

        LinkedListNode node4 = new LinkedListNode(13);
        out.println("adding node 4 to the end of the list");
        ll.addLast(node4);
        ll.printListValues();
    }
}
