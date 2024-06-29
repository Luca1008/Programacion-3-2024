/**
 * Nodo de un árbol binario.
 * @param <T> Tipo de dato almacenado en el nodo.
 */
public class TreeNode<T> {
    private String key;
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Constructor para crear un nuevo nodo.
     * @param key Clave del nodo.
     * @param value Valor almacenado en el nodo.
     */
    public TreeNode(String key, T value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

