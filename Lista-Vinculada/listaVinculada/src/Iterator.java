public class Iterator<T> {

    private Node<T> nodo;

    public Iterator(Node<T> nodo) {
        this.nodo = nodo;
    }

    public boolean hasNext() {
        return this.nodo != null;
    }

    public T next() {
        T info = this.nodo.getData();
        this.nodo = this.nodo.getNext();
        return info;
    }
}
