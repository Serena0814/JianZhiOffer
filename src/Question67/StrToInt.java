package Question67;
/*
 * ���ַ���ת��Ϊ����
 */
public class StrToInt {
	public int strToInt(String str) {
        int length = str.length();
        if(length == 0) {
        	return 0;
        }
        boolean simble = true;   //��ͷ��û�з���
        boolean flag = true;     //����Ϊ�������Ǹ���
        int num = 0;
        
        //���жϵ�һ������
        if(str.charAt(0) == '-') {   //�з��Ÿ���
        	flag = false;
        }else if (str.charAt(0) == '+') {      //�з�������   	
        }else if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {  //�޷�������
        	simble = false;
        	num = str.charAt(0) - '0';
        } else {
        	return 0;
        }
        
       //ֻ��һ����ĸ�����
        if(length == 1) {    
        	if(simble) return 0;
        	else return num;
        }
        
        //����������ĸ�����
        for(int i = 1;i < length;i++) {
        	if(str.charAt(i) < '0' || str.charAt(i) > '9') {
        		return 0;
        	}
        	num = num * 10 + (str.charAt(i) - '0');
        }
        
        if(!flag) num *= (-1);  //���������
        
        return num;
    }
}
