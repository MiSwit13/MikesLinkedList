import static java.lang.System.out;


public class LinkedList {
    private LinkedListNode head = null;

    LinkedList() {
    }

    public void addFirst(LinkedListNode firstNode) {
        if (head == null) {
            head = firstNode;
        } else {
            firstNode.next = head;
            head = firstNode;
        }
    }

    public void addLast(LinkedListNode lastNode) {
        if (head != null) {
            LinkedListNode iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = lastNode;
        } else {
            this.addFirst(lastNode);
        }
    }

    public void printListValues () {
        out.println("Printing List:");
        if (this.head != null) {
            LinkedListNode iterator = this.head;
            out.print("The list values are {");
            while (iterator.next != null) {
                out.print(iterator.value + ", ");
                iterator = iterator.next;
            }
            out.println(iterator.value + "}");
            out.println();
        } else {
            out.println("There are no objects in this list!");
            out.println();
        }
    }
}
