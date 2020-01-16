public class Week3Ex {

    private static LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

    public static void main(String[] args) {
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> three = tree.addLeft(tree.root(), 3);
        Position<Integer> seven = tree.addLeft(three, 7);
        Position<Integer> five = tree.addRight(three, 5);
        Position<Integer> two = tree.addRight(tree.root(), 2);
        Position<Integer> four = tree.addRight(two, 4);
        Position<Integer> nine = tree.addLeft(four, 9);

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



}
