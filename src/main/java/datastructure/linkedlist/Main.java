package datastructure.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList =  new LinkedList();
        linkedList.append(1);
        linkedList.prepend(0);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        //linkedList.append(5);
        linkedList.print();
        System.out.println();
        System.out.println(linkedList.middleNode(linkedList.head).value);

        linkedList.reverseTheLinkedList();
        linkedList.print();
        LinkedList.Node reorderList = linkedList.reorderList(linkedList.head);
        linkedList.print(reorderList);
    }
}
