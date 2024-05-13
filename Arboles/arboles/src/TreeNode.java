

public class TreeNode {

	private Integer value;
	private TreeNode left;
	private TreeNode right;
	private String character;

	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.setCharacter(null);
	}
	public TreeNode(Integer value, String character) {
		this.value = value;
		this.setCharacter(character);
		this.left = null;
		this.right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}
	public void setValue(Integer x){
		this.value=x;
	}
	public boolean isLeaft() {
		return this.getLeft() == null && this.getRight() == null;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	public boolean hasCharacter() {
		return this.character != null && !this.character.equals("");
	}

}
