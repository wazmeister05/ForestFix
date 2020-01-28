public class ActualGeneralTree<E> extends AbstractTree<E>{

    int size;

    @Override
    public Position<E> root() {
        return root();
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return p.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return p.getChildren();
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return p.getChildren().size();
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
