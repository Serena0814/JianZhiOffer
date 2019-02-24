package Question34;

import java.util.Stack;

/*
 * ��ӡ��Ϊĳһֵ��·��:
 * ע��㣺
 * 1.·����ȻΪ���ڵ���Ҷ�ڵ��һ��·��
 * 2.��Ȼ�Ⱦ������ڵ���ѡ��ǰ�����
 * 3.Ҫ�Ѿ�����·��ѹջ
 * 4.�ݹ������
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