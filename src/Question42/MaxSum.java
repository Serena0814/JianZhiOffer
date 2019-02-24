package Question42;
/*
 * ���������������
 * �����ֽⷨ����Ϊ�ⷨһ����ⷨ
 * ע�⣺
 * ���ڿ����鷵��0������Ҳ���ܷ���0��Ϊ����������������ɲ���ȫ�ֱ�������ʽ�����������֣������������֣�
 * 
 * �ⷨ��Ϊ��̬�滮����̬�滮��ⷨһ����һ�£�����ͬ��
 * ע�⣺
 * ��̬�滮˼�����������ʽ��ͨ��Ϊ�ݹ����ʽ��ߣ����ʱ������ѭ���ķ�ʽ
 */
public class MaxSum {
	public static void main(String[] args) {   //���Գ���
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	
	public static int FindGreatestSumOfSubArray(int[] array) {
		//ά������������max��curMax
		if(array == null) {
			return 0;
		}
        int length = array.length;
        if(length == 1) {
        	return array[0];
        }
        int max = array[0];    //maxΪ�ѱ������������е�����
        int curMax = max;  //curMaxΪ��������ǰԪ��ʱ����ǰԪ�����ڵ������������Ԫ�غ�
        
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
