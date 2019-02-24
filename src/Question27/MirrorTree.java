package Question27;
/*
 * 求出一颗树的镜像
 * 注意：
 * 方法可以为递归或循环，两种方法都运行
 */
public class MirrorTree {
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
		
		mirrorTree(tree);    //递归方法
		printTree(tree);
		System.out.println();
	}
	
	public static void mirrorTree(BinaryTreeNode tree) {
		if(tree == null) {
			return;
		}
		if(tree.left == null && tree.right == null) {
			return;
		}
		exchange(tree);
		mirrorTree(tree.left);
		mirrorTree(tree.right);
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

class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode (int value) {
		this.value = value;
	}
}