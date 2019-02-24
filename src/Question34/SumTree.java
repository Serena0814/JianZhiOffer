package Question34;

import java.util.Stack;

/*
 * 打印和为某一值的路径:
 * 注意点：
 * 1.路径必然为根节点至叶节点的一条路径
 * 2.必然先经过根节点则选择前序遍历
 * 3.要把经过的路径压栈
 * 4.递归的运用
 */
public class SumTree {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(10);
		tree.left = new BinaryTreeNode(5);
		tree.right = new BinaryTreeNode(12);
		tree.left.left = new BinaryTreeNode(4);
		tree.left.right = new BinaryTreeNode(7);
		printSumTree(tree,22);
	}
	
	public static void printSumTree(BinaryTreeNode tree,int sum) {
		Stack<BinaryTreeNode> path = new Stack<BinaryTreeNode>();
		if(tree == null) {
			return;
		}
		path.push(tree);
		printPath(tree,sum,path);
	}
	
	public static void printPath(BinaryTreeNode tree,int sum,Stack<BinaryTreeNode> path) {
		if(tree.left == null && tree.right == null) {
			int sumtemp = 0;
			for(BinaryTreeNode node:path) {
				sumtemp += node.value;
			}
			if(sumtemp == sum) {
				for(BinaryTreeNode node:path) {
					System.out.print(node.value+ " ");
				}
				System.out.println();
			}
			return;
		}
		path.push(tree.left);
		printPath(tree.left,sum,path);
		path.pop();
		path.push(tree.right);
		printPath(tree.right,sum,path);
		path.pop();
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