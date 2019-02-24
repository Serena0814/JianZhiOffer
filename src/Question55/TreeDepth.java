package Question55;
/*
 * �����������
 * ����һ��
 * ����������������
 * ע:
 * תΪ�Ż����⣬�Ӷ�Ѱ���Ż�������
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