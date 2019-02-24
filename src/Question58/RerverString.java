package Question58;
/*
 * 翻转字符串：
 * 问题一:翻转单词顺序不改变句子顺序
 * 注：
 * 两次翻转：先句子反转，再单词反转
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
       
        //句子翻转
        reverse(c,0,length - 1);
        
        //单词反转
        int start  = 0;
        int end = 0;
        int i = 0;
        while(i < length) {
        	while(i < length && c[i] == ' ') { //跳过空格   //大牛的程序就是优雅！！！还节省时间！！！
        		i ++;
        	}
        	start = i;
        	while(i < length && c[i] != ' ') {  //跳过字母
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
