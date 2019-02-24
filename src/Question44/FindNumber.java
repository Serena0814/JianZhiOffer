package Question44;
/*
 * ����������ĳһλ�����֣������ֽⷨ
 * ��һö�ٷ���һ��ö��һ�߼�����λ��
 * �����ҳ���ѧ��ϵ
 * �ȸ�����һ
 */
public class FindNumber {
	public static void main (String[] args) {
		System.out.println(findNumber(1000));
	}
	
	public static int findNumber(int n) {
		if( n < 10) {
			return n;
		}
		int sum = 9;
		int i = 9;
		while (sum < n) {
			i++;
			sum += numberCount(i);
		}
		int fromRightToLeft = sum - n + 1; //�ұߵ�nλ
		return compute(i,fromRightToLeft);
	}
	
	public static int numberCount(int i) {
		int count = 0;
		while(i != 0) {
			count ++;
			i /= 10;
		}
		return count;
	}
	
	public static int compute(int num, int fromRightToLeft) {
		for(int i = 1; i < fromRightToLeft; i ++) {
			num /= 10;
		}
		return num % 10;
	}
}
