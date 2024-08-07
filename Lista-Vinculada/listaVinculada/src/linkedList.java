import java.util.NoSuchElementException;
import java.util.Iterator;

public class linkedList<T> implements Iterable<T> {
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

    public T extractFirst(){
        if(this.first != null){
            Node<T> node = this.first;
            this.first = this.first.getNext();
            this.size--;
            return node.getData();
        }
        return null;
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

    //version con StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = this.first;
        sb.append("[");
        while (currentNode != null) {
            sb.append(currentNode.getData());
            if (currentNode.getNext() != null) {
                sb.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    //version sin StringBuilder
    /* @Override
    public String toString() {
        String result = "[";
        Node<T> current = this.first;
        while (current != null) {
            result += current.getData();
            if (current.getNext() != null) {
                result += ", ";
            }
            current = current.getNext();
        }
        result += "]";
        return result;
    } */

    public T getNode(int index) {
        if(index < 0 || index >= this.size) { 
            throw new IndexOutOfBoundsException("Indice esta fuera del rango");
        }
        Node<T> current = this.first;
        for(int i=0;i<index;i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public int getPosNode(T data){
        if (data == null) {
            throw new IllegalArgumentException("La data no puede ser nula");
        }
        if(this.isEmpty()){
            Node<T> current = this.first;
            for(int i=0;i<this.size;i++) {
                if(data.equals(current.getData())){
                    return i;
                }
                current = current.getNext();
            }
            }else{
                throw new IllegalStateException("La lista está vacía");
        }
        return -1;
    }


    // Implementación del método iterator()
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this.first);
    }

    // Clase interna para la implementación del iterador
    private class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> currentNode;

        public LinkedListIterator(Node<T> first) {
            this.currentNode = first;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }
    }



}

