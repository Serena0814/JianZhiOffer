package Question49;
/*
 * 丑数
 * 解法一：对每个数字进行判别是否为丑数
 * 解法二:创建数组保存已知丑数(使用牛客网上的答案)
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
