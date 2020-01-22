public class TreeApp {

    private static LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
    private static LinkedTree<String> tree2 = new LinkedTree<>();
    private static LinkedTree<String> tree3 = new LinkedTree<>();

    public static void main(String[] args){
        tree.addRoot(1);
        Position<Integer> child = tree.addLeft(tree.root(), 2);
        tree.addLeft(child, 3);
        child = tree.addRight(tree.root(), 4);
        tree.addRight(child, 5);

        System.out.println("-------------------------------");
        System.out.println("Disk Space");
        System.out.println(diskSpace(tree,tree.root()));
        System.out.println(diskSpace(tree, child));

        System.out.println("-----------------------");
        for(Position<Integer> node : tree.breadthFirst()){
            System.out.println(node.getElement());
        }




        //  Tree 2 that needs creating.
        tree2.addRoot("Paper");
        tree2.addChild(tree2.root(),"Title");
        tree2.addChild(tree2.root(),"Abstract");
        Position<String> temp = tree2.addChild(tree2.root(), "1");
        tree2.addChild(temp,"1.1");
        tree2.addChild(temp,"1.2");
        temp = tree2.addChild(tree2.root(), "2");
        tree2.addChild(temp,"2.1");
        tree2.addChild(temp,"2.2");
        tree2.addChild(temp,"2.3");
        temp = tree2.addChild(tree2.root(), "3");
        tree2.addChild(temp,"3.1");
        tree2.addChild(temp,"3.2");
        tree2.addChild(tree2.root(), "References");



        System.out.println("------------------------------");
        System.out.println("Table of Contents");
        for(Position<String> position : tree2.preorder()){
            System.out.println(position.getElement());
        }

        System.out.println("-------------------------------");
        System.out.println("Table of Contents - Indented");
        printIndented(tree2, tree2.root(), 0);
        for(Position<String> position : tree2.preorder()){
            System.out.println(position.getElement());
        }




        //tree 3
        tree3.addRoot("Electronics R'Us");
        tree3.addChild(tree3.root(),"R&D");
        temp = tree3.addChild(tree3.root(), "Sales");
        tree3.addChild(temp,"Domestic");
        temp = tree3.addChild(temp, "International");
        tree3.addChild(temp,"Canada");
        tree3.addChild(temp,"S. America");
        temp = tree3.addChild(tree3.root(), "Overseas");
        tree3.addChild(temp,"Africa");
        tree3.addChild(temp,"Europe");
        tree3.addChild(temp,"Asia");
        tree3.addChild(temp,"Australia");
        tree3.addChild(tree3.root(),"Purchasing");
        temp = tree3.addChild(tree3.root(), "Manufacturing");
        tree3.addChild(temp,"TV");
        tree3.addChild(temp,"CD");
        tree3.addChild(temp,"Tuner");

        System.out.println("-------------------------");
        System.out.println("Normal Representation");
        for(Position<String> position : tree3.preorder()){
            System.out.println(position.getElement());
        }

        System.out.println("-------------------------");
        System.out.println("Parenthesized String Representation");
        parenthesize(tree3, tree3.root());


    }

    public static <E> void printIndented(Tree<E> t, Position<E> p, int depth){
        System.out.println(spaces(2*depth) + p.getElement());
        for(Position<E> c : t.children(p)){
            printIndented(t, c, depth+1);
        }
    }

    private static String spaces(int n) {       //this takes in a value and creates a string with that number of spaces.
        String indent = "";
        for (int i = 0; i < n; i++){
            indent = indent + " ";
        }
        return indent;
    }

    public static int diskSpace(Tree<Integer> t, Position<Integer> p){
        int subtotal = p.getElement();
        for(Position<Integer> c : t.children(p)){
            subtotal += diskSpace(t, c);
        }
        return subtotal;
    }

    public static <E> void parenthesize(Tree<E> t, Position<E> p){
        System.out.print(p.getElement());
        if(t.isInternal(p)){
            boolean firstTime = true;
            for(Position<E> child : t.children(p)){
                System.out.print((firstTime ? " (" : ","));
                firstTime = false;
                parenthesize(t, child);
            }
            System.out.print(") ");
        }
    }

}
