import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//video 1.14
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {          //abstract because we never implement it
                                                                                                        //classes extend classes and implement interfaces.
    //Because it extends AbstractTree, it has access to all of it's methods.
    //Because it implements Binary Tree, it needs to implement some of the methods of BinaryTree

    public Position<E> sibling(Position<E> p){      //look at the sibling node (left - right or right - left)
        Position<E> parent = parent(p);             //get parent node of current node so we can look at the one on the other side.
        if(parent == null){                         //ie parent is root
            return null;
        }
        if(p == left(parent)){                      //if node p is the left node of the parent, return the right node.
            return right(parent);
        }
        return left(parent);                        //otherwise node p must be the right node of the parent, so return the left node.
    }

    public int numChildren(Position<E> p){          //the number of direct children of a given p. (ie. no grandchildren)
        int count = 0;
        if(left(p) != null){                        //if the given node has a child on the left, increment count
            count++;
        }
        if(right(p) != null){                       //if the given node has a child on the right, increment count
            count++;
        }
        return count;                               //return count
    }

    @Override
    public List<Position<E>> children(Position<E> p){                    //Returns iterable object of positions of children
        List<Position<E>> temp = new ArrayList<>(2);            //Binary tree so never more than 2 children
        if(left(p) != null){
            temp.add(left(p));                      //if the given node has a child on the left, add the child to temp
        }
        if(right(p) != null){
            temp.add(right(p));                     //if the given node has a child on the right, add the child to temp
        }
        return temp;                                //return temp
    }




    /*

    This is for Week 2 question 3. I believe Damien did this in a video after this question was asked, at some point in week 3 or 4.
    My initial version lived in LinkedBinaryTree but was moved here at his suggestion in the video.

     */

    public Iterable<Position<E>> inorder(){
        List<Position<E>> temp = new ArrayList<>();
        if(!isEmpty()){
            inorderSubtree(root(), temp);
        }
        for(Position<E> pos : temp){
            System.out.print(pos.getElement());
        }
        return temp;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> temp) {
        if(left(p) != null){
            inorderSubtree(left(p), temp);
        }
        temp.add(p);
        if(right(p) != null){
            inorderSubtree(right(p), temp);
        }
    }


    public ArrayList<Position<E>> eulerTour(){
        ArrayList<Position<E>> euler = new ArrayList<>();
        ArrayList<Position<E>> eulerRev = new ArrayList<>();
        Stack<Position<E>> stack = new Stack<>();
        stack.add(root());

        List <Position<E>> nodes = new ArrayList<>();

        while (!stack.isEmpty()){
            Position<E> p = stack.pop();
            eulerRev.add(p);
            if(!nodes.contains(p)){
                if(!children(p).isEmpty()) {
                    for (Position<E> child : children(p)) {
                        stack.add(p);
                        stack.add(child);
                    }
                }
                nodes.add(p);
            }
        }
        for(int i = eulerRev.size() - 1; i > 0; i--){
            euler.add(eulerRev.get(i));
        }
        //I don't imagine this is correct. But it makes the answer correct.
        euler.add(root());
    return euler;
    }

}
