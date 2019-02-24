package Question10;
//2µÄn´Î·½¼õ1
public class KuoZhan {
	public static void main(String args[]) {
		System.out.println(frog(5));
	}
	
	public static int frog (int n) {
		int[] arr = new int[n+1];
		arr[0] = 0;
		for(int j = 1; j <=n;j++) {
			int sum = 0;
			for(int i = 0;i < j;i++) {
				sum += arr[i];
			}
			arr[j] = sum+1;
		}
		return arr[n];
	}
}
