package Question43;
/*
 * ��1-n�������г���1�Ĵ���
 * �ⷨһ��
 * ����ÿ������ͳ��ÿ�����ֳ���1�Ĵ������Ӷ�ͳ���ܴ���
 */
public class HowManyTimes {
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(1000));
	}
	
	public static int NumberOf1Between1AndN_Solution(int n) {
	    if(n < 1) {
	    	return 0;
	    }
	    int num = 0; //�ܴ���
	    for (int i = 1; i <= n; i++) {
	    	int count = 0; //ÿ�����ֳ���1�Ĵ���
	    	int j = i;
	    	while( j != 0 ) {
	    		if(j % 10 == 1) {
	    			count++;
	    		}
	    		j = j / 10;
	    	}
	    	num += count;
	    }
	    return num;
    }
}
