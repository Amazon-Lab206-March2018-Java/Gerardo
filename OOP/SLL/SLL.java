public class SLL {
    private Node head;

    SLL () {
        head = null;
    }

    public SLL add (int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return this;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return this;
    }
    public SLL remove () {
        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return this;
    }

    public void printValues () {
        Node temp = head;
        String output = "[";
        while (temp != null) {
            if (temp.next != null) {
                output += temp.value + ",";
            } else {
                output += temp.value;
            }
            temp = temp.next;
        }
        output += "]";
        System.out.println (output);
    }
}