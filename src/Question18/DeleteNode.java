package Question18;
/*
 * ɾ������Ľڵ㡣
 * ע�⣺
 * 1.��Ҫ��O(1)��ʱ���ڣ�
 * 2.β�ڵ�Ĵ���
 * 3.ֻ��һ���ڵ�Ĵ���
 */
public class DeleteNode {
	public static void main(String args[]) {
		Node head = new Node(0);
		Node node = head;
		for(int i = 1;i<3;i++) {//�����ڵ�
			node.nextNode = new Node(i);
			node = node.nextNode;
		}
		node = head;
		while(node!=null) {//��ӡ����
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
		System.out.println();
		deleteNode(head,head.nextNode.nextNode);
		node = head;
		while(node!=null) {//��ӡ֮�������
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
	}
	
	public static void deleteNode(Node head,Node node) {
		if(head == null || node == null) {
			return ;
		}
		if(node.nextNode!=null) {  //ɾ���Ľڵ㲻Ϊβ�ڵ�
			node.value = node.nextNode.value;
			node.nextNode = node.nextNode.nextNode;
			return ;
		}
		if(head == node) {//����ֻ��һ�����,������������ȥ��������
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
