package datastructure.tree.binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree obj =  new BinaryTree();
        obj.addNode(55);
        obj.addNode(45);
        obj.addNode(65);
        obj.addNode(47);
        obj.addNode(12);
        obj.addNode(57);
        obj.addNode(67);
        System.out.println(obj.root.left.value);
        System.out.println(obj.root.right.value);
        System.out.println(obj.root.value);
        System.out.println(obj.BFS());

        System.out.println("**************");
        System.out.println(obj.preOrder());
        System.out.println(obj.postOrder());
        System.out.println(obj.inOrder());
        System.out.println(obj.levelOrder(obj.root));
        System.out.println(obj.getLevelOrder(obj.root));
        System.out.println(obj.zigzag(obj.root));
    }
}
