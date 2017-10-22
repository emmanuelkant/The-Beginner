package test;

import tree.BinaryTree;

public class TestTree {
	
	public static void main(String[] args){
		
		BinaryTree tree = new BinaryTree();
		
		tree.insetNode(15);
		tree.insetNode(22);
		tree.insetNode(17);
		tree.insetNode(10);
		tree.insetNode(20);
		tree.insetNode(16);
		
		tree.inOrder(tree.getRoot());
		
		
	}

}
