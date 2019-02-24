package Question06;

public class AddNumber {
	public static void main(String args[]) {
		ListNode listnode = new ListNode(0);
		for(int i = 1;i < 11; i++) {
			addNumber(listnode,i);
		}
		System.out.print("{");
		int i = 0;
		for(;i < 10;i++) {
			System.out.print(listnode.value+",");
			listnode = listnode.nextnode;
		}
		System.out.println(listnode.value+"}");
	}
	public static ListNode addNumber(ListNode node,int value) {
		if(node == null) {
			return new ListNode(value);
		}
		ListNode head = node;
		while(node.nextnode!=null) {
			node = node.nextnode;
		}
		node.nextnode = new ListNode(value);
		return head;
	}
}

class ListNode {
	int value;
	ListNode nextnode = null;
	ListNode(int value) {
		this.value = value;
	}
}
