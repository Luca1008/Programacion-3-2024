import java.util.ArrayList;
import java.util.List;

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
		return this.root.getValue();
	}
	
	//complejidad:
	//
	public boolean isEmpty(){
		return this.root==null;
	}

	//complejidad:
	//
	public boolean hasElem(){
		return !isEmpty();
	}

	//complejidad:
	//
	public boolean deleteElem(int x){
		return false;
	}

	//complejidad:
	//
	public int getHeight(){
		return 0;
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
