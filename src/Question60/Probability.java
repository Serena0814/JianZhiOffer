package Question60;
/*
 * n�����ӵĵ�����
 * �ⷨһ���ݹ� ���Զ����£� ���Ӷȹ��ߣ��ظ������
 * �ⷨ����ѭ�����Ե����ϣ�
 * ������ýⷨһ �����������ϵĸ�ʽ��
 */
public class Probability {
	public static void main(String args[]) {
		solution(3);
	}
	
	public static void solution(int num) {
		if(num == 0) {
			System.out.println(0);
			return;
		}
		double [] counts = new double[5*num + 1];
		double total = 0;
		for(int i = num;i <= 6*num;i++) {
			counts[i - num] = (double)count(num,i);
			total += counts[i - num];
		}
		for(int i = num;i <= 6*num;i++) {
			counts[i - num] /= total;
			System.out.println(counts[i - num]);
		}	
	}
	
	public static int count(int num,int sum) {
		if(num <= 0 || sum <= 0 || sum > num*6) {
			return 0;
		}
		if(num == 1) {
			return 1;   //�߽�ֵ
		}
		return count(num - 1, sum -1) + count(num - 1, sum -2)+
					count(num - 1, sum -3)+count(num - 1, sum -4)+count(num - 1, sum -5) 
					+count(num - 1, sum -6);
	}
}

