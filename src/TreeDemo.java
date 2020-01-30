import java.util.Scanner;

public class TreeDemo {

    private static Node root;		//creating pointer to first node in the tree
    private static int size;

    //inner class node
    protected static class Node{

        String name;
        Node left;
        Node right;

        public Node(String name, Node left, Node right){
            this.name = name;
            this.left = left;
            this.right = right;
        }

        public String getElement() {
            return name;
        }

    }

    private int size(){
        return size;
    }

    //working recursively, we don't need left/right as the code will determine which way to go


    //check if root, insert it if there isn't a root node as root.
    //compare value size to size of node currently there	greater than, less than.
    //continue down until you have a space.


    //say we don't want duplicates...		work recursively
    private static boolean checkVal(Node current, String value){
        if(current == null){
            return true;
        }
        if(value.equals(current.name)) {
            return false;
        }
        else if(value != current.name){
            checkVal(current.left, value);
            checkVal(current.right, value);
        }
        return true;
    }

    private static boolean checkValue(String value){
        return checkVal(root(), value);
    }

    private static Node insert(Node current, String name) {
        if(current == null){
            return new Node(name, null, null);
        }

        //compareTo compares strings lexicographically.
        //a == b = 0,   a < b = -1,   a > b = 1
        int comparison = name.compareTo(current.name);
        if(comparison < 0){
            current.left = insert(current.left, name);
        }
        else if(comparison > 0){
            current.right = insert(current.right, name);
        }
        return current;
    }


    public static void add(String name){
        root = insert(root, name);
        size++;
    }

    public static Node root(){
        return root;
    }

    public static void main(String[] args){

        TreeDemo td = new TreeDemo();
        boolean finish = false;
        while(!finish){
            System.out.print("Enter name or q to quit: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if(checkValue(name)) {
                if (name.equals("q")) {
                    break;
                }
                add(name);
            }
            else{
                System.out.println("Name already exists. Try again.");
            }
        }
        System.out.println(td.size());
        //td.inorder(root());
        td.traverseInOrder(root());
    }

    public void inorder(Node node){
        if(root != null){
            inorder(node.left);
            System.out.println(node.getElement());
            inorder(node.right);
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.name);
            traverseInOrder(node.right);
        }
    }


    //traversal		look at all of the traversals, it could be any of them. (probable pre/post/in order though)

}