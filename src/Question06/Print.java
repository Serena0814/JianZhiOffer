package Question06;

public class Print {
	public static void main(String args[]) {
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
		
		myPrint2(listnode);
	}
	
	public static ListNode addNumber(ListNode node,int value) { //链表中添加数字
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
	
	public static void myPrint1(ListNode node) {    //方法一 ：栈的应用
		Stack mystack = new Stack();
		if (node == null) {
			System.out.println("链表为空");
			return ;
		}
		while(node!=null) {      //进栈
			mystack.push(node);
			node = node.nextnode;
		}
		System.out.print("反转链表：{ ");
		while(!mystack.empty()) {
			System.out.print(mystack.pop()+" ");
		}
		System.out.print("}");
	}
	
	public static void myPrint2(ListNode node) {  //方法二：递归
		if (node == null) {
			System.out.println("链表为空");
			return ;
		}
		if(node.nextnode!=null) {
			myPrint2(node.nextnode);
		}
		System.out.print(node.value+" ");
	}
}

class Stack {     //设计一个栈
	ListNode stack;
	boolean empty() {
		if(stack == null) {
			return true;
		}
		else {
			return false;
		}
	}
	void push(ListNode t) {
		if(stack == null) {
			stack = t;
			return ;
		}
		ListNode temp = stack;
		while (temp!=null) {
			temp = temp.nextnode;
		}
		temp = t;
		return ;
	}
	int pop() {
		ListNode temp = stack;
		if(stack.nextnode == null) {
			int t = stack.value;
			stack = null;
			return t;
		}
		while (temp.nextnode.nextnode!=null) {
			temp = temp.nextnode;
		}
		int t = temp.nextnode.value;
		temp.nextnode = null;
		return t;
	}
}