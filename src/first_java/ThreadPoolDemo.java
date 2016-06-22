package first_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool= Executors.newCachedThreadPool();
		MyTask2 t1=new MyTask2(5);
		MyTask2 t2=new MyTask2(700);
		MyTask2 t3=new MyTask2(19);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.shutdown();
	}

}

class MyTask2 implements Runnable {
	int n=10;
	public MyTask2(int n) {
		this.n=n;
	}
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}
}