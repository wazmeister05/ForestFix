import javax.swing.*;
import java.util.ArrayList;

public class Week3Ex {

    //the first tree is for exercise 3.6
    private static LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

    //this second and third trees is for exercise 3.14
    private static LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<>();
    private static GeneralTree<Integer> tree3 = new GeneralTree<>();


    public static void main(String[] args) {
        buildTree();

        //exercise 3.6. The BFS and DFS algorithms can be found in AbstractTree
        exercise36();
        //Looking at the times and plotting the graphs, I have determined that they run in the same time, O(n).


        //exercise 3.14.
        //Qu.1 - The Euler tour can be found in AbstractBinaryTree
        //Qu.2 - I've managed to draw this one, see below.
        //Qu.3 -
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

        System.out.println("\n\nEuler tour");
        ArrayList<Position<Integer>> euler = tree.eulerTour();
        for(int i = 0; i < euler.size(); i++){
            System.out.print(euler.get(i).getElement() + " ");
        }
        System.out.println();

        //should be 1 3 7 3 5 3 1 2 4 9 4 2 1
        //annoyingly I'm one number short of it being complete. I've added it manually but I don't imagine it's right.


        //Drawing application!!
        //Question 2 - Binary Tree
        JFrame jframe = new JFrame();
        tree2.addRoot(1);
        Position<Integer> three = tree2.addLeft(tree2.root(), 3);
        Position<Integer> two = tree2.addRight(tree2.root(), 2);
        tree2.addLeft(three, 7);
        tree2.addRight(three, 5);
        tree2.addRight(two, 4);
        jframe.setTitle("Question 2 - BinaryTree");
        jframe.add(new DrawApp(tree2));
        jframe.setSize(500, 500);
        jframe.setVisible(true);


        //Question 3
        //General Tree
        //See DrawAppGeneral. This draws something that is correct layout wise but not necessarily the same as the one we were supposed to draw.
        //However, I don't consider it wrong because general trees don't have a concept of left/right
        JFrame jframe1 = new JFrame();
        tree3.addRoot(1);
        Position<Integer> qu3three = tree3.addChild(tree3.root(), 3);
        tree3.addChild(tree3.root(), 6);
        Position<Integer> qu3two = tree3.addChild(tree3.root(), 2);

        tree3.addChild(qu3three, 7);
        tree3.addChild(qu3three, 5);

        tree3.addChild(qu3two, 4);
        jframe1.setTitle("Question 3 - GeneralTree");
        jframe1.add(new DrawAppGeneral(tree3));
        jframe1.setSize(500, 500);
        jframe1.setVisible(true);
        tree3.breadthFirst();

    }
}

