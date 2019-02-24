package Question23;

/*
 * 找到链表中环的入口：
 * 1.考虑链表是否带环；
 * 2.若带环，计算环中有几个元素，这步方便求出环的入口节点；
 * 3.求出环的入口节点。
 */
public class ListDoorway {
	public static void main(String args[]) {
		ListNode list1 = new ListNode();
		ListNode head = list1;
		for(int i = 0;i<10;i++) {   //初始化链表
			list1.value = i;
			list1.nextlist = new ListNode();
			list1 = list1.nextlist;
		}
		list1.nextlist = head.nextlist.nextlist;
		System.out.print(listDoorway(head).value);
	}
	
	public static ListNode listDoorway(ListNode list) {
		if(list == null || list.nextlist == null) {
			return list;
		}
		ListNode point1 = list;
		ListNode point2 = list.nextlist;
		while(point2 != null && point2.nextlist != null && point1 != point2) {
			point1 = point1.nextlist;
			point2 = point2.nextlist.nextlist;
		}
		if(point2 == null || point2.nextlist == null) {   //无环
			return null;
		}
		int count = 1;
		point2 = point2.nextlist;
		while(point1 != point2) {    //有环求个数
			count ++;
			point2 = point2.nextlist;
		}
		
		point1 = list;
		point2 = list;
		for(int i = 0;i < count;i++) {
			point2 = point2.nextlist;
		}
		while(point2 != point1) {     //求环的入口节点
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