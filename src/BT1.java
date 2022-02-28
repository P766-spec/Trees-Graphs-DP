// Get sum of all Nodes in Binary Tree

class Node1 {
    Node left;
    Node right;
    int data;
}

class BT1 {

    /*
     * It'll return sum of all nodes in Binary Tree
     */
//    public int getSumOfNodes(Node node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
//    }

    // Get difference of values at Even  & Odd Level
//    public int getDifferenceEvenOddValues(Node node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return node.data - getDifferenceEvenOddValues(node.left) - getDifferenceEvenOddValues(node.right);
//    }

//    public int getNumberOfNodes(Node node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
//    }

    // Get NUmber of Leaf Nodes in Binary Tree
//    public int getNumberOfLeafNodes(Node node) {
//        if(node == null) {
//            return 0;
//        }
//        if(node.left == null && node.right == null) {
//            return 1;
//        }
//        return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
//    }
    // Get Height of a Binary Tree/Node
    public int getHeightOfTree(Node node) {
        if(node == null) {
            return -1;
        }
        return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

class BinaryTreeApp1 {

    public static void main(String[] args) {

        BT1 a = new BT1();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        // System.out.print("Total Sum: " + a.getSumOfNodes(root));
        //System.out.print("Total Difference: " + a.getDifferenceEvenOddValues(root));
        //System.out.print("Total Nodes: " + a.getNumberOfNodes(root));
        //System.out.println("Total Leaf Nodes: "  +a.getNumberOfLeafNodes(root));
        System.out.println("Total Leaf Nodes: " + a.getHeightOfTree(root));

    }

}