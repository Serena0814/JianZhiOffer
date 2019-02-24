package Question24;
/*
 * ��ת����
 * ��һ����Ҫ��������ָ��
 * �������õݹ飨δ����
 */

public class Reverse {
	public static void main(String args[]) {
		ListNode list1 = new ListNode();
		ListNode head = list1;
		for(int i = 0;i<10;i++) {   //��ʼ������
			list1.value = i;
			list1.nextlist = new ListNode();
			list1 = list1.nextlist;
		}
		ListNode list2 = head;
		while(list2 != null) {   //��ӡ���������н��
			System.out.print(list2.value+" ");
			list2 = list2.nextlist;
		}
		System.out.println();
		ListNode list3 = reverseList(head);//��֤���
		while(list3 != null) {              //��ӡ��ת���������н��
			System.out.print(list3.value+" ");
			list3 = list3.nextlist;
		}     
	}
	
	public static ListNode reverseList(ListNode list) {
		if(list == null || list.nextlist == null) {
			return list;
		}
		ListNode point1 = list;
		ListNode point2 = list.nextlist;
		point1.nextlist = null;
		if(point2.nextlist == null) {
			point2.nextlist = point1;
			return point2;
		}
		ListNode point3 = point2.nextlist;
		while(point3 != null) {
			point2.nextlist = point1;
			point1 = point2;
			point2 = point3;
			point3 = point3.nextlist;
		}
		point2.nextlist = point1;
		return point2;
	}
}

class ListNode {
	int value;
	ListNode nextlist;
}