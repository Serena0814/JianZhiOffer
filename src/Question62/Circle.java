package Question62;


/*
 * ԲȦ��ʣ�µ�����
 * ����һ��ѭ������ķ�ʽ
 * ��ʱ�临�Ӷ�ΪO(mn)���ռ临�Ӷ�Ϊ(n)
 * ������̫��֣�������
 */
public class Circle {
	 class List {
			int num;
			List next;
			List(int num) {
				this.num = num;
			}		
	 }
	 
	public int LastRemaining_Solution(int n, int m) {
        if(n < 1) {
        	return -1;
        }
        
        //��ʼ��һ����������
       List list = new List (0);
       List head = list;
       for(int i = 1 ;i < n;i++) {
    	   list.next = new List(i);
    	   list = list.next;
       } 
       list.next = head;
      // list = list.next;
      
       while(head.next != head) {
    	   //����m-1��
    	   for(int i = 1 ; i < m - 1  ;i++) {  
    		   head = head.next;
    	   }
    	   head.next = head.next.next;
    	   head = head.next;
       }
       return head.num;
    }
}


