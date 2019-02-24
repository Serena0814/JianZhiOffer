package Question09;

public class DoubleQueueStack {
	public static void main(String args[]) {
		MyStack stack = new MyStack();
		for(int i = 0;i < 9;i++) {
			stack.push(i);;
		}
		for(int i = 0;i < 9;i++) {
			System.out.print(stack.pop()+" ");
		}
	}
}

class MyStack {
	CQueue queue1 = new CQueue();
	CQueue queue2 = new CQueue();
	int length1;
	int length2;
	boolean empty() {
		if(queue1.empty() && queue2.empty()) {
			return true;
		}
		return false;
	}
	void push(int num) {
		if(queue1.empty()) {
			queue2.appendTail(num);
			length2++;
		}
		else {
			queue1.appendTail(num);
			length1++;
		}
	}
	int pop() {
		if(!queue1.empty()) {
			for(;length1>1;length1--) {
				queue2.appendTail(queue1.deleteHead());
				length2++;
			}
			length1--;
			return queue1.deleteHead();
		}
		for(;length2>1;length2--) {
			queue1.appendTail(queue2.deleteHead());
			length1++;
		}
		length2--;
		return queue2.deleteHead();
	}
	
}