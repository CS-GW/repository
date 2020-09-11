import java.util.ArrayList;
class BST {

    private class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int value){
            this.value = value;
        }

        // Adapted from Todd Davies answer to printing a BST on Stack Overflow.
        // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
        private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right!=null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
            if(left!=null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        @Override
        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }

    private BSTNode root;

    private BSTNode insert(BSTNode curr, int value){
        if (curr == null)
            return new BSTNode(value);
        if (value > curr.value)
            curr.right = insert(curr.right, value);
        else if (value < curr.value)
            curr.left = insert(curr.left, value);
        return curr;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private boolean search(BSTNode curr, int value){
        System.out.println("Visiting: " + (curr == null ? "null :(" : curr.value));
        if (curr == null) return false;
        if (curr.value == value) return true;
        if (value > curr.value)
            return search(curr.right, value);
        return search(curr.left, value);
    }

    public boolean search(int value){
        return search(root, value);
    }

    private void printInOrder(BSTNode curr){
        if (curr != null) {
            // Print everything in left subtree
            printInOrder(curr.left);
            // Print curr.value
            System.out.print(curr.value + " ");
            // Print everything in right subtree
            printInOrder(curr.right);
        }
    }

    public void printInOrder(){
        printInOrder(root);
        System.out.println();
    }

    public void printTree(){
        System.out.println(root.toString());
    }

    // Testing
    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        bst.printTree();
        System.out.println("9? " + bst.search(9));
        System.out.println("7? " + bst.search(7));
        bst.printInOrder();
    }
}