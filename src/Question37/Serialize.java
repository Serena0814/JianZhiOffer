package Question37;

/*
 * 序列化和反序列化二叉树
 * 注意：
 * 1.二叉树序列化后可以用此数列直接反序列化，含'$'
 * 2.前序遍历
 * 3.递归的应用
 */
public class Serialize {
	static int index = 0;//全局变量
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
	
	 public static String serializeFinal (TreeNode root) {      //两个函数是序列化
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
	 
	 
	 public static TreeNode deserializeFinal(String str) {   //两个函数是反序列化
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
