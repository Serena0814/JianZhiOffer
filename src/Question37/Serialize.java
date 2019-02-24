package Question37;

/*
 * ���л��ͷ����л�������
 * ע�⣺
 * 1.���������л�������ô�����ֱ�ӷ����л�����'$'
 * 2.ǰ�����
 * 3.�ݹ��Ӧ��
 */
public class Serialize {
	static int index = 0;//ȫ�ֱ���
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.right.left = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		String str = serializeFinal(tree);
		System.out.println(str);
		
		TreeNode node =deserializeFinal(str);
		String str2 = serializeFinal(node);
		System.out.println(str2);
	}
	
	 public static String serializeFinal (TreeNode root) {      //�������������л�
		 StringBuilder str = serialize(root);
		 return str.deleteCharAt(str.length()-1).toString();
	 }
	 public static StringBuilder serialize(TreeNode root) {
		 StringBuilder str = new StringBuilder();
		 if(root == null) {
			 return str.append("$,");
		 }
		 str.append(root.value+",");
		 str.append(serialize(root.left));
		 str.append(serialize(root.right));
		 return str;
	 }
	 
	 
	 public static TreeNode deserializeFinal(String str) {   //���������Ƿ����л�
		 if(str.length()<3) {
			 return null;
		 }
		 String[] strs = str.split(",");
		 return deserialize(strs);
	 }  
	 
	 public static TreeNode deserialize(String[] strs) {
		 if(strs[index].equals("$")) {
			 index++;
			 return null;
		 }
		 TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
		 index++;
		 node.left = deserialize(strs);
		 node.right = deserialize(strs);
		 return node;
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
