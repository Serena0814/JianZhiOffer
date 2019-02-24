package Question36;
/*
 * ������������ת��Ϊ˫������
 * ע�⣺
 * 1.��������ڶ����������е��������൱�ڴ�С��������
 * 2.���ҵ�ͷ�ڵ�,ȫ�ֱ�����ʹ��
 * 3.�ݹ������
 */
public class Transfer {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(6);
		tree.right = new TreeNode(14);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(8);
		tree.right.left = new TreeNode(12);
		tree.right.right = new TreeNode(16);
		transfer(tree);
		while(head != null) {
			System.out.print(" "+head.value);
			head = head.right;
		}
		
	}
	static TreeNode head = null;  //ȫ�ֱ�����ʹ��
	static TreeNode last = null;	
	public static void transfer(TreeNode tree) {       
		if(tree == null) {
			return;
		}
		transfer(tree.left);
		if (head == null) {
			head = tree;
			last = tree;
		}
		else {
			tree.left = last;
			last.right = tree;
			last = tree;
		}
		transfer(tree.right);
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int value) {
		this.value = value;
	}
}