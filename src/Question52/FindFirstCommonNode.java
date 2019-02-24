package Question52;
/*
 * 两个链表的第一个公共节点
 * 
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindFirstCommonNode {
	public static void main(String args[]) {
		
		System.out.println();
	}
	
	public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null) {
			 return null;
		 }
		 int length1 = countLength(pHead1);
		 int length2 = countLength(pHead2);
		 
		 ListNode head1 = pHead1;
		 ListNode head2 = pHead2;
		 
		 if(length1 > length2) {
			 for(int i = 0 ;i < length1 - length2;i ++) {
				 head1 = head1.next;
			 }
		 }else if (length2 > length1) {
			 for(int i = 0 ;i < length2 - length1;i ++) {
				 head2 = head2.next;
			 }
		 }
		 
		 while(head1 != null) {
			 if(head1 == head2) {
				 return head1;
			 }
			 head1 = head1.next;
			 head2 = head2.next;
		 }
		 return null;
    }
	
	public static int countLength(ListNode p) {
		int count = 0;
		ListNode head = p;  //先复制头节点
		while(head != null) {
			count ++;
			head = head.next;
		}
		return count;
	}
}

