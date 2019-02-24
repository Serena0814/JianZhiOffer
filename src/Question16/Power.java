package Question16;
/*
 * 求数的乘方
 */
public class Power {
	public static void main(String args[]) {
		System.out.println(power(0,0));
		System.out.println(power(0,1));
		System.out.println(power(1,0));
		System.out.println(power(-2,3));
		System.out.println(power(2,-3));
		System.out.println(power(2,3));
	}
	public static double power(double base,int exp) {
		if (base == 0) {
			return 0;
		}
		if(exp > 0) {
			return powerAbs(base,exp);
		}
		int expabs = (-1) * exp;
		double result = powerAbs(base,expabs);
		return 1.0/result;    //注意double型变量，要写成1.0
	}
	public static double powerAbs(double base,int exp) { //计算指数为正时的乘方,用递归效率高
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		double result = powerAbs(base,exp>>1);
		result *= result;
		if((exp & 1) == 1) {
			result *= base;
		}
		return result;
	}
}
