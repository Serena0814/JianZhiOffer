package Question65;
/*
 * ���üӼ��˳����ӷ���
 * λ����:�ظ������������������(Ҫ��λ)��ֱ����������=0�����޽�λ��
 */
public class Add {
	public static void main(String args[]) {
		System.out.println(add(11,2));
	}
	public static int add(int num1,int num2) {
		if(num2 == 0 ) {
			return num1;
		}else if(num1 == 0) {
			return num2;
		}
		
        while(num2 != 0) {
        	int yihuo = num1 ^ num2;
        	int yu = (num1 & num2)<<1;
        	num1 = yihuo;
        	num2 = yu;
        }
        return num1;
    }
}
