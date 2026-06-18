package datastructure.linkedlist;

public class LinkedList {
    Node head;
    Node tail;
    int size;
    class Node{
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    public boolean append(int value) {
        Node node =  new Node(value);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    public boolean prepend(int value) {
        Node node =  new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size ++;
        return true;
    }
    public int getSize() {
        return size;
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public Node middleNode(Node head) {
        if (head == null) return head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void deleteNode(Node node) {
        Node curr = node;
        Node nextNode = node.next;
        curr.value = nextNode.value;
        curr.next = nextNode.next;
        nextNode.next = null;
    }

    public Node mergeTwoSortedLinkedList(Node head1,Node head2) {
        Node temp1 =  head1;
        Node temp2 = head2;
        Node head = new Node(0);
        Node temp3 = head;
        while (temp1 != null && temp2 != null) {
            Node node;
            if (temp1.value > temp2.value) {
                node = new Node(temp2.value);
                temp2 = temp2.next;
            } else {
                node = new Node(temp1.value);
                temp1 = temp1.next;
            }
            temp3.next = node;
            temp3 = node;
        }

        while (temp1 != null) {
            Node node =  new Node(temp1.value);
            temp3.next = node;
            temp3 = node;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            Node node =  new Node(temp2.value);
            temp3.next = node;
            temp3 = node;
            temp2 = temp2.next;
        }

        return head.next;
    }

    public void reverseTheLinkedList() {
        System.out.println("reverse");
        Node next = head;
        Node curr = head;
        Node prev = null;
        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }
}
