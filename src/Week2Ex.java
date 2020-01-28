public class Week2Ex {

    private static LinkedBinaryTree<Character> tree = new LinkedBinaryTree<>();

    public static void main(String[] args) {
        Position<Character> root = tree.addRoot('A');
        Position<Character> B = tree.addLeft(tree.root(), 'B');
        Position<Character> D = tree.addLeft(B, 'D');
        Position<Character> F = tree.addLeft(D, 'F');
        Position<Character> G = tree.addRight(D, 'G');
        Position<Character> E = tree.addRight(B, 'E');
        Position<Character> L = tree.addLeft(E, 'L');
        Position<Character> C = tree.addRight(tree.root(), 'C');
        Position<Character> R = tree.addLeft(C, 'R');
        Position<Character> S = tree.addRight(C, 'S');

        //these are to test depth (that Damien provided) and height that I created
        System.out.println(tree.depth(G));
        System.out.println(tree.height(G));


        //the preorder and postorder methods can be found in AbstractTree, the inorder in the AbstractBinaryTree
        System.out.println("\n\n2. Preorder method");
        tree.preorder();
        System.out.println("\n\n3. Inorder method");
        tree.inorder();
        System.out.println("\n\n4. Postorder method");
        tree.postorder();

        System.out.println("\n\n-----");
        System.out.println("\n\n5. Breadth First method");
        for (Position<Character> node : tree.breadthFirst()) {
            System.out.print(node.getElement());
        }


        /* Tree:
                      50
                     /  \
                    10   20
                  /  \   /  \
                30   60  70  80
                 \       /
                 40     90


                 in this example, the following orders apply:
                 Preorder: 50 10 30 40 60 20 70 90 80
                 Inorder: 40 30 10 60 50 90 70 20 80
                 Postorder: 40 30 60 10 90 70 80 20 50
                 Breadth First: 50 10 20 30 60 70 80 40 90
         */

    }

}
