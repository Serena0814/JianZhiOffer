package Question62;


/*
 * 圆圈中剩下的数字
 * 方法一：循环链表的方式
 * 其时间复杂度为O(mn)，空间复杂度为(n)
 * 方法二太奇怪！不看了
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
        
        //初始化一个环形链表
       List list = new List (0);
       List head = list;
       for(int i = 1 ;i < n;i++) {
    	   list.next = new List(i);
    	   list = list.next;
       } 
       list.next = head;
      // list = list.next;
      
       while(head.next != head) {
    	   //先走m-1步
    	   for(int i = 1 ; i < m - 1  ;i++) {  
    		   head = head.next;
    	   }
    	   head.next = head.next.next;
    	   head = head.next;
       }
       return head.num;
    }
}


