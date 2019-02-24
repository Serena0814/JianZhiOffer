package Question58;
/*
 * ��Ŀ���������ַ���
 * ��Ȼ�����η�ת
 */
public class LeftString {
	
	
	public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length == 0 || length < n) {
        	return new String();
        }
        char[] c = str.toCharArray();
       
        reverse(c,0,n-1);
        reverse(c,n,length - 1);
        reverse(c,0,length - 1);
        return new String(c);
    }
	
	public void reverse(char[] c,int start,int end) {
		while(start < end) {
			char t = c[start];
			c[start] = c[end];
			c[end] = t;
			start ++;
			end --;
		}
	}
}
