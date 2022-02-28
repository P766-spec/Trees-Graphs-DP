import java.util.*;

class Node4{
    Node4 left, right;
    int data;
    int height;
}

public class BT4 {
    // Convert a binary tree to its Mirror Tree
    public Node4 mirrorTree(Node4 node) {
        if(node == null) {
            return null;
        }
        Node4 t = node.left;
        node.left = node.right;
        node.right = t;

        mirrorTree(node.left);
        mirrorTree(node.right);

        return node;

    }
    // Delete the Binary Tree
    public Node4 deleteTree(Node4 node) {
        if(node == null) {
            return null;
        }
        node.left = deleteTree(node.left);
      node.right = deleteTree(node.right);

        System.out.println("Deleting node " + node.data);
        node = null;
        return node;

    }
    // get Level of Given Binary Tree
    public int getLevelOfNode(Node4 node, int val, int level) {
        if(node == null) {
            return 0;
        }
        int l;
        if(node.data == val) {
            return level;
        }
        l = getLevelOfNode(node.left,val,level + 1);

        if(l != 0) {
            return l;
        }
        l = getLevelOfNode(node.right,val,level + 1);
        return l;
    }
    // Print Top View of Binary Tree
    public void topView(Node4 node) {
        if(node == null) {
            return;
        }
        TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

        Queue<Node4> q = new LinkedList<Node4>();
        q.add(node);

        while(!q.isEmpty()) {
            Node4 temp = q.remove();
            int hd = temp.height;

            if(m.get(hd) == null) {
                m.put(hd, temp.data);
            }
            if(temp.left != null) {
                temp.left.height = hd -1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.height = hd + 1;
            }
        }
        System.out.println(m.values());
    }
    // Print Bottom View of Binary Tree
    public void bottomView(Node4 node) {
        if(node == null) {
            return;
        }
        TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

        Queue<Node4> q = new LinkedList<Node4>();
        q.add(node);

        while(!q.isEmpty()) {
            Node4 temp = q.remove();
            int hd = temp.height;

            m.put(hd, temp.data);
            if(temp.left != null) {
                temp.left.height = hd  - 1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.height = hd + 1;
                q.add(temp.right);
            }
        }
        System.out.println(m.values());

    }
    // Print Boundary Nodes In Binary Tree
    public void printBoundary(Node4 node) {
        if(node != null) {
            System.out.println(node.data + " ");

            printBoundaryLeft(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printBoundaryRight(node.right);
        }
    }
    public void printBoundaryLeft(Node4 node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }else if(node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }
    public void printLeaves(Node4 node) {
        if(node == null) {
            return;
        }
        printLeaves(node.left);

        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        printLeaves(node.right);
    }
    public void printBoundaryRight(Node4 node) {
        if(node == null) {
            return;
        }
        if(node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }
    // Print Vertical Order of Binary Tree
    public void printVerticalOrder(Node4 node) {
        if(node == null) {
            return;
        }
        int hd  = 0;
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();
        getVerticalOrder(node, hd, m);

        for(Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
            System.out.println(cm.getValue());
        }

    }
    public void getVerticalOrder(Node4 node, int hd, TreeMap<Integer, ArrayList<Integer>>m){
        if(node == null) {
            return;
        }
        if(m.get(hd) == null) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(node.data);
            m.put(hd,l);
        }else{
            ArrayList<Integer> l = m.get(hd);
            l.add(node.data);
            m.put(hd,l);
        }
        getVerticalOrder(node.left,hd - 1,m);
        getVerticalOrder(node.right,hd + 1, m);
    }

    // get Vertical Sum Of Binary Tree
    public void getVerticalSum(Node4 node) {
        if(node == null) {
            return;
        }
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        verticalSum(node,  0, m);

        if(m != null) {
            System.out.println(m.values());
        }
    }
    public void verticalSum(Node4 node, int d, Map<Integer, Integer> m) {
        if(node == null) {
            return;
        }

        verticalSum(node.left,d-1,m);
        int s = (m.get(d) == null) ? 0 : m.get(d);
        m.put(d, s + node.data);

        verticalSum(node.right,d  +1, m);

    }
    public Node4 createNewNode(int val) {
        Node4 newNode = new Node4();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
    public void inorder(Node4 node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

class BinaryTreeApp4 {
    public static void main(String[] args) {
        BT4 a = new BT4();

//         Node4 root = a.createNewNode(8);
//         root.left = a.createNewNode(3);
//         root.right = a.createNewNode(10);
//         root.left.left = a.createNewNode(1);
//         root.left.right = a.createNewNode(6);
//         root.left.right.left = a.createNewNode(4);
//         root.left.right.right = a.createNewNode(7);
//         root.right.right = a.createNewNode(14);
//         root.right.right.left = a.createNewNode(13);

//         Node4 mirror = a.mirrorTree(root);
//         a.inorder(mirror);
       // root = a.deleteTree(root);
        Node4 root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        //System.out.println(a.getLevelOfNode(root,7,1));
        //a.topView(root);
        //a.bottomView(root);
        //a.printBoundary(root);
       // a.printVerticalOrder(root);
        a.getVerticalSum(root);

    }

}
