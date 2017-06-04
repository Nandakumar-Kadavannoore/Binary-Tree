/**
 * 
 * @author Nandakumar_K
 *
 * Implementation of algorthim to check Tree and Given Subtree are identical
 */

/*
 * Class for each node in Tree
 */
class Node{
	int data;
	Node left;
	Node right;
	Node(int key){
		this.data = key;
		left = right = null;
	}
}

/*
 * Class for Binary Tree 
 */
class BinaryTree{
	Node root;
	BinaryTree(int key){
		root = new Node(key);
	}
	BinaryTree(){
		root = null;
	}
}

/*
 * Main Class for Execution
 */
public class MainClass {
	
  //Check Both trees are identical
	boolean areIdentical(Node treeOne, Node treeTwo) {
		if (treeOne == null && treeTwo == null)
			return true;
		if (treeOne == null || treeTwo == null)
			return false;

		return (treeOne.data == treeTwo.data && areIdentical(treeOne.left, treeTwo.left)
				&& areIdentical(treeOne.right, treeTwo.left));
	}
	
  // Funcation to check IsSubTree
	boolean isSubTree(Node Tree, Node subTree) {
		if (Tree == null)
			return false;
		if (subTree == null)
			return true;
		if (areIdentical(Tree, subTree)) // Check for identical data for both tree
			return true;
		return isSubTree(Tree.left, subTree) || isSubTree(Tree.right, subTree);
	}
	
	
	// Perform InOrder Traversal
	static void printInOrder(Node node){
		if(node == null)
			return;
		
		printInOrder(node.left);
		System.out.println(" "+node.data);
		printInOrder(node.right);
	}
	
	public static void main(String[] args) {
	  	    
	    BinaryTree binaryTree = new BinaryTree();  // Creating dummy BinaryTree 
	    binaryTree.root = new Node(12);
	    binaryTree.root.left = new Node(23);
	    binaryTree.root.right = new Node(34);
      binaryTree.root.right.left = new Node(45);
      binaryTree.root.right.left.right = new Node(39);
      binaryTree.root.right.left.left = new Node(20);
	    
	     printInOrder(binaryTree.root);           // Displaying tree in order
	    
       BinaryTree subTree = new BinaryTree();   // Creating dummy SubTree
       subTree.root = new Node(45);
       subTree.root.right = new Node(39);
       subTree.root.left = new Node(20);
      
       printInOrder(subTree.root);
      
       if(isSubTree(binaryTree.root,subTree.root))
         System.out.printIn("It is SubTree !");
       else
         System.out.printIn("It is not SubTree !);
	    
	}	

}
