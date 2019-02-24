package Question41;
/*
 * 数据流中的中位数(也可以用PriorityQueue,是实现好的api)
 * 注意：
 * 1.分为最大堆和最小堆
 * 2.新增的一个数，若当前长度为偶数新增数进入最小堆，若当前长度为奇数新增数进入最大堆
 * 3.若最大堆的根节点大于最小堆的根节点，需要交换并进行调整
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
    void Insert(Integer num) {   // 插入数据
    	if(length == 0) {
    		insertMin(num);
    	}
    	else if(length % 2 == 0) {
        	if(num < max.get(0)) {    //数据比最大堆中最大的要小，则它应该归入最大堆
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
        		insertMax(min.remove(0)); //数据比最小堆中最大的要大，则它应该归入最小堆
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
    
    void heapifyMax(ArrayList<Integer> heap,int i,int length) {   //最大堆的向下调整
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
    void heapifyMin(ArrayList<Integer> heap,int i,int length) {   //最小堆的向下调整
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