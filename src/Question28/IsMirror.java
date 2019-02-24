package Question28;

/*
 * 判断是否为对称二叉树
 * 注意：
 * 1.考虑数字对称与结构对称
 * 2.定义遍历的方式：先右后左
 */
public class IsMirror {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);     //构造树以便测试
		tree.left = new BinaryTreeNode(6); 
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		System.out.println(isMirror(tree));
		
		BinaryTreeNode tree2 = new BinaryTreeNode(8);     //构造树以便测试
		tree.left = new BinaryTreeNode(6); 
		tree.right = new BinaryTreeNode(6);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(7);
		tree.right.right = new BinaryTreeNode(5);
		System.out.println(isMirror(tree2));
	}
	
	public static boolean isMirror(BinaryTreeNode tree) {
		if (tree == null) {
			return true;
		}
		return isMirror(tree,tree);
	}
	public static boolean isMirror(BinaryTreeNode tree1,BinaryTreeNode tree2) {
		if(tree1 == null && tree2 == null) {
			return true;
		}
		if(tree1 == null || tree2 == null) {
			return false;
		}
		if(tree1.value != tree2.value) {
			return false;
		}
		return isMirror(tree1.left,tree2.right) && isMirror(tree1.right,tree2.left);
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