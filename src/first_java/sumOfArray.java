package first_java;

public class sumOfArray {
	static int []b={-1,-2,-3,-4};
	public static void main(String[] args) {
		int[] ary={1,2,3,4};
		int total=sum(ary);
		System.out.println(total);
	}
	public static int sum( int [] a) {
		int s=0;
		for (int i = 0; i <= a.length; i++) {
			s+=i;
		}
		return s;
	}

}
