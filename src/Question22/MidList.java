package Question22;

public class MidList {
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
		System.out.print(midNode(head).value);   //验证结果
	}
	
	public static ListNode midNode(ListNode list) {
		if(list == null || list.nextlist == null) {
			return list;
		}
		ListNode point1 = list;
		ListNode point2 = list;
		while(point2!=null && point2.nextlist!= null) {
			point1 = point1.nextlist;
			point2 = point2.nextlist;
			point2 = point2.nextlist;
		}
		return point1;
	}
}
