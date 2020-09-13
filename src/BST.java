import java.util.ArrayList;
public class BST {

    private class BSTNode {
        Room value;
        BSTNode left;
        BSTNode right;

        public BSTNode(Room value){
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

    private BSTNode insert(BSTNode curr, Room value){
        if (curr == null)
            return new BSTNode(value);
        if (value.compareTo(curr.value) == -1)
            curr.right = insert(curr.right, value);
        else if (value.compareTo(curr.value) == 1)
            curr.left = insert(curr.left, value);
        return curr;
    }

    public void insert(Room value){
        root = insert(root, value);
    }

   /* private boolean search(BSTNode curr, Room value){
        //System.out.println("Visiting: " + (curr == null ? "null :(" : curr.value));
        if (value.compareTo(curr.value) == 0)
        return true;
        if (curr == null) {
            return false; }
        if (curr.value == value) return true;
        if (value.compareTo(curr.value) == -1)
            return search(curr.right, value);
        return search(curr.left, value);
    }*/
   private Room search(BSTNode curr, Room value){
       //System.out.println("Visiting: " + (curr == null ? "null :(" : curr.value));
       if (value.compareTo(curr.value) == 0)
           return curr.value;
       if (curr == null) {
           return null; }
       if (curr.value == value) return value;
       if (value.compareTo(curr.value) == -1)
           return search(curr.right, value);
       return search(curr.left, value);
   }

    public Room search(Room value){
        if(search(root, value)!=null){
            return search(root,value);
        };
        return null;

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


        Room room1 = new Room("Kitchen", "Food Location");
        Room room2 = new Room("Bedroom", "Bed Location");
        Room room3 = new Room("Bathroom", "Toilet Location");
        Room room4 = new Room("Deck", "Chair Location");
        Room room8 = new Room("Kitchen", "");
        Room room5 = new Room("Blyat Room", "Location of the Schvedtka");
        bst.insert(room1);
        bst.insert(room2);
        bst.insert(room3);
        bst.insert(room5);

        //bst.printTree();
        System.out.println(room1);
        System.out.println(room8);
        System.out.println(room1.compareTo(room8));
        System.out.println(bst.search(room8));




        //System.out.println("room7? " + bst.search(room2));
        //bst.printInOrder();
    }
}