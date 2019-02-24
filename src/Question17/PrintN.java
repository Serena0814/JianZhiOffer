package Question17;
/*
 * ��ӡ��1������nλ��
 * ע�⣺
 * 1.���������⣬���ַ����������ʾ��
 * 2.��ӡʱҪ���Ը�λ��0��
 */
public class PrintN {
	public static void main(String args[]) {
		printN(2);
	}
	
	public static void printN (int n) {
		if (n <= 0) {
			System.out.println("����λ������");
			return ;
		}
		int[] number = new int[n];
		printDigui(number,n,0);
	}
	
	public static void printDigui(int[] number,int length,int index) {
		if (index == length) {
			printNumber(number,length);
			return ;
		}
		for (int i = 0;i<10;i++) {
			number[index] = i;
			printDigui(number,length,index+1);
		}
	}
	
	public static void printNumber (int[] number,int n) {
		int i = 0;
		for(;i < n;i++) {
			if(number[i]!=0) {
				break;
			}
		}
		if(i == n) {
			return ;
		}
		while(i < n) {
			System.out.print(number[i]);
			i++;
		}
		System.out.print(" ");
		return ;
	}
}
