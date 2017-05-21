package me.start.binarytree;

import java.util.Stack;

/**
 * 
 * @author Nandakumar_K
 *
 * Implementation of Binary Tree using Generic
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
	
	// Print given tree in spiral order
	public static void sprialPrintTree(Node node) {

		if (node == null) // Base case
			return;

		// Two stacks to store Node
		Stack<Node> stackOne = new Stack<Node>();
		Stack<Node> stackTwo = new Stack<Node>();

		stackOne.push(node); // Push root node in stack one

		while (!stackOne.empty() || !stackTwo.empty()) {

			Node currentNode = null; // Creating temporary node

			while (!stackOne.isEmpty()) {
				// print value of the node
				System.out.println(stackOne.peek().data + " ");
				currentNode = stackOne.pop();
				if (currentNode.right != null)
					stackTwo.push(currentNode.right); // Store current node's
														//right node into
														// stack two
				if (currentNode.left != null)
					stackTwo.push(currentNode.left); // Store in stack two
			}

			while (!stackTwo.isEmpty()) {
				// print value of the node
				System.out.println(stackTwo.peek().data + " ");
				currentNode = stackTwo.pop();
				if (currentNode.right != null)
					stackOne.push(currentNode.right); // Store current node's
														// right node into stack
														// one
				if (currentNode.left != null)
					stackOne.push(currentNode.left); // Store left node into
														// stack one
			}
		}
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
	    binaryTree.root = new Node(12);
	    binaryTree.root.left = new Node(23);
	    binaryTree.root.right = new Node(34);
	    
	    printInOrder(binaryTree.root); 
	    
	    
	
	}	

}
