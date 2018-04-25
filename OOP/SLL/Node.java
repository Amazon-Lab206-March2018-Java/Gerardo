public class Node {
    int value;
    Node next;

    Node (int val) {
        System.out.println ("Creating node with value: " + val);
        value = val;
        next = null;
    }
}