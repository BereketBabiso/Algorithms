package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST {
	TreeNode root;
	List<Integer> inOrderList = new ArrayList<>();
	List<Integer> preOrderList = new ArrayList<>();
	List<Integer> postOrderList = new ArrayList<>();
	List<Integer> reverseOrderList = new ArrayList<>();
	
	public void insert(int elem) {
		if(root==null) {
			TreeNode newNode = new TreeNode(elem);
			root = newNode;
		}
		else {
			TreeNode temp = root;
			boolean flag = false;
			while(!flag) {				
				if(elem<temp.val) {
					if(temp.left==null) {
						temp.left=new TreeNode(elem);
						flag=true;
					}
					else temp = temp.left;
				}
				else {
					if(temp.right==null) {
						temp.right=new TreeNode(elem);
						flag=true;
					}
					else temp = temp.right;
				}
			}			
		}	
	}	
	
	public void print() {
		System.out.print("in-order traversal: ");
		inOrderTraversal(root);
		System.out.print(this.inOrderList);
		System.out.println();
		System.out.print("pre-order traversal: ");
		preOrderTraversal(root);
		System.out.print(this.preOrderList);
		System.out.println();
		System.out.print("post-order traversal: ");
		postOrderTraversal(root);
		System.out.print(this.postOrderList);
		System.out.println();
		System.out.print("reverse-order traversal: ");
		reverseOrderTraversal(root);
		System.out.print(this.reverseOrderList);
	}
	
	public void inOrderTraversal(TreeNode node) {
		//if(node==null) return;
		if(node.left==null && node.right==null) {			
			this.inOrderList.add(node.val);
		}
		else if(node.left==null && node.right!=null) {			
			this.inOrderList.add(node.val);
			inOrderTraversal(node.right);
		}
		else if(node.left!=null && node.right==null) {
			inOrderTraversal(node.left);			
			this.inOrderList.add(node.val);
		}
		else {
			inOrderTraversal(node.left);			
			this.inOrderList.add(node.val);
			inOrderTraversal(node.right);
		}
	}
	private void preOrderTraversal(TreeNode node) {
		if(node.left==null && node.right==null) {			
			this.preOrderList.add(node.val);
		}
		else if(node.left==null && node.right!=null) {		
			this.preOrderList.add(node.val);
			preOrderTraversal(node.right);
		}
		else if(node.left!=null && node.right==null) {
			System.out.print(node.val+", ");
			this.preOrderList.add(node.val);
			preOrderTraversal(node.left);
		}
		else {
			this.preOrderList.add(node.val);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	private void postOrderTraversal(TreeNode node) {
		if(node.left==null && node.right==null) {			
			this.postOrderList.add(node.val);
		}
		else if(node.left==null && node.right!=null) {
			postOrderTraversal(node.right);
			this.postOrderList.add(node.val);						
		}
		else if(node.left!=null && node.right==null) {
			postOrderTraversal(node.left);			
			this.postOrderList.add(node.val);
		}
		else {			
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);			
			this.postOrderList.add(node.val);
		}
	}
	private void reverseOrderTraversal(TreeNode node) {
		if(node.left==null && node.right==null) {			
			this.reverseOrderList.add(node.val);
		}
		else if(node.left==null && node.right!=null) {
			reverseOrderTraversal(node.right);			
			this.reverseOrderList.add(node.val);
		}
		else if(node.left!=null && node.right==null) {			
			this.reverseOrderList.add(node.val);
			reverseOrderTraversal(node.left);
		}
		else {
			reverseOrderTraversal(node.right);			
			this.reverseOrderList.add(node.val);
			reverseOrderTraversal(node.left);
		}
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val=val;
		}
	}

	public static void main(String[] args) {
	
		BST bst = new BST();
		bst.insert(10);
		bst.insert(7);
		bst.insert(15);
		bst.insert(4);
		bst.insert(12);
		bst.insert(8);
		bst.insert(20);
		bst.insert(9);
		bst.print();

	}

}
