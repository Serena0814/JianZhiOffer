package Question57;

import java.util.ArrayList;

/*
 * ��Ϊs������
 * ��Ŀһ:��Ϊ����s����������
 * ע��˫ָ������
 */
public class SumS {
	public static void main(String args[]) {
		
	}
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int length = array.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(length < 2) {
        	return list;
        }
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = length -1;
        while(start < end) {
        	if(array[start] + array[end] > sum) {
        		end --;
        	}else if(array[start] + array[end] < sum) {
        		start ++;
        	}else if(array[start] * array[end] <= min) {
        			list.add(0,array[start]);
            		list.add(1,array[end]);
            		min = array[start] * array[end];  
            		end --;
            		start ++;
        	}else {
        		end --;
        		start ++;
        	}
        }
        return list;
    }
}
