package Question60;
/*
 * �ⷨ������ѭ���ķ�ʽ
 * ���������飨���Ƕ�ά���飩
 * falg == 0ʱΪһ�����飬falg == 1ʱΪ��һ������
 */
public class Probability2 {
	public static void main (String args[]) {
		probability(3);
	}
	
	public static void probability(int num) {
		if(num < 1) {
			System.out.println("��");
			return;
		}
		int[][] temp = new int[2][num * 6 + 1];
		int falg = 0;
		for(int i = 1;i <= 6;i++) {    //��ʼ������
			temp[falg][i] = 1;
		}
		
		for(int i = 2;i <= num;i++) {
			for(int j = i; j <= 6*i;j++ ) {
				int t = 0;
				for(int m = 1; m <= 6;m++) {
					if(j-m > 0) {
						t += temp[falg][j-m];
					}
				}
				temp[1-falg][j] = t;
			}
			falg = 1 - falg;
		}
		
		int tatal = 0;
		for(int i = num; i <= num*6;i++) {
			tatal += temp[falg][i];
		}
		for(int i = num;i <= num *6;i++) {
			System.out.println(((double)temp[falg][i] / tatal));
		}
	}
}
