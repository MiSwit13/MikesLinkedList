import static java.lang.System.*;

public class MikesLinkedListApp {

    public static void main(String[] args) {
        LinkedList LL1 = new LinkedList();
        LL1.printListValues();

        LinkedListNode node1 = new LinkedListNode(5);
        LL1.addFirst(node1);
        LL1.printListValues();

        LinkedListNode node2 = new LinkedListNode(7);
        LL1.addFirst(node2);
        LL1.printListValues();

        LinkedListNode node3 = new LinkedListNode(9);
        LL1.addFirst(node3);
        LL1.printListValues();

        LinkedListNode node4 = new LinkedListNode(13);
        LL1.addLast(node4);
        LL1.printListValues();

        LinkedList LL2 = new LinkedList();
        LinkedListNode node5 = new LinkedListNode(27);
        LinkedListNode node6 = new LinkedListNode(2);
        LL2.addLast(node5);
        LL2.printListValues();
        LL2.addLast(node6);
        LL2.printListValues();
    }
}
