package Question08;



public class NextNode {
	public static void main(String args[]) {
		BinaryTreeNode root = buildTree();
		System.out.println(nextNode(root.left).value);
	}
	
	public static BinaryTreeNode nextNode(BinaryTreeNode node) {
		if(node == null) {
			return null;
		}
		if(node.right!=null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		}
		if(node.father == null) {
			return null;
		}
		if(node == node.father.left) {
			return node.father;
		}
		if(node.father.father == null) {
			return null;
		}
		while(node.father.father!=null) {
			if(node.father == node.father.father.left) {
				return node.father.father;
			}
			node = node.father;
		}
		return null;
	}
	
	public static BinaryTreeNode buildTree() {  //以下为根据二叉树的前序和中序，构造出二叉树
		int[] preorder = {1,2,4,5,8,9,3,6,7};
		int[] inorder = {4,2,8,5,9,1,6,3,7};
		return reBuildtree(preorder,inorder);
	}
	
	public static BinaryTreeNode reBuildtree(int[] preorder,int[] inorder) {
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
}

class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode father;
	BinaryTreeNode() {}
	BinaryTreeNode(int val) {
		value = val;
	}
}