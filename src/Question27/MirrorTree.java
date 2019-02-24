package Question27;
/*
 * ���һ�����ľ���
 * ע�⣺
 * ��������Ϊ�ݹ��ѭ�������ַ���������
 */
public class MirrorTree {
	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode(8);     //�������Ա����
		tree.left = new BinaryTreeNode(6); 
		tree.right = new BinaryTreeNode(10);
		tree.left.left = new BinaryTreeNode(5);
		tree.left.right = new BinaryTreeNode(7);
		tree.right.left = new BinaryTreeNode(9);
		tree.right.right = new BinaryTreeNode(11);
		
		printTree(tree);
		System.out.println();
		
		mirrorTree(tree);    //�ݹ鷽��
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
	
	public static void printTree(BinaryTreeNode tree) {   //ǰ�����
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