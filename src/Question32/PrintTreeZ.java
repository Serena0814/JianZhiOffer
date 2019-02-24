package Question32;

import java.util.Stack;

/*
 * 问题三之：之字形打印树
 * 关键点：
 * 1.双栈
 * 2.左右子节点不同进栈
 */
public class PrintTreeZ {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);
		tree.left = new BinaryTreeNode(6);
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		printTreeZ(tree);
	}
	
	public static void printTreeZ(BinaryTreeNode tree) {
		if(tree == null) {
			return;
		}
		int present = 1;
		int next = 0;
		int count = 1;
		Stack<BinaryTreeNode> leftRight = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> rightLeft = new Stack<BinaryTreeNode>();
		rightLeft.push(tree);
		while(!leftRight.empty() || !rightLeft.empty()) {
			if(count % 2 == 1) {
				BinaryTreeNode temp = rightLeft.pop();
				System.out.print(temp.value+ " ");
				present--;
				if(temp.left != null) {
					leftRight.push(temp.left);
					next++;
				}
				if(temp.right != null) {
					leftRight.push(temp.right);
					next++;
				}
				if(present == 0) {
					if(next == 0) {
						return;
					}
					System.out.println();
					present = next;
					next = 0;
					count++;
				}
			}
			else {
				BinaryTreeNode temp = leftRight.pop();
				System.out.print(temp.value+ " ");
				present--;
				if(temp.right != null) {
					rightLeft.push(temp.right);
					next++;
				}
				if(temp.left != null) {
					rightLeft.push(temp.left);
					next++;
				}
				if(present == 0) {
					if(next == 0) {
						return;
					}
					System.out.println();
					present = next;
					next = 0;
					count++;
				}
			}
		}
	}
}
