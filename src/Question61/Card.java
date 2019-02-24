package Question61;
/*
 * �˿����е�˳��
 * ���裺
 * 1.������
 * 2.ͳ��0�ĸ��������������ڵ������ж��ٸ���ȱ
 * 3.����ж�0�ĸ����ܷ��ֲ��Ͽ�ȱ
 * 4.���з�����������̷���boolean
 */
public class Card {
	public static void main(String args[]) {
		int[] numbers = {1,3,2,5,4};
		sort(numbers);
		System.out.println(numbers[0]+" "+numbers[1]+" "+numbers[2]+" "+numbers[3]+" "+numbers[4]+" ");
	}
	public static boolean isContinuous(int [] numbers) {
		if(numbers.length != 5) {
			return false;
		}
		
		sort(numbers);
		
		int count0 = 0;
		while(numbers[count0] == 0) {
			count0 ++;
		}
		
		int sum = 0;
		for(int i = count0 ; i < 4;i++) {
			int t =numbers[i + 1] - numbers[i];
			if(t == 0) {
				return false;
			}
			sum += t-1;
		}
		if(sum <= count0) {
			return true;
		}
		return false;
    }
	
	public static void sort(int[] numbers) {
		for(int i = 0; i < 5 ;i++) {
			int minIndex = i;
			for(int j = i+1 ; j < 5; j++) {
				if(numbers[minIndex] > numbers [j] ) {
					minIndex = j;
				}
			}
			int t = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = t;
		}
	}
}
