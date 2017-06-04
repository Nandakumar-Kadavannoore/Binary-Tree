package me.start.binarytree;


/**
 * 
 * @author Nandakumar_K
 *
 * Finding of lowest common ancestor in Binary Tree
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
	
	// Function to find lowest common Ancestor
	static Node lowestCommon(Node node,int valueOne,int valueTwo){
		
		if(node == null)
			return null;
		
		if(node.data > valueOne && node.data > valueTwo)
			return lowestCommon(node.left, valueOne, valueTwo);
		
		if(node.data < valueOne && node.data < valueTwo)
            return lowestCommon(node.right, valueOne, valueTwo);
	
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
	  	    
	    BinaryTree binaryTree = new BinaryTree();  // Creating BinaryTree Object of Integer Type
	    binaryTree.root = new Node(20);
        binaryTree.root.left = new Node(8);
        binaryTree.root.right = new Node(22);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(12);
        binaryTree.root.left.right.left = new Node(10);
        binaryTree.root.left.right.right = new Node(14);
	    
	    printInOrder(binaryTree.root); 
	    
	   Node result = lowestCommon(binaryTree.root,12,4);
	   
	   if(result != null)
       System.out.println("The Lowest Common Ancestor is "+result.data);	
	}	

}
