package Question26;
/*
 * A�����Ƿ�������B
 * ע�⣨�������ߣ���
 * 1.��A���ҵ���B���ڵ�һ���ĵĽڵ�R���ݹ飩
 * 2.�ж���RΪ���ڵ�������Ƿ����B
 */
public class HasSubtree {
	public static void main(String args[]) {
		BinaryTreeNode tree1 = new BinaryTreeNode(8);
		tree1.left = new BinaryTreeNode(8);
		tree1.right = new BinaryTreeNode(7);
		tree1.left.left = new BinaryTreeNode(9);
		tree1.left.right = new BinaryTreeNode(2);
		
		BinaryTreeNode tree2 = new BinaryTreeNode(8);
		tree2.left = new BinaryTreeNode(9);
		tree2.right = new BinaryTreeNode(2);
		
		System.out.print(hasSubtree(tree1,tree2));
	}
	
	public static boolean hasSubtree(BinaryTreeNode tree1,BinaryTreeNode tree2) {    //��һ������ͬ���ڵ�
		boolean result = false;
		if(tree1 == null || tree2 == null) {
			return result;
		}
		if(equal(tree1.value,tree2.value)) {
			result = doseTree1HaveTree2(tree1,tree2); 
		}
		if(!result) {
			result = hasSubtree(tree1.left,tree2);
		}
		if(!result) {
			result = hasSubtree(tree1.right,tree2);
		}
		return result;
	}
	
	public static boolean doseTree1HaveTree2(BinaryTreeNode tree1,BinaryTreeNode tree2) { //�ڶ���������
		boolean result = false;
		if(tree2 == null) {
			return true;
		}
		if(tree1 == null) {
			return false;
		}
		if(equal(tree1.value,tree2.value)) {
			result = doseTree1HaveTree2(tree1.left,tree2.left) && doseTree1HaveTree2(tree1.right,tree2.right);
		}
		return result;
	}
	
	public static boolean equal(double a,double b) {
		if(a - b < 0.000001 && a - b > -0.000001) {
			return true;
		}
		else {
			return false;
		}
	}
}

class BinaryTreeNode {
	double value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode (double value) {
		this.value = value;
	}
}