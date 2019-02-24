package Question05;

public class NewString {
	public static void main(String args[]) {
		StringBuffer s = new StringBuffer("We are happy.");
		newString(s);
		System.out.println(s);
	}
	
	public static void newString(StringBuffer s) {
		int length = s.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == ' ') {
				count ++;
			}
		}
		if (length <= 0 || count == 0) {
			return;
		}
		int newlength = length + count*2;
		s.setLength(newlength);
		int j = newlength - 1;
		for(int i = length - 1; i >= 0; i--) {
			if( s.charAt(i) == ' ') {
				s.setCharAt(j--, '0');
				s.setCharAt(j--, '2');
				s.setCharAt(j--, '%');
			}
			else {
				s.setCharAt(j--, s.charAt(i));
			}
		}
	}
}
