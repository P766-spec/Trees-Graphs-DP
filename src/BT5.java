import java.util.LinkedList;
import java.util.Queue;

class Node5 {
    Node5 left, right;
    int data;
}

public class BT5 {
    public void printSumLevelWise(Node5 node) {
        if(node == null) {
            return;
        }
        Queue<Node5> q = new LinkedList<Node5>();
        q.add(node);

        while(true) {
            int size = q.size();
            if(size == 0) {
                break;
            }
            int sum = 0;
            while(size > 0) {
                Node5 t = q.remove();
                sum = sum + t.data;

                if(t.left != null) {
                    q.add(t.left);
                }
                if(t.right != null) {
                    q.add(t.right);
                }
                size--;
            }
            System.out.println(sum);
        }
        return;
    }
    public Node5 createNewNode(int val) {
        Node5 newNode = new Node5();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

class BinaryTreeApp5 {
    public static void main(String[] args) {
       BT5 a = new BT5();

       Node5 root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        a.printSumLevelWise(root);

    }
}