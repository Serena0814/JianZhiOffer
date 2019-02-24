package Question54;
/*
 * 二叉搜索树的第K大节点
 * 中序遍历的思想
 */
public class SearchTree {
	public static void main(String args[]) {
		
		System.out.println();
	}
	
	public static TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0) {
			return null;
		}
		return digui(pRoot,k);
	}
	static int index = 0;
	public static TreeNode digui(TreeNode pRoot, int k) {
		TreeNode target = null;
		if(pRoot.left != null) {
			target = digui(pRoot.left,k);
		}
		if(target == null) {
			index ++;
			if(index == k) {
				return pRoot;
			}
		}
		if(target == null && pRoot.right != null) {
			target = digui(pRoot.right,k);
		}
		return target;
	}
}

class TreeNode {   //节点数据类型
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}