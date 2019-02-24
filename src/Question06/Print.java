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
	
	public static ListNode addNumber(ListNode node,int value) { //�������������
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
	
	public static void myPrint1(ListNode node) {    //����һ ��ջ��Ӧ��
		Stack mystack = new Stack();
		if (node == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		while(node!=null) {      //��ջ
			mystack.push(node);
			node = node.nextnode;
		}
		System.out.print("��ת����{ ");
		while(!mystack.empty()) {
			System.out.print(mystack.pop()+" ");
		}
		System.out.print("}");
	}
	
	public static void myPrint2(ListNode node) {  //���������ݹ�
		if (node == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		if(node.nextnode!=null) {
			myPrint2(node.nextnode);
		}
		System.out.print(node.value+" ");
	}
}

class Stack {     //���һ��ջ
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