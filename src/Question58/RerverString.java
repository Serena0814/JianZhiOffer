package Question58;
/*
 * ��ת�ַ�����
 * ����һ:��ת����˳�򲻸ı����˳��
 * ע��
 * ���η�ת���Ⱦ��ӷ�ת���ٵ��ʷ�ת
 */
public class RerverString {
	public static void main(String args[]) {
		
	}
	
	public static String ReverseSentence(String str) {
		int length = str.length();
        if(length == 0 ) {
        	return str;
        }
        
        char[] c = str.toCharArray();
       
        //���ӷ�ת
        reverse(c,0,length - 1);
        
        //���ʷ�ת
        int start  = 0;
        int end = 0;
        int i = 0;
        while(i < length) {
        	while(i < length && c[i] == ' ') { //�����ո�   //��ţ�ĳ���������ţ���������ʡʱ�䣡����
        		i ++;
        	}
        	start = i;
        	while(i < length && c[i] != ' ') {  //������ĸ
        		i++;
        	}
        	end = i - 1;
        	reverse(c,start,end);
        		
        }
        return new String(c);
    }
	
	public static void reverse (char[] c,int start,int end) {
		while(start <= end) {
        	char t = c[start];
        	c[start] = c[end];       	
        	c[end] = t;
        	start ++;
        	end--;
		}
		return;
	}
}
