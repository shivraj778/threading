package datastructure.tree.binarytree;

import java.util.*;

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

     public List<List<Integer>> getLevelOrder(Node node) {

        List<List<Integer>> finalList =  new ArrayList<>();
         if (node == null) return finalList;
        Queue<Node> queue  = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listInteger =  new ArrayList<>();
            while (size != 0) {
                Node node1 = queue.poll();
                listInteger.add(node1.value);
                if (node1.left != null) queue.add(node1.left);
                if (node1.right != null) queue.add(node1.right);
                size --;
            }
            finalList.add(listInteger);
        }
        return finalList;
     }

     public List<List<Integer>> zigzag(Node root) {
         List<List<Integer>> finalList =  new ArrayList<>();
         if (root == null) return finalList;
         Queue<Node> queue =  new LinkedList<>();
         queue.add(root);
         int level = 0;
         while (!queue.isEmpty()) {
             int size = queue.size();
             List<Integer> list =  new ArrayList<>();
             while (size != 0) {
                 Node node = queue.poll();
                 if (level % 2 == 0) list.add(node.value);
                 else list.addFirst(node.value);
                 if (node.left != null) queue.add(node.left);
                 if (node.right != null) queue.add(node.right);
                 size--;
             }
             finalList.add(list);
             level ++;
         }
         return  finalList;
     }

     public List<Integer> morrisInorder(Node root) {
         List<Integer> list = new ArrayList<>();
         if (root == null) return list;
         Node currentNode = root;
         while (currentNode != null) {
             if (currentNode.left == null) {
                 list.add(currentNode.value);
                 currentNode = currentNode.right;
             } else {
                 Node rightMostNode = currentNode.left;
                 while (rightMostNode.right != null && rightMostNode.right != currentNode) {
                     rightMostNode = rightMostNode.right;
                 }
                 if (rightMostNode.right == null) {
                     rightMostNode.right = currentNode;
                     list.add(currentNode.value);
                     currentNode = currentNode.left;
                 } else {
                     rightMostNode.right = null;
                     currentNode = currentNode.right;
                 }

             }

         }
         return list;
     }

     public int minDepth(Node root) {
        if (root == null) return 0;
        return dfs(root);
     }

    private int dfs(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1+ Math.min(left,right);
    }











    public int maxDepth(Node root) {
        if (root == null) return 0;
        return dfsM(root);
    }

    private int dfsM(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = dfsM(root.left);
        int right = dfsM(root.right);
        return 1+Math.max(left,right);
    }

//    public int dimeterOfTree(Node root) {
//        if (root == null) return 0;
//        int left = maxDimeter(root.left);
//        int right = maxDimeter(root.right);
//        return left + right;
//    }
//
//    private int maxDimeter(Node root) {
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;
//        int left = maxDimeter(root.left);
//        int right = maxDimeter(root.right);
//        return 1 + Math.max(left,right);
//    }

    int dimeter = 0;
    public int dimeterOfTree(Node root) {
        if (root == null) return dimeter;
        helper(root);
        return dimeter;
    }

    private int helper(Node root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        dimeter = Math.max(dimeter,left+right);
        return 1+Math.max(left,right);
    }


    public void flatten(Node node) {

        flattenInOrder(node);
        root = head.right;
    }
    Node newNode =  new Node(0);
    Node head = newNode;
    Node temp = newNode;
    private void flattenInOrder(Node root) {
        if (root != null) {
            flattenInOrder(root.left);
            temp.left = null;
            temp.right = new Node(root.value);
            temp = temp.right;
            flattenInOrder(root.right);
        }
    }


}
