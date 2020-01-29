import java.util.List;
import java.util.Scanner;

public class TreeDemo{

    private static Node root;		//creating pointer to first node in the tree
    private static int size;

    //inner class node
    protected static class Node{

        String name;
        Node left;
        Node right;
        Node parent;

        public Node(String name, Node left, Node right, Node parent){
            this.name = name;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String getElement() {
            return name;
        }

        public Node getParent() {
            return parent;
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
    private static boolean checkValue(String value){

        return true;
    }

    private static void insert(String name) {
        if(root.left == null){

        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean finish = false;
        String name = scanner.next();
        root = new Node(name, null, null, null);


        while(finish){
            System.out.print("Enter name or enter blank to quit: ");
            name = scanner.next();

            if(name != null){
                if(!checkValue(name)){
                    insert(name);
                    size++;
                }
            }
            else{
                finish = true;
            }
        }
    }

    public void inOrder(Node node){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.getElement());
            inOrder(root.right);
        }
    }

        //traversal		look at all of the traversals, it could be any of them. (probable pre/post/in order though)

}