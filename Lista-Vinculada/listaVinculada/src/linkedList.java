public class linkedList<T> {
    private Node<T> first;
    private int size;

    public linkedList() {
        this.first = null;
        this.size = 0;

    }

    public void insertFirst(T data){
        Node<T> newNode = new Node<T>(data,null);
        if (this.first == null) {
            this.first = newNode;
            this.size = this.size + 1;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
            this.size = this.size + 1;
        }
    }

    public int getSize(){
        return this.size;
    }

    public T getFirts(){
        return this.first.getData();
    }

    public boolean isEmpty(){
        return (this.first==null);
    }



}

