package Question50;
/*
 * �ַ����е�һ��ֻ����һ�ε��ַ�
 * ע�⣺
 * ʹ��һ���������飬��δ���ֹ�ָ����ĸ��Ϊ-1�����ֹ�һ�Σ�Ϊ�ϴγ��ֵ�λ�ã����ֹ�����Ϊ-2��
 */
public class OneTimeInStream {
	public static void main(String args[]) {
		System.out.println();
	}
	
	int index;  //��¼���еڼ����ַ�
	int[] count = new int[256];
	public OneTimeInStream() {
		 //�ַ����л�û���ֹ�ʱ��ʼ��Ϊ-1
		for(int i = 0 ;i < 256;i++) {
			count[i] = -1;
		}
		index = 0;
	}
	
	public void Insert(char ch)
    {
        if(count[ch] == -1) {
        	count[ch] = index;
        }else if (count[ch] >= 0) {
        	count[ch] = -2;
        }
        index ++;
    }
	
	public char FirstAppearingOnce()
    {
		char ch = '\0';
		int min = Integer.MAX_VALUE;
		for(int i = 0 ;i < 256; i ++){
			if(count[i] >= 0 && count[i] < min) {
				ch = (char) i;
				min = count[i];
			}
		}
		if(ch == '\0') return '#';
		return ch;
    }
}
