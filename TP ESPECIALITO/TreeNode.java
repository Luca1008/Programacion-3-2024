
public class TreeNode<T> {
    private String key;
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(String key, T value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
