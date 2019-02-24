package Question55;
/*
 * ��Ŀ����
 * �ж�һ�����Ƿ�Ϊƽ�������
 * ע:
 * ���ú�������ķ�ʽ
 */
public class IsBalanced {
	public static void main(String args[]) {
		
	}

	public static boolean IsBalanced_Solution(TreeNode root) {
		if(IsBalanced_T(root) == -1) {
			return false;
		}
        return true;
	}
	public static int IsBalanced_T(TreeNode root) {
		if(root == null) {
        	return 0;
        }
        int left = IsBalanced_T(root.left);
        int right = IsBalanced_T(root.right);
        if(left == -1 || right == -1) {
        	return -1;
        }
        int difference = left - right;
        if(difference < -1 || difference > 1) {
        		return -1;
        }
        return (left > right ? left : right) + 1;
	}
}
