package Question67;
/*
 * 将字符串转化为数字
 */
public class StrToInt {
	public int strToInt(String str) {
        int length = str.length();
        if(length == 0) {
        	return 0;
        }
        boolean simble = true;   //开头有没有符号
        boolean flag = true;     //此数为正数还是复数
        int num = 0;
        
        //先判断第一个数字
        if(str.charAt(0) == '-') {   //有符号复数
        	flag = false;
        }else if (str.charAt(0) == '+') {      //有符号正数   	
        }else if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {  //无符号正数
        	simble = false;
        	num = str.charAt(0) - '0';
        } else {
        	return 0;
        }
        
       //只有一个字母的情况
        if(length == 1) {    
        	if(simble) return 0;
        	else return num;
        }
        
        //两个以上字母的情况
        for(int i = 1;i < length;i++) {
        	if(str.charAt(i) < '0' || str.charAt(i) > '9') {
        		return 0;
        	}
        	num = num * 10 + (str.charAt(i) - '0');
        }
        
        if(!flag) num *= (-1);  //复数的情况
        
        return num;
    }
}
