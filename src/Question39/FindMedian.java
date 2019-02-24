package Question39;
/*
 * �����г��ִ�������һ������֣�����һ��ȱ�����޸������飩
 * ע�⣺
 * 1.��������Ѱ����λ��
 * 2.Ѱ����λ���ķ����õ����ŵ�һ������
 * 3.������֮��Ҫ��һ�����
 */
public class FindMedian {
	public static void main(String args[]) {
		int[] number = {2,2,2,2,2,1,3,4,5};
		System.out.println(findMedian(number));
	}
	
	public static int findMedian(int[] number) {  //�ҵ���λ����ѭ�����ǵݹ�
		if(number == null) {
			return 0;
		}
		if(number.length == 1) {
			return number[0];
		}
		int length = number.length;
		int start = 0;
		int end = length-1;
		int index =  partition(number,0,end);
		while(index != length/2) {
			if(index > length/2) {
				end = index - 1;
				index = partition(number,start,end);
			}
			else {
				start = index + 1;
				index = partition(number,start,end);
			}
		}
		int num = number[index];
		if(!check(number,num)) {
			return 0;
		}
		return num;
	}
	
	public static int partition(int[] number,int start,int end) {    //����
		int index = start - 1;
		int temp = 0;
		for(int i = start;i < end;i++) {
			if(number[i] < number[end]){
				index++;
				if(i != index) {
					temp = number[i];
					number[i] = number[index];
					number[index] = temp;
				}
			}
		}
		index++;
		temp = number[index];
		number[index] = number[end];
		number[end] = temp;
		return index;
	}
	
	public static boolean check(int[] number,int num) {    //�ж��Ƿ�Ϊ��Ч����
		int length = number.length;
		int count = 0;
		for(int i = 0;i < length;i++) {
			if(number[i] == num) {
				count ++;
			}
		}
		if(count > length/2) {
			return true;
		}
		return false;
	}
}
