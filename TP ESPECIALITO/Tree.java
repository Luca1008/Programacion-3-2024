import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un árbol binario.
 * @param <T> Tipo de dato almacenado en el árbol.
 */
public class Tree<T> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    /**
     * Añade un nuevo nodo al árbol.
     * @param key Clave del nodo.
     * @param value Valor almacenado en el nodo.
     */
    public void add(String key, T value) {
        if (this.root == null) {
            this.root = new TreeNode<>(key, value);
        } else {
            this.add(this.root, key, value);
        }
    }

    private void add(TreeNode<T> actual, String key, T value) {
        int cmp = actual.getKey().compareTo(key);
        if (cmp > 0) {
            if (actual.getLeft() == null) {
                TreeNode<T> temp = new TreeNode<>(key, value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), key, value);
            }
        } else if (cmp < 0) {
            if (actual.getRight() == null) {
                TreeNode<T> temp = new TreeNode<>(key, value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), key, value);
            }
        }
    }

    /**
     * Obtiene el valor de un nodo por su clave.
     * @param key Clave del nodo.
     * @return Valor almacenado en el nodo.
     */
    public T get(String key) {
        return get(this.root, key);
    }

    private T get(TreeNode<T> actual, String key) {
        if (actual == null) {
            return null;
        }
        int t = actual.getKey().compareTo(key);
        if (t == 0) {
            return actual.getValue();
        } else if (t > 0) {
            return get(actual.getLeft(), key);
        } else {
            return get(actual.getRight(), key);
        }
    }

    /**
     * Obtiene todos los valores almacenados en el árbol en orden.
     * @return Lista de valores en orden.
     */
    public List<T> getAll() {
        List<T> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return values;
    }

    private void inOrderTraversal(TreeNode<T> node, List<T> values) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), values);
            values.add(node.getValue());
            inOrderTraversal(node.getRight(), values);
        }
    }
}

