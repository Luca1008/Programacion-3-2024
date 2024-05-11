import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}

	//complejidad:
	//
	public int getRoot(){
		if (!this.isEmpty()){
			return -1;
		}
		return this.root.getValue();
	}
	
	//complejidad:
	//
	public boolean isEmpty(){
		return this.root==null;
	}

	//complejidad:
	//

	public boolean hasElem(Integer value) {
		return this.hasElem(this.root, value);
	}

	private boolean hasElem(TreeNode node, Integer value) {
		if (this.isEmpty()) {
			return false;
		} else {
			int result = node.getValue().compareTo(value);
			if (result == 0) {
				return true;
			} else {
				if (result > 0) {// Si es mayor Va por derecha
					return hasElem(node.getRight(), value);
				} else {// Si es menor busca por la izquierda
					return hasElem(node.getLeft(), value);
				}
			}
		}
	}
	
	//complejidad:
	//
	public void delete(Integer value) {
		root = this.deleteNode(root, value);
	}

	private TreeNode deleteNode(TreeNode actual, Integer value) {
		//funcion  de corte
		if (actual == null) {
			return null;
		}
		//
		int state = value.compareTo(actual.getValue());
		if (state < 0) {
			actual.setLeft(deleteNode(actual.getLeft(), value));
		} else if (state > 0) {
			actual.setRight(deleteNode(actual.getRight(), value));
		} else {
			if (actual.getLeft() == null) {
				return actual.getRight();
			} else if (actual.getRight() == null) {
				return actual.getLeft();
			}

			Integer valueMoreLeft = findNodeMoreLeft(actual.getRight());
			actual.setValue(valueMoreLeft);
			actual.setRight(deleteNode(actual.getRight(), actual.getValue()));
		}

		return actual;
	}

	private Integer findNodeMoreLeft(TreeNode node) {
		if (node.getLeft() == null) {
			return node.getValue();
		}
		return findNodeMoreLeft(node.getLeft());
	}

	//complejidad:
	//
	public int getHeight() {
		return getHeightTree(root);
	}

	private int getHeightTree(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int heightLeft = getHeightTree(node.getLeft());
		int heightRight = getHeightTree(node.getRight());
		return Math.max(heightLeft, heightRight) + 1;
	}


	//complejidad:
	//
	public void printPosOrden(){

	}

	//complejidad:
	//
	public void printPreOrden(){

	}

	//complejidad:
	//
	public void printInOrden(){
	
	}

	//complejidad:
	//
	public List<Integer> getLongerBranch() {
        ArrayList<Integer> longer = new ArrayList<>();
        // Aquí puedes agregar elementos a la lista si es necesario
        return longer;
    }

	//complejidad:
	//
	public List<Integer> getFrontera(){
		return null;
		
	}

	//complejidad:
	//
	public void getMaxElem(){
		
	}

	//complejidad:
	//
	public List<Integer> getElemAtLevel(int x){
		return null;

	}


}
