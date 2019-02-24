package Question41;
/*
 * �������е���λ��(Ҳ������PriorityQueue,��ʵ�ֺõ�api)
 * ע�⣺
 * 1.��Ϊ���Ѻ���С��
 * 2.������һ����������ǰ����Ϊż��������������С�ѣ�����ǰ����Ϊ������������������
 * 3.�����ѵĸ��ڵ������С�ѵĸ��ڵ㣬��Ҫ���������е���
 */
import java.util.ArrayList;

public class FindStreamMedian {
	public static void main(String args[]) {
		Solution solution = new Solution();
		solution.Insert(1);
		solution.Insert(2);
		solution.Insert(4);
		solution.Insert(8);
		System.out.println(solution.GetMedian());
	}
}

class Solution {
	ArrayList<Integer> min = new ArrayList<Integer>();
	ArrayList<Integer> max = new ArrayList<Integer>();
	int minLength = 0;
	int maxLength = 0;
	int length = 0;
    void Insert(Integer num) {   // ��������
    	if(length == 0) {
    		insertMin(num);
    	}
    	else if(length % 2 == 0) {
        	if(num < max.get(0)) {    //���ݱ�����������ҪС������Ӧ�ù�������
        		insertMin(max.remove(0));
        		maxLength--;
        		insertMax(num);
        	}
        	else {
        		insertMin(num);
        	}  	
        }
        else {
        	if(num > min.get(0)) {
        		insertMax(min.remove(0)); //���ݱ���С��������Ҫ������Ӧ�ù�����С��
        		minLength--;
        		insertMin(num);
        	}
        	else {
        		insertMax(num);
        	}
        }
        length ++;
    }
    void insertMax(int num) { 
    	max.add(num);
    	maxLength++;
    	for(int i = maxLength / 2 - 1; i >= 0; i --) {
    		heapifyMax(max,i,maxLength);
    	}
    }
    void insertMin(int num) { 
    	min.add(num);
    	minLength++;
    	for(int i = minLength / 2 - 1; i >= 0; i --) {
    		heapifyMin(min,i,minLength);
    	}
    }
    
    void heapifyMax(ArrayList<Integer> heap,int i,int length) {   //���ѵ����µ���
    	int left = i * 2 + 1;
    	int right = i* 2 + 2;
    	int max = i;
    	if(left < length && heap.get(max) < heap.get(left)) {
    		max = left;
    	}
    	if(right < length && heap.get(max) < heap.get(right)) {
    		max = right;
    	}
    	if(i != max) {
    		swap(heap,i,heap,max);
    		heapifyMax(heap,max,length);
    	}
    }
    void heapifyMin(ArrayList<Integer> heap,int i,int length) {   //��С�ѵ����µ���
    	int left = i * 2 + 1;
    	int right = i* 2 + 2;
    	int min = i;
    	if(left < length && heap.get(min) > heap.get(left)) {
    		min = left;
    	}
    	if(right < length && heap.get(min) > heap.get(right)) {
    		min = right;
    	}
    	if(i != min) {
    		swap(heap,i,heap,min);
    		heapifyMin(heap,min,length);
    	}
    }
    
    
    void swap(ArrayList<Integer> heap1,int i,ArrayList<Integer> heap2,int j) {
    	int temp = heap1.get(i);
    	heap1.set(i, heap2.get(j));
    	heap2.set(j, temp);
    }

    Double GetMedian() {
    	if(length == 0) {
    		return 0.0;
    	}
        if(length % 2 == 1) {
        	return (double)min.get(0);
        }
        return (min.get(0) + max.get(0)) / 2.0;
    }
	
}