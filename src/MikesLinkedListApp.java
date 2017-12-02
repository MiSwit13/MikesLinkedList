public class MikesLinkedListApp {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); //creates a new list called "ll"

        LinkedListNode node1 = new LinkedListNode(5); //creates a new node called "node1" with a value of 5
        ll.add(node1); //adds "node" to the linked list "ll"

        LinkedListNode node2 = new LinkedListNode(7);
        ll.add(node2);

        LinkedListNode node3 = new LinkedListNode(9);
        ll.add(node3);

        System.out.println("The value of node 1 is " + node1.value);
        System.out.println("The value of node 2 is " + node2.value);
        System.out.println("The value of node 3 is " + node3.value);
    }
}
