package Question25;
/*
 * 合并两个排序链表
 * 注意：用递归
 */
public class MergeList {
	public static void main(String args[]) {
		ListNode list1 = null;
		ListNode list2 = new ListNode();
		list2.value = 2;
		list2.nextList = new ListNode();
		list2.nextList.value = 4;
		ListNode list = mergeList(list1,list2);
		while(list != null) {
			System.out.print(list.value+" ");
			list = list.nextList;
		}
	}
	
	public static ListNode mergeList(ListNode list1,ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		ListNode list = null;
		if(list1.value > list2.value) {
			list = list2;
			list.nextList = mergeList(list1,list2.nextList);
		}
		else {
			list = list1;
			list.nextList = mergeList(list1.nextList,list2);
		}
		return list;
	}
}

class ListNode {
	int value;
	ListNode nextList;
}