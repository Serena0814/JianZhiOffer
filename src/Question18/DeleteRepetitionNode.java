package Question18;
/*
 * ɾ���ظ��Ľڵ�
 */
public class DeleteRepetitionNode {
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
		deleteRepetitionNode(head);
		node = head;
		while(node!=null) {//��ӡ֮�������
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
