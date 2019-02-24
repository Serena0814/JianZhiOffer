package Question10;

public class Frog {
	public static void main(String args[]) {
		System.out.println(digui(15));
		System.out.println(xunhuan(15));
	}
	
	public static int digui(int n) {//递归方式
		if(n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		return digui(n-1)+digui(n-2);
	}
	
	public static int xunhuan(int n) {//循环方式
		if(n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		int f1 = 1;
		int f2 = 2;
		int f = 0;
		for (int i = 3;i <= n; i ++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}
}

