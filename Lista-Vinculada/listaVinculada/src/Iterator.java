import java.util.Iterator;

public class Iterator<T> implements Iterator<T> {

    private Nodo<T> nodo;

    public Iterator(Nodo<T> nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean hasNext() {
        return this.nodo != null;
    }

    @Override
    public T next() {
        T info = this.nodo.getData();
        this.nodo = this.nodo.getNext();
        return info;
    }
    

}
