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
    private GeneralNode<E> parent;
    private ArrayList<Position<E>> children;

    private int x,y;


    //this node will have no children when it's initially created - for the root.
    public GeneralNode(E element, GeneralNode<E> parent){
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public GeneralNode(E element){
        this.element = element;
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

    public Position<E> getParent(){
        return parent;
    }

    public void setParent(GeneralNode<E> parent){
        this.parent = parent;
    }

    private void addChild(E element) {
        GeneralNode<E> child = new GeneralNode<E>(element);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(GeneralNode<E> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public boolean isRoot(){
        return (this.parent == null);
    }

    public void setChildren(GeneralNode<E> child) {
        children.add((Position)child);
    }


    public List<Position<E>> getChildren(){
        return children;
    }
}
