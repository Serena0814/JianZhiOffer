package Question44;
/*
 * ������������ĳ�ֹ��ɴ�����ʱ�䣬����������ѧ����
 */
public class FindNumber2 {
	public static void main (String[] args) {
		System.out.println(findNumber(11));
	}
	
	public static int findNumber(int n) {
		if( n < 10) {
			return n;
		}
		int base = 90;
		int count = 2; //����2λ��
		int sum = 9 + base * count;
		while(sum < n) {
			base *= 10;
			count ++;
			sum += base * count;
		}
		sum -= base * count;
		int number = base10(count) + (n - sum) / count; //��Ϊ�ҳ�������
		int fromRightToLeft = count - (n - sum) % count; //��������ĵ�nλ
		for(int i = 1; i < fromRightToLeft; i++) {
			number /= 10;
		}
		return number % 10;
	}
	
	public static int base10 (int n) {
		int sum = 1;
		for(int i = 1; i < n; i ++) {
			sum *= 10;
		}
		return sum;
	}
}
