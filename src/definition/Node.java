package definition;

public class Node {
    // these are the fields for the contact list
    private Person data;
    private Node next;

    // constructor to initialize both the fields of the node
    Node(Person data, Node next) {
        this.data = data;
        this.next = next;
    }

    // getter method for the node's next field
    Node getNext() {
        return next;
    }

    //setter method  for the node's next field
    void setNext(Node next) {
        this.next = next;
    }

    // getter method for the node's data field
    Person getData() {
        return data;
    }

    //setter method  for the node's data field
    void setData(Person data) {
        this.data = data;
    }
}
