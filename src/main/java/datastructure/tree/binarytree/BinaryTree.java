package datastructure.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    Node root;
    class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    public boolean addNode(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return true;
        }
        Node temp = root;
        while (true) {
            if (node.value == temp.value) return false;
            else if (node.value < temp.value) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value == temp.value) return true;
            else if (value > temp.value) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return false;
    }
    public List<Integer> BFS() {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            list.add(currentNode.value);
        }

        return list;
    }
    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();

        class Order {
            Order(Node node){
                list.add(node.value);
                if (node.left != null) {
                    new Order(node.left);
                }
                if (node.right != null) {
                    new Order(node.right);
                }
            }
        }
        new Order(root);
        return list;
    }

    public List<Integer> postOrder() {
        List<Integer> list =  new ArrayList<>();
        class Order{
            Order(Node node) {
                if (node.left != null) {
                    new Order(node.left);
                }
                if (node.right != null) {
                    new Order(node.right);
                }
                list.add(node.value);
            }
        }
        new Order(root);
        return list;
    }

    public List<Integer> inOrder() {
        List<Integer> list =  new ArrayList<>();
        class Order {
            Order(Node node) {
                if (node.left != null) {
                    new Order(node.left);
                }
                list.add(node.value);
                if (node.right != null) {
                    new Order(node.right);
                }
            }
        }
        new Order(root);
        return list;
     }

     public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list =  new ArrayList<>();
        class Order {
            Order(List<Node> nodeList) {
                List<Integer> intList =  new ArrayList<>();
                List<Node> temp =  new ArrayList<>();
                for (Node node: nodeList) {
                    intList.add(node.value);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
                if (!intList.isEmpty()) {
                    list.add(intList);
                    new Order(temp);
                }
            }
        }
        List<Node> nList =  new ArrayList<>();
        nList.add(root);
        new Order(nList);

        return list;
     }

}
