package Question39;
/*�ⷨ����
 * 1.ͨ��������������Ҵ���
 * 2.�ҵ���ҲҪ����
 */
public class FindByArray {
	public static void main(String args[]) {
		int[] number = {2,2,2,2,2,1,3,4,5};
		System.out.println(findByArray(number));
	}
	
	public static int findByArray(int[] arr) {
		if(arr == null) {
			return 0;
		}
		int length = arr.length;
		if(length == 1) {
			return arr[0];
		}
		int number = arr[0];
		int count = 1;
		for(int i = 1;i < length;i++) {
			if(count == 0 ) {
				number = arr[i];
				count ++;
			}
			else if(number == arr[i]){
				count ++;
			}
			else {
				count --;
			}
		}
		if(!check(arr,number)) {
			return 0;
		}
		return number;
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
