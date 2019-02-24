package Question35;
/*
 * ���Ƹ�������
 * �ؼ��㣺�������ߣ�
 * 1.����ÿ���ڵ��next�ڵ�
 * 2.����another�ڵ�
 * 3.���в��
 */
public class CopyLinkedList {
	public static void main(String args[]) {
		ComplexListNode list = new ComplexListNode(1);
		list.next = new ComplexListNode(2);
		list.next.next = new ComplexListNode(3);
		list.next.next.next = new ComplexListNode(4);
		list.next.next.next.next = new ComplexListNode(5);
		list.another = new ComplexListNode(9);
		list.next.another = list.next.next.next.next;
		list.next.next.next.another = list.next;
		printList(list);
		printList(copyLinkedList(list));
	}
	
	public static ComplexListNode copyLinkedList(ComplexListNode list) {
		if(list == null) {
			return null;
		}
		ComplexListNode head = list;
		while(list != null) {            //���Ʋ�����next�ڵ�
			ComplexListNode temp = list.next;
			list.next = new ComplexListNode(list.value);
			list = list.next;
			list.next = temp;
			list = list.next;
		}
		
		list = head;                    //����another�ڵ�
		while(list != null) {
			if(list.another == null || list.another.next == null) {      //another�ڵ㲻���ڻ�Ϊ�����ڵ�
				list.next.another = list.another;
				list = list.next.next;
			}
			else {
				list.next.another = list.another.next;       //�˽ڵ��Ѵ���
				list = list.next.next;
			}
		}
		
		list = head;                                //�����������
		ComplexListNode headCopy = head.next;
		ComplexListNode headList = head.next;
		while(headCopy.next != null) {
			list.next = list.next.next;
			headCopy.next = headCopy.next.next;
			list = list.next;
			headCopy = headCopy.next;
		}
		return headList;
	}
	
	public static void printList(ComplexListNode list) {
		if(list == null) {
			return;
		}
		while(list != null) {
			System.out.print(list.value + " ");
			if(list.next != null && list.another != null) {
				System.out.println(list.next.value + " "+list.another.value);
			}
			else if(list.next == null && list.another != null) {
				System.out.println("0 "+list.another.value);
			}
			else if(list.next != null && list.another == null) {
				System.out.println(list.next.value + " 0");
			}
			else {
				System.out.println("0 0");
			}
			list = list.next;
		}
	}
}

class ComplexListNode {
	int value;
	ComplexListNode next;
	ComplexListNode another;
	ComplexListNode(int value) {
		this.value = value;
	}
}