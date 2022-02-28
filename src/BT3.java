import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node3 {
    public static Node3 root;
    Node3 left, right;
    int data;
}

class BT3 {
   public void reverseLevelOrderUsingRecursion(Node3 node) {
       if(node == null) {
           return;
       }
       int height = getHeightOfTree(node);

       for (int i = height; i >= 0 ; i--) {
           printAtGivenLevel(node, i + 1);
           System.out.println();
       }
   }
   public int getHeightOfTree(Node3 node) {
       if(node == null) {
           return -1;
       }
       return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
   }
   public void printAtGivenLevel(Node3 node, int level) {
       if(node == null) {
           return;
       }
       if(level == 1) {
           System.out.print(node.data + " ");
           return;
       }
       printAtGivenLevel(node.left, level  - 1);
       printAtGivenLevel(node.right, level  - 1);
   }
   // Reverse level Order Traversal Without Recursion

    public void reverseTraversalWithoutRecursion(Node3 node) {
        if (node == null) {
            return;
        }

        Queue<Node3> q = new LinkedList<Node3>();
        q.add(node);

        Stack<Node3> s = new Stack<Node3>();

        while (q.size() > 0) {
            Node3 t = q.remove();
            s.push(t);

            if (t.right != null) {
                q.add(t.right);
            }

            if (t.left != null) {
                q.add(t.left);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop().data + " ");
        }
    }
    // Print Left View Of Binary Tree
    int maxLevel;
   public void leftViewOfTree(Node3 node, int level) {
       if(node == null) {
           return;
       }

       if(level >= maxLevel) {
           System.out.print(node.data + " ");
           maxLevel++;
       }

       leftViewOfTree(node.left, level + 1);
       leftViewOfTree(node.right, level + 1);
   }
   // Print Right View of Binary Tree

    public void rightViewOfTree(Node3 node, int level) {
        if(node == null) {
            return;
        }

        if(level >= maxLevel) {
            System.out.print(node.data + " ");
            maxLevel++;
        }

        leftViewOfTree(node.right, level + 1);
        leftViewOfTree(node.left, level + 1);
    }
    // Print Inorder Traversal without using Recursion
    public void inorderUsingStack(Node3 node) {
       if(node == null) {
           return;
       }
       Stack<Node3> s = new Stack<Node3>();
       while(node != null) {
           s.push(node);
           node = node.left;
       }

       while(s.size() > 0) {
           Node3 t = s.pop();
           System.out.print(t.data + " ");
           if(t.right != null) {
               Node3 temp = t.right;
               while(temp != null) {
                   s.push(temp);
                   temp = temp.left;
               }
           }
       }

    }
    // Print PreOrder Traversal without Recursion
    public void preorderWithoutRecursion(Node3 node) {
       if(node == null) {
           return;
       }
       Stack<Node3> s = new Stack<Node3>();
       s.push(node);

       while(s.size() > 0) {
           Node3 t = s.pop();
           System.out.print(t.data + " ");

           if(t.right != null) {
               s.push(t.right);
           }
           if(t.left != null) {
               s.push(t.left);
           }
       }
    }

    // PostOrder Traversal without using Recursion
    public void postorderUsingTwoStack(Node3 node) {
       if(node == null) {
           return;
       }

       Stack<Node3> s1 = new Stack<Node3>();
       Stack<Node3> s2 = new Stack<Node3>();

       s1.push(node);

       while(s1.size() > 0) {
           Node3 t = s1.pop();

           if(t.left != null) {
               s1.push(t.left);
           }
           if(t.right != null) {
               s1.push(t.right);
           }
           s2.push(t);
       }

       while(s2.size() > 0) {
           System.out.print(s2.pop().data + " ");
       }
    }


    public Node3 createNewNode(int val) {
       Node3 newNode = new Node3();
       newNode.data = val;
       newNode.left = null;
       newNode.right = null;
       return newNode;
   }
}

class BinaryTreeApp3 {
    public static void main(String[] args) {

        BT3 a = new BT3();

        Node3 root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

      //a.reverseLevelOrderUsingRecursion(root);
       //a.reverseTraversalWithoutRecursion(root);
       //a.leftViewOfTree(root, 0);
       //a.rightViewOfTree(root, 0);
        //a.inorderUsingStack(root);
        //a.preorderWithoutRecursion(root);
        //a.postorderUsingTwoStack(root);



    }

}