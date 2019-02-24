package Question26;
/*
 * A树中是否含有子树B
 * 注意（分两步走）：
 * 1.树A中找到与B根节点一样的的节点R（递归）
 * 2.判断以R为根节点的子树是否包含B
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
	
	public static boolean hasSubtree(BinaryTreeNode tree1,BinaryTreeNode tree2) {    //第一步找相同根节点
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
	
	public static boolean doseTree1HaveTree2(BinaryTreeNode tree1,BinaryTreeNode tree2) { //第二步找子树
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