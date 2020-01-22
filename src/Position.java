//video 1.1
public interface Position<E> {

    E getElement();                             //returns element from given position

    int getX();
    int getY();

    void setX(int x);
    void setY(int y);

}
