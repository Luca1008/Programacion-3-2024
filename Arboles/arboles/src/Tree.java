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
	public void printPosOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pos Order");
			printPosOrder(this.root);
		}
	}

	private void printPosOrder(TreeNode node) {
		if (node != null) {
			printPosOrder(node.getLeft());
			printPosOrder(node.getRight());
			System.out.print(" - " + node.getValue());
		}
	}

	//complejidad:
	//
	public void printPreOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pre Order");
			printPreOrder(this.root);
		}
	}

	private void printPreOrder(TreeNode node) {
		if (node != null) {
			if (node.hasCharacter()) {
				System.out.print(" - " + node.getValue() + "|" + node.getCharacter());
			} else {
				System.out.print(" - " + node.getValue());
			}
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	//complejidad:
	//
	public void printInOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pos Order");
			printInOrder(this.root);
		}
	}

	private void printInOrder(TreeNode node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.print(" - " + node.getValue());
			printInOrder(node.getRight());
		}
	}

	//complejidad:
	//
	public List<Integer> getLongerBranch() {
		List<Integer> actualBranch = new ArrayList<>();
		List<Integer> longestBranch = new ArrayList<>();
		getLongestBranch(root, actualBranch, longestBranch);
		return longestBranch;
	}

	private void getLongestBranch(TreeNode node, List<Integer> actualBranch, List<Integer> longestBranch) {
		if (node == null) {
			return;
		}
		actualBranch.add(node.getValue());
		if (node.isLeaft()) {
			if (actualBranch.size() > longestBranch.size()) {
				longestBranch.clear();
				longestBranch.addAll(actualBranch);
			}
		}
		getLongestBranch(node.getLeft(), actualBranch, longestBranch);
		getLongestBranch(node.getRight(), actualBranch, longestBranch);
		actualBranch.remove(actualBranch.size() - 1);
	}

	//complejidad:
	//
	public List<Integer> getFrontier() {
		List<Integer> frontier = new ArrayList<Integer>();
		getFrontier(root, frontier);
		return frontier;
	}

	private void getFrontier(TreeNode node, List<Integer> frontier) {
		if (node == null) {
			return;
		}
		if (node.isLeaft()) {
			frontier.add(node.getValue());
		}
		getFrontier(node.getLeft(), frontier);
		getFrontier(node.getRight(), frontier);
	}

	//complejidad:
	//
	public Integer getMaxElem() {
		return getMaxElem(root);
	}

	private Integer getMaxElem(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.getRight() == null) {
			return node.getValue();
		}
		return getMaxElem(node.getRight());
	}

	//complejidad:
	//
	public List<Integer> getElemAtLevel(int level) {
		List<Integer> listElements = new ArrayList<Integer>();
		getElemAtLevel(root, 0, level, listElements);
		return listElements;
	}

	private void getElemAtLevel(TreeNode node, int actualLevel, int level, List<Integer> listElements) {
		if (node == null) {
			return;
		}
		if (actualLevel == level) {
			listElements.add(node.getValue());
		}
		actualLevel += 1;
		getElemAtLevel(node.getLeft(), actualLevel, level, listElements);
		getElemAtLevel(node.getRight(), actualLevel, level, listElements);
		actualLevel -= 1;
	}


}
