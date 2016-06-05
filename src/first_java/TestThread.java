package first_java;


public class TestThread {

	public static void main(String[] args) {
		//  Auto-generated method stub
		//	Thread t = new MyThread(20);
		//	t.start();
		
		MyTask myTask = new MyTask(20); //添加了一个线程
		Thread t2= new Thread(myTask);
		t2.start();
		
		for (int i = 0; i < 6; i++) {
			System.out.println("Main--"+i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
		
	}

}

class MyThread extends Thread{
	private int n;
	public MyThread	(int n) {
		super();
		this.n=n;
	}
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}


class MyTask implements Runnable {
	private int n;
	public MyTask(int n) {
		this.n=n;
	}
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.print(" "+i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
	}
}