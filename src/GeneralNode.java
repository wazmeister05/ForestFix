/*
Submission for Week 1
Will Stolton QHB18155

1.      Implement a general Node class using the Position interface. It should be generic, allowing it to hold any type of object.
        The Node itself will need to store an element, a link to a parent Node and a List of Nodes that are the children of that Node.
        A constructor which takes in an element, parent and children would be useful, as well as getters and setters for each of the variables/fields of the Node class.
 */
import java.util.ArrayList;
import java.util.List;

public class GeneralNode<E> implements Position<E> {

    private E element;
    private GeneralNode parent;
    private ArrayList<GeneralNode<E>> children;

    private int x,y;


    //this node will have no children when it's initially created - for the root.
    public GeneralNode(E element, GeneralNode parent){
        this.element = element;
        this.parent = parent;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void setElement(E element){
        this.element = element;
    }

    public GeneralNode getParent(){
        return parent;
    }

    public void setParent(GeneralNode<E> parent){
        this.parent = parent;
    }


    public void setChildren(ArrayList<GeneralNode<E>> children){
        this.children = children;
    }

    public List<GeneralNode<E>> getChildren(){
        return children;
    }
}
