public class MikesLinkedListApp {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); //creates a new list called "ll"

        LinkedListNode node = new LinkedListNode(5); //creates a new node called "node" with a value of 5
        ll.add(node); //adds "node" to the linked list "ll"

        LinkedListNode node2 = new LinkedListNode(7);
        ll.add(node2);

        LinkedListNode node3 = new LinkedListNode(9);
        ll.add(node3);

        System.out.println("The value of node 1 is " + node.value);
        System.out.println("The value of node 2 is " + node2.value);
        System.out.println("The value of node 3 is " + node3.value);
    }
}
