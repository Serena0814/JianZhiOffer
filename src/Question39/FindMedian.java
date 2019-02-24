package Question39;
/*
 * 数组中出现次数超过一半的数字（方法一，缺点是修改了数组）
 * 注意：
 * 1.本质上是寻找中位数
 * 2.寻找中位数的方法用到快排的一个函数
 * 3.找完数之后要做一个检测
 */
public class FindMedian {
	public static void main(String args[]) {
		int[] number = {2,2,2,2,2,1,3,4,5};
		System.out.println(findMedian(number));
	}
	
	public static int findMedian(int[] number) {  //找到中位数，循环，非递归
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
	
	public static int partition(int[] number,int start,int end) {    //划分
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
	
	public static boolean check(int[] number,int num) {    //判断是否为有效数组
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
