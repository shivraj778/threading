package datastructure.tree.binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree obj =  new BinaryTree();
        obj.addNode(55);
        obj.addNode(45);
        obj.addNode(65);
        System.out.println(obj.root.left.value);
        System.out.println(obj.root.right.value);
        System.out.println(obj.root.value);
    }
}
