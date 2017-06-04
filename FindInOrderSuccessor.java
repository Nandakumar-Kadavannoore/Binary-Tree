
/**
 * 
 * @author Nandakumar_K
 *
 * Finding of InOrder successor in Binary Search Tree
 */

/*
 * Class for node in Tree
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
	
	// Funcation to find the InOrder successor
	static Node inOrderSuccessor(Node root,Node node){
		
		if(node.right != null)   // InOrder successor in BST always in right side if exist
			return minValue(node.right);
		
		Node successor = null;
		
		// else case iterate over tree to find out
		while(root != null){
			if(root.data > node.data){
				successor = root;
				root = root.left;
			}else if(node.data > root.data)
				root = root.right;
			else
				break;
		}
		return successor;
	}
	
	// To find minimum value in BST
	private static Node minValue(Node node) {
		while(node.left != null)
			 node = node.left;
		return node;
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
	  	    
	    BinaryTree binaryTree = new BinaryTree();  // Creating BinarySearchTree Object of Integer Type
	    binaryTree.root = new Node(20);
        binaryTree.root.left = new Node(8);
        binaryTree.root.right = new Node(22);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(12);
        binaryTree.root.left.right.left = new Node(10);
        binaryTree.root.left.right.right = new Node(14);
	    
	    printInOrder(binaryTree.root); 
	    
	   Node result = inOrderSuccessor(binaryTree.root, binaryTree.root.left);
	   
	   if(result != null)
       System.out.println("The InOrder Successor is "+result.data);	
	}	

}
