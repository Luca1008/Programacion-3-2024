
public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> ant;

    public Node(T data, Node<T> object) {
        this.setData(data);
        this.setNext(object);
    }

    public Node() {
        this.ant=null;
        this.data=null;
        this.next=null;
    }

    public Node(T data, Node<T> object, Node<T> next) {
        this.setData(data);
        this.setAnt(object);
        this.setNext(next);
    }

    private void setAnt(Node<T> object) {
        this.ant = object;
    }

    private void setData(T data2) {
        this.data = data2;
    }

    public void setNext(Node<T> first) {
        this.next = first;
    }

    public Node<T> getAnt() {
        return this.ant;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

}
