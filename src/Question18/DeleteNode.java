package Question18;
/*
 * 删除链表的节点。
 * 注意：
 * 1.需要在O(1)的时间内；
 * 2.尾节点的处理；
 * 3.只有一个节点的处理。
 */
public class DeleteNode {
	public static void main(String args[]) {
		Node head = new Node(0);
		Node node = head;
		for(int i = 1;i<3;i++) {//创建节点
			node.nextNode = new Node(i);
			node = node.nextNode;
		}
		node = head;
		while(node!=null) {//打印链表
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
		System.out.println();
		deleteNode(head,head.nextNode.nextNode);
		node = head;
		while(node!=null) {//打印之后的链表
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
	}
	
	public static void deleteNode(Node head,Node node) {
		if(head == null || node == null) {
			return ;
		}
		if(node.nextNode!=null) {  //删除的节点不为尾节点
			node.value = node.nextNode.value;
			node.nextNode = node.nextNode.nextNode;
			return ;
		}
		if(head == node) {//链表只有一个结点,这个结果传不出去，有问题
			head = null;
			return ;
		}
		while(head.nextNode.nextNode!=null) {
			head = head.nextNode;
		}
		head.nextNode = null;
		return ;
	}
}

class Node {
	Node(int value) {
		this.value = value;
	}
	int value;
	Node nextNode;
}
