package Question42;
/*
 * 连续子数组的最大和
 * 有两种解法，此为解法一常规解法
 * 注意：
 * 由于空数组返回0，最大和也可能返回0，为了区别这两种情况可采用全局变量的形式（在书中体现，代码中无体现）
 * 
 * 解法二为动态规划，动态规划与解法一代码一致，异曲同工
 * 注意：
 * 动态规划思想有其基本公式，通常为递归的形式，撸代码时常采用循环的方式
 */
public class MaxSum {
	public static void main(String[] args) {   //测试程序
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	
	public static int FindGreatestSumOfSubArray(int[] array) {
		//维护两个变量：max和curMax
		if(array == null) {
			return 0;
		}
        int length = array.length;
        if(length == 1) {
        	return array[0];
        }
        int max = array[0];    //max为已便利的子数组中的最大和
        int curMax = max;  //curMax为遍历到当前元素时，当前元素所在的子数组中最大元素和
        
        for(int i = 1;i < length;i++) {
        	if(curMax < 0) {
        		curMax = array[i];
        	}
        	else {
        		curMax += array[i];
        	}
        	if(curMax > max) {
        		max = curMax;
        	}
        }
        return max;
    }
}
