import java.util.LinkedList;
import java.util.Queue;

// Print elements at given level in Binary Tree
class Node2 {
    Node2 left;
    Node2 right;
    int data;
}

class BT2{
    /*
     * It'll print all values for a given level in Binary Tree
     */
//    public void printAtGivenLevel(Node2 node, int level) {
//        if (node == null) {
//            return;
//        }
//
//        if(level == 1) {
//            System.out.print(node.data + " ");
//            return;
//        }
//
//        printAtGivenLevel(node.left, level - 1);
//        printAtGivenLevel(node.right, level - 1);
//    }
    // Print elements in Level order (Using Recursion)
   public void levelOrderTraversalUsingRecursion(Node2 node) {
       if (node == null){
           return;
       }
       int height = getHeightOfTree(node);
       for (int i = 0; i <= height; i++) {
           printAtGivenLevel(node, i + 1);
           System.out.println();
       }
   }
   public int getHeightOfTree(Node2 node) {
        if(node == null) {
            return -1;
        }
        return Math.max(getHeightOfTree(node.left),  getHeightOfTree(node.right)) + 1;
   }
    public void printAtGivenLevel(Node2 node, int level) {
        if (node == null) {
            return;
        }

        if(level == 1) {
            System.out.print(node.data + " ");
            return;
        }

        printAtGivenLevel(node.left, level - 1);
        printAtGivenLevel(node.right, level - 1);
    }
    // Level Order Traversal Without Recursion (Using Queue)
    public void levelOrderTraversalUsingQueue(Node2 node) {
       if(node == null) {
           return;
       }
       Queue<Node2> q = new LinkedList<Node2>();
       q.add(node);

       while (!q.isEmpty()) {
           Node2 top = q.remove();
           System.out.println(top.data  + " ");

           if(top.left != null) {
               q.add(top.left);
           }
           if(top.right != null) {
               q.add(top.right);
           }
       }
    }
    //Level Order Traversal Line by Line Without Recursion (Using Single Queue)

    public void levelOrderTraversalUsingQueueLineByLine(Node2 node) {
       if(node == null) {
           return;
       }
       Queue<Node2> a = new LinkedList<Node2>();
       a.add(node);

       while(true) {
           int queueSize = a.size();
           if(queueSize == 0) {
               break;
           }
           while(queueSize  > 0) {
               Node2 temp = a.peek();
               System.out.print(temp.data + " ");

               a.remove();

               if(temp.left != null) {
                   a.add(temp.left);
               }
               if(temp.right != null) {
                   a.add(temp.right);
               }
               queueSize--;
           }
           System.out.println();

       }
    }





    public Node2 createNewNode(int val) {
        Node2 newNode = new Node2();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

class BinaryTreeApp2 {

    public static void main(String[] args) {

        BT2 a = new BT2();

        Node2 root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        //a.printAtGivenLevel(root, 4);
        //a.levelOrderTraversalUsingRecursion(root);
        // a.levelOrderTraversalUsingQueue(root);
        a.levelOrderTraversalUsingQueueLineByLine(root);
    }

}