package Question55;
/*
 * 二叉树的深度
 * 问题一：
 * 求任意二叉树的深度
 * 注:
 * 转为优化问题，从而寻找优化子问题
 */
public class TreeDepth {
	public static void main(String args[]) {
		
	}
	
	public static int treeDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int max = left > right ? left : right;
        return max + 1;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}