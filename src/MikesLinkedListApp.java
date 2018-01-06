import static java.lang.System.*;

public class MikesLinkedListApp {

    public static void main(String[] args) {
        out.println("Creating linked list");
        LinkedList ll = new LinkedList();
        ll.printListValues();

//        out.println("Creating linked list node 1");
        LinkedListNode node1 = new LinkedListNode(5);

        out.println("adding node 1 to list");
        ll.addFirst(node1);
        ll.printListValues();

//        out.println("Creating linked list node 2");
        LinkedListNode node2 = new LinkedListNode(7);

        out.println("adding node 2 to list");
        ll.addFirst(node2);
        ll.printListValues();

//        out.println("Creating linked list node 3");
        LinkedListNode node3 = new LinkedListNode(9);

        out.println("adding node 3 to list");
        ll.addFirst(node3);
        ll.printListValues();

//        out.println("Creating linked list node 4");
        LinkedListNode node4 = new LinkedListNode(13);

        out.println("adding node 4 to the end of the list");
        ll.addLast(node4);
        ll.printListValues();
    }
}
