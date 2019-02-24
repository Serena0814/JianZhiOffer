package Question32;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 问题二：分行打印二叉树
 * 比问题一多设置两个变量
 */
public class PrintTreeLine {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);
		tree.left = new BinaryTreeNode(6);
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		printTreeLine(tree);
	}
	
	public static void printTreeLine(BinaryTreeNode tree) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		if(tree == null) {
			return;
		}
		int present = 0;
		int next = 0;
		queue.add(tree);
		present++;
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.value + " ");
			present --;
			if(temp.left != null) {
				queue.add(temp.left);
				next++;
			}
			if(temp.right != null) {
				queue.add(temp.right);
				next ++;
			}
			if(present == 0) {
				System.out.println();
				present = next;
				next = 0;
			}
		}
	}
}
