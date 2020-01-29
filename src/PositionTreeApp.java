import java.util.List;

//video 1.1
public interface PositionTreeApp<E> {

    E getElement();                             //returns element from given position

    Position<E> getParent();

    List<Position<E>> getChildren();

}