package Question27;

import java.util.Stack;

/*
 * 找镜像二叉树之循环方法
 */
public class MirrorTreeWhile {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);     //构造树以便测试
		tree.left = new BinaryTreeNode(6); 
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		printTree(tree);
		System.out.println();
		
		mirrorTree2(tree);    //循环方法
		printTree(tree);
		System.out.println();
	}
	
	public static void mirrorTree2(BinaryTreeNode tree) {  //前序遍历的循环方式
		if(tree == null) {
			return;
		}
		if(tree.left == null || tree.right == null) {
			return;
		}
		BinaryTreeNode head = tree;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(head != null || !stack.empty()) {
			exchange(head);
			stack.push(head);
			head = head.left;
			while(head == null && !stack.empty()) {
				head = stack.pop();
				head = head.right;
			}
		}
		return;
	}
	
	public static void exchange(BinaryTreeNode tree) {
		if(tree == null) {
			return;
		}
		BinaryTreeNode temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		return;
	}
	
	public static void printTree(BinaryTreeNode tree) {   //前序遍历
		if(tree == null) {
			return;
		}
		System.out.print(" "+ tree.value);
		printTree(tree.left);
		printTree(tree.right);
		return;
	}
}
