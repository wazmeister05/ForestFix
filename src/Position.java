import java.util.List;

//video 1.1
public interface Position<E> {

    E getElement();                             //returns element from given position
    Position<E> getParent();
    List<Position<E>> getChildren();

    int getX();
    int getY();

    void setX(int x);
    void setY(int y);

}
