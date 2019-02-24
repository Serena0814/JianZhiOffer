package Question18;
/*
 * 删除重复的节点
 */
public class DeleteRepetitionNode {
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
		deleteRepetitionNode(head);
		node = head;
		while(node!=null) {//打印之后的链表
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
	}
	public static void deleteRepetitionNode(Node head) {
		if(head == null) {
			return;
		}
		if(head.nextNode == null) {
			return;
		}
		Node node = head.nextNode;
		while(node!= null) {
			if(node.value == head.value) {
				node = node.nextNode;
			}
			else {
				head.nextNode = node;
				head = head.nextNode;
				node = node.nextNode;
			}
		}
		head.nextNode = null;
		return ;
	}
}
