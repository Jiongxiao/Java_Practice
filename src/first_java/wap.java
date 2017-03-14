package first_java;



import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class wap {

	static class T {
		public int t1;
		public int t2;

		public T() {
			this.t1 = 0;
			this.t2 = 0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		T[] a = new T[n];

		for (int i = 0; i < n; i++) {
			T t = new T();
			a[i] = t;
			t.t1 = in.nextInt();
			t.t2 = in.nextInt();

		}
		sortArray(a, n);
		for (int i=0; i<n; i++ ){
			System.out.println(a[i].t1+","+a[i].t2);
		}
		System.out.println(solve(a, n));
	}

	public static int solve(T[] a, int n) {
		int maxSize = 150050;
		int sum = 0;
		Queue<Integer> queue = new PriorityQueue<>(maxSize, new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e2 - e1;
			}
		});
		
		for (int i = 0; i <n; i++) {
			T t = a[i];
			if (sum + t.t1 <= t.t2) {
				queue.add(t.t1);
				sum += t.t1;
			} else {
				int max = queue.poll();
				int newOne = Math.min(max, t.t1);
				queue.add(newOne);
				sum = sum - max + newOne;
			}
		}

		return queue.size();

	}
	
	public static void sortArray(T[] a, int n){
		Arrays.sort(a,new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
//				if 
				return o1.t2-o2.t2;
			}
		});
	}
}