package Question59;

import java.util.ArrayList;

/*
 * ���е����ֵ
 * ����1:�������ڵ����ֵ
 * ����һ:�����ƽ�
 * ���������ɽ�
 * ά��һ��������У���������ģ��ݼ����У�
 */
public class MaxValue {
	public static void main(String args[]) {
		int[] num = {2,3,4,2,6,2,5,1};
		maxInWindows(num,3);
	}
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();  //�����ֵ
        if(num == null || size <= 0) {
        	return list;
        }
        
        ArrayList<Integer> help = new ArrayList<Integer>();  //�����б�������±�

        int count = 0;
        int length = num.length;
        for(int i = 0; i < length;i++) {
        	if(count>= 1 && i - help.get(0) >= size ) {  //�����һ�������±��ѳ������������Ƴ�
        		help.remove(0);   		
        		count -- ;
        	}
        	
        	if(count == 0) {    //������û����ʱ��ֱ�ӷ���
        		help.add(i);
        		count ++;
        	}else if(num[help.get(count - 1)] > num[i]) {  //�����Сֵ ����ֵ���󣬶�βֱ�Ӽ�����ֵ
        		help.add(i);
        		count ++;
        	}else {                                   //�����Сֵ����ֵС�����ų���Сֵ����������ֵ
        		while(count > 0 && num[help.get(count - 1)] <= num[i]) {
        			help.remove(count - 1);
        			count --;
        		}
        		help.add(i);
        		count ++;
        	}
        	
        	if( i >= size - 1) {
        		list.add(num[help.get(0)]);
        	}
        }
        return list;
    }
}
