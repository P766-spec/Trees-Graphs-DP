class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {
    // Inorder Preorder & Postorder
    public void inorder (Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }

    public void preorder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data + " ");
    }



    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BinaryTreeApp {

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        System.out.println("Inorder: ");
        a.inorder(root);
        System.out.println();

        System.out.println("Preorder: ");
        a.preorder(root);
        System.out.println();

        System.out.println("Postorder: ");
        a.postorder(root);
        System.out.println();

    }

}


