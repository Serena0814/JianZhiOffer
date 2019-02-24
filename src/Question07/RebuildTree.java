package Question07;

public class RebuildTree {
	public static void main(String args[]) {
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = reBuildTree(preorder,inorder);
		printree(root);
	}
	
	public static BinaryTreeNode reBuildTree(int[] preorder,int[] inorder) {
		BinaryTreeNode root = new BinaryTreeNode();
		root = digui(preorder,inorder,0,0,preorder.length-1);
		return root;
	}
	public static BinaryTreeNode digui(int[] preorder,int[] inorder,int prestart,int instart,int inend) {
		if(prestart >= preorder.length || instart > inend ) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(preorder[prestart]);
		int i = instart;
		for(;preorder[prestart]!=inorder[i];i++) {}
		root.left = digui(preorder,inorder,prestart+1,instart,i-1);
		root.right = digui(preorder,inorder,prestart+i-instart+1,i+1,inend);//注意第三项
		return root;
	}
	
	public static void printree(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.value+" ");
		printree(root.left);
		printree(root.right);
	}
}

class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode() {}
	BinaryTreeNode(int val) {
		value = val;
	}
}
