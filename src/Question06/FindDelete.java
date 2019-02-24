package Question06;

public class FindDelete {
	public static void main(String args[]) {//删除头节点有问题
		ListNode listnode = new ListNode(0);
		for(int i = 1;i < 11; i++) {
			addNumber(listnode,i);
		}
		System.out.print("{");
		ListNode t = listnode;
		int i = 0;
		for(;i < 10;i++) {
			System.out.print(t.value+",");
			t = t.nextnode;
		}
		System.out.println(t.value+"}");
		
		findDelete(listnode,0);
		int j = 0;
		System.out.print('{');
		for(;j < 9;j++) {
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
	
	public static void findDelete(ListNode node,int value) {
		if(node == null) {
			return ;
		}
		if(node.value == value) {
			node = node.nextnode;
			return ;
		}
		ListNode t = node;
		while(t.nextnode!=null) {
			if(t.nextnode.value == value) {
				t.nextnode = t.nextnode.nextnode;
				return ;
			}
			t = t.nextnode;
		}
		if(t.value == value) {
			t.nextnode = null;
		}
		return ;
	}
}
