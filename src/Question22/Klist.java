package Question22;

public class Klist {
	public static void main(String args[]) {
		ListNode list1 = new ListNode();
		ListNode head = list1;
		for(int i = 0;i<10;i++) {   //初始化链表
			list1.value = i;
			list1.nextlist = new ListNode();
			list1 = list1.nextlist;
		}
		ListNode list2 = head;
		while(list2 != null) {   //打印链表中所有结点
			System.out.print(list2.value+" ");
			list2 = list2.nextlist;
		}
		System.out.println();
		System.out.print(kList(head,1).value);   //验证结果
	}
	
	public static ListNode kList(ListNode list,int k) {
		if(list == null) {
			return null;
		}
		if(k <= 0) {
			return null;
		}
		ListNode point1 = list;
		ListNode point2 = list;
		for(int i = 1;i < k;i++) {
			point2 = point2.nextlist;
			if(point2 == null) {
				return null;
			}
		}
		while(point2.nextlist != null) {
			point2 = point2.nextlist;
			point1 = point1.nextlist;
		}
		return point1;
	}

}

class ListNode {
	int value;
	ListNode nextlist;
}
