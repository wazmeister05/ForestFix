import javax.swing.*;
import java.util.ArrayList;

public class Week3Ex {

    //the first tree is for exercise 3.6
    private static LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

    //this second and third trees is for exercise 3.14
    private static LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
    private static ActualGeneralTree<Integer> tree3 = new ActualGeneralTree<>();


    public static void main(String[] args) {
        buildTree();
      //  exercise36();
        exercise314();
    }

    private static void buildTree() {
        tree.addRoot(1);
        Position<Integer> three = tree.addLeft(tree.root(), 3);
        tree.addLeft(three, 7);
        tree.addRight(three, 5);
        Position<Integer> two = tree.addRight(tree.root(), 2);
        Position<Integer> four = tree.addRight(two, 4);
        tree.addLeft(four, 9);
    }


    //actually exercise 3.6, but can't name it so.
    private static void exercise36() {
        System.out.println("First using Breadth First Search\n");
        System.out.println("Search for 5: ");
        long start = System.nanoTime();
        tree.bfs(5);
        System.out.println();
        long end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 5 using bfs");

        System.out.println("\n---------\nSearch for 2: ");
        start = System.nanoTime();
        tree.bfs(2);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 2 using bfs");

        System.out.println("\n---------\nSearch for 4: ");
        start = System.nanoTime();
        tree.bfs(4);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 4 using bfs");

        System.out.println("\n---------\nSearch for 7: ");
        start = System.nanoTime();
        tree.bfs(7);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 7 using bfs");


        System.out.println("\n---------\n");
        System.out.println("\nNow using Depth First Search");
        System.out.println();


        System.out.println("Search for 5: ");
        start = System.nanoTime();
        tree.dfs(5);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 5 using dfs");

        System.out.println("\n---------\nSearch for 2: ");
        start = System.nanoTime();
        tree.dfs(2);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 2 using dfs");

        System.out.println("\n---------\nSearch for 4: ");
        start = System.nanoTime();
        tree.dfs(4);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 4 using dfs");

        System.out.println("\n---------\nSearch for 7: ");
        start = System.nanoTime();
        tree.dfs(7);
        System.out.println();
        end = System.nanoTime() - start;
        System.out.println(end+" nanoseconds taken to find 7 using dfs");
    }



    //actually exercise 3.14, but can't name it so.
    private static void exercise314() {

        System.out.println("\n\nEuler tour\n");
        tree.eulerTour();
        //should be 1 3 7 3 5 3 1 2 4 9


        //Drawing application!!
        //Question 2 - Binary Tree
        JFrame jframe = new JFrame();
        tree2.addRoot(1);
        Position<Integer> three = tree2.addLeft(tree2.root(), 3);
        Position<Integer> two = tree2.addRight(tree2.root(), 2);
        tree2.addLeft(three, 7);
        tree2.addRight(three, 5);
        tree2.addRight(two, 4);
        jframe.add(new DrawApp(tree2));
        jframe.setSize(500, 500);
        jframe.setVisible(true);


        //Question 3
        //General Tree
        ArrayList<Position> children = new ArrayList<>();
        JFrame jframe1 = new JFrame();
        Position<Integer> root = new GeneralNode<>(5);


    }
}

