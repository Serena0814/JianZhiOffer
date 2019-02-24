package Question32;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 问题一：
 * 层序遍历二叉树(广度优先遍历)：
 * 队列的应用
 */
public class PrintTree {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);
		tree.left = new BinaryTreeNode(6);
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		printTree(tree);
	}
	
	public static void printTree (BinaryTreeNode tree) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		if(tree == null) {
			return;
		}
		queue.add(tree);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.value + " ");
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
}


class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode (int value) {
		this.value = value;
	}
}