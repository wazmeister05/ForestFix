import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;

//video 1.1
public abstract class AbstractTree<E> implements Tree<E>  {                                   //implement a few of the Tree methods across any kind of tree, but not all so abstract


    @Override
    //implements Tree.numChildren(p).
    //If number of children > 0, the node has children and is therefore internal
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    //implements Tree.numChildren(p).
    //If number of children == 0, the node has children and is therefore external
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    //implements Tree.root().
    //if the root node from root() is equal to the given position, return true
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return root() == p;
    }

    @Override
    //implements Tree.size().
    //if the size of the tree is equal to 0, return true.
    public boolean isEmpty() {
        return size() == 0;
    }

    //calculate the depth of the tree
    public int depth(Position<E> p){            //how far down a node is in a tree
        if(isRoot(p)){
            return 0;           //root position has depth 0
        }
        else{
            return 1+ depth(parent(p));     //recursive call to depth, will add 1 to depth every time until it hits the root (==base case)
        }
    }

    public int height(Position<E> p){
        if(!isRoot(p)){
            return 1 + height(parent(p));
        }
        else{
            return 0;
        }
    }



    private class ElementIterator implements Iterator<E>{
        //class to let us traverse through each node.

        Iterator<Position<E>> positionIterator = positions().iterator();        //all positions in tree and their iterators

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    public Iterator<E> iterator(){          //whenever we call iterator, we get the elementIteraror we just created ^
        return new ElementIterator();
    }

    public Iterable<Position<E>> preorder(){
        List<Position<E>> temp = new ArrayList<>();
        if(!isEmpty()) {                                //if list isn't empty
            preorderSubtree(root(), temp);
        }
        for(Position<E> pos : temp){
            System.out.print(pos.getElement());
        }
        return temp;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> temp){        //preorder adds position to temp before ordering children
        temp.add(p);
        for(Position<E> child : children(p)){
            preorderSubtree(child, temp);
        }
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> temp){
        for(Position<E> child : children(p)){
            postorderSubtree(child, temp);
        }
        temp.add(p);
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> temp = new ArrayList<>();
        if(!isEmpty()) {
            postorderSubtree(root(), temp);
        }
        for(Position<E> pos : temp){
            System.out.print(pos.getElement());
        }
        return temp;
    }


    public Iterable<Position<E>> breadthFirst(){                    //searches tree in order of depth, so all of row one, row two, row three...
        List<Position<E>> temp = new ArrayList<>();
        if(!isEmpty()){
            Queue<Position<E>> queue = new LinkedList<>();          //uses a queue to traverse the tree
            queue.add(root());                                      //start by adding root to front of queue
            while(!queue.isEmpty()){
                Position<E> p = queue.remove();                     //remove queue header (root the first time) and assign to p
                temp.add(p);                                        //add p to temp array
                for(Position<E> child:children(p)){                 //for each child of p
                    queue.add(child);                               //add that to the queue
                }
            }                                            //when you add something to the queue it goes to the back, so it will do left then right but not left left right right
        }
        return temp;
    }


    public Position<E> bfs(E element){
        Position<E> p = null;
        if(!isEmpty() ){
            Queue<Position<E>> queue = new LinkedList<>();
            queue.add(root());
            do{
                p = queue.remove();
                for(Position<E> child:children(p)){
                    queue.add(child);
                }
                System.out.print(p.getElement());
            }while(p.getElement() != element);
        }
        return p;
    }

    public Position<E> dfs(E element){
        Position<E> p = null;
        if(!isEmpty() ){
            Stack<Position<E>> stack = new Stack<>();
            stack.add(root());
            do{
                p = stack.pop();
                for(Position<E> child:children(p)){
                    stack.add(child);
                }
                System.out.print(p.getElement());
            }while(p.getElement() != element);
        }
        return p;
    }


}
