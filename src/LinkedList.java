public class LinkedList {
    public LinkedListNode head = null;

    public void add(LinkedListNode node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}
