package Question65;
/*
 * 不用加减乘除做加法：
 * 位运算:重复做异或运算与与运算(要移位)。直到与运算结果=0，即无进位。
 */
public class Add {
	public static void main(String args[]) {
		System.out.println(add(11,2));
	}
	public static int add(int num1,int num2) {
		if(num2 == 0 ) {
			return num1;
		}else if(num1 == 0) {
			return num2;
		}
		
        while(num2 != 0) {
        	int yihuo = num1 ^ num2;
        	int yu = (num1 & num2)<<1;
        	num1 = yihuo;
        	num2 = yu;
        }
        return num1;
    }
}
