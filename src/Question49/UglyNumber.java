package Question49;
/*
 * ����
 * �ⷨһ����ÿ�����ֽ����б��Ƿ�Ϊ����
 * �ⷨ��:�������鱣����֪����(ʹ��ţ�����ϵĴ�)
 * 
 */
public class UglyNumber {
	public static void main(String args[]) {
		System.out.println(GetUglyNumber_Solution(1500));
	}
	
	public static int GetUglyNumber_Solution(int index) {
		if(index <= 0) {
			return 0;
		}
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
       
        for (int i = 1; i < index; i++) {
        	uglyNumbers[i] = min(uglyNumbers[m2] *2 , uglyNumbers[m3] * 3,uglyNumbers[m5] * 5);
        	if (uglyNumbers[i] == uglyNumbers[m2] * 2)  m2++;
        	if (uglyNumbers[i] == uglyNumbers[m3] * 3)  m3++;
        	if (uglyNumbers[i] == uglyNumbers[m5]* 5)  m5++;
        }
        return uglyNumbers[index - 1];
        
    }
	
	public static int min(int a,int b,int c) {
		int min = a > b ? b : a;
		return min > c ? c : min;
	}
}
