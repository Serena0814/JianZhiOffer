package Question66;
/*
 * 构建乘积数组
 * 1.分解成子问题
 * 2.再求子问题的子问题
 */
public class MultiplyArray {
	public int[] multiply(int[] A) {
		int length = A.length;		
        int[] B = new int[length];

        if(length < 2) {
			return B;
		}
        B[0] = 1;
        for(int i = 1 ; i < length;i++  ) {
        	B[i] = B[i - 1] *A[i - 1];
        }
        int temp = 1;
        for(int i = length - 2;i>=0 ;i--) {
        	temp *= A[i + 1];
        	B[i] *= temp;
        }
        return B;
    }
}
