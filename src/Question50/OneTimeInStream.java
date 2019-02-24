package Question50;
/*
 * 字符流中第一个只出现一次的字符
 * 注意：
 * 使用一个辅助数组，若未出现过指定字母，为-1；出现过一次，为上次出现的位置；出现过两次为-2。
 */
public class OneTimeInStream {
	public static void main(String args[]) {
		System.out.println();
	}
	
	int index;  //记录流中第几个字符
	int[] count = new int[256];
	public OneTimeInStream() {
		 //字符流中还没出现过时初始化为-1
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
