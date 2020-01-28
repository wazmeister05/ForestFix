import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree<E> extends AbstractTree<E> {

    private Node<E> root;
    private int size;



    protected static class Node<E> implements Position<E> {

        private E element;
        private ArrayList<Position<E>> children;
        private Node<E> parent;

        private int x, y;

        public Node(E element, Node<E> parent, ArrayList<Position<E>> children) {
            this.element = element;
            this.parent = parent;
            this.children = children;
        }

        public Position<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }


        @Override
        public E getElement() {
            return element;
        }


        public void setX(int x) {
            this.x = x;
        }


        public void setY(int y) {
            this.y = y;
        }


        public int getX() {
            return x;
        }


        public int getY() {
            return y;
        }

        public void setElement(E element){
            this.element = element;
        }


        public Iterator<Position<E>> iterator() {
            return null;
        }

        public List<Position<E>> getChildren() {
            return children;
        }

        public void setChildren(Position<E> child) {
            children.add(child);
        }
    }

    //honestly, borrowed this from Damien's work.
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Not a valid position type");
        }
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node) {        //ie node is it's own parent - say if it isn't part of the tree
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    public void addRoot(E element) throws IllegalStateException{
        root = new Node<>(element, null, null);
        size = 1;
    }

    public Position<E> addChild(Position<E> p, E element){
        Node<E> parent = validate(p);
        Node<E> child = new Node<>(element, parent, null);
        size++;
        //parent.setChildren(child);
        return child;
    }



    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> parent = (Node<E>) validate(p).getParent();
        return (Position)parent;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
