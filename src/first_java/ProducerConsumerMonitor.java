package first_java;

public class ProducerConsumerMonitor {

	static final int N =10;


	class myMonitor {
		private char buffer[] = new char[N];
		private int count = 0;

		public synchronized char pop() {
			while (count <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			count--;
			char value = buffer[count];
			System.out.println("Consumer" + "Pop:" + value);
			notify();
			return value;
		}

		public synchronized void push(char value) {
			while (count >= N) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("Producer put:" + value);
			buffer[count] = value;
			count++;
			notify();
		}

	}
	
	class Producer extends Thread{
		private myMonitor monitor;
		
		public Producer(myMonitor m) {
			this.monitor=m;
		}
		public void run() {
			char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M'
					,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			for(char ch : alphabet){
				monitor.push(ch);
			}
		}
	}
	
	class Consumer extends Thread{
		private myMonitor monitor;
		
		public Consumer(myMonitor m){
			this.monitor=m;
		}
		public void run(){
			int value=0;
			for(int i=0; i<26; i++){
				value=monitor.pop();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumerMonitor p=new ProducerConsumerMonitor();// main函数不能直接调用内部类！！！
		myMonitor monitor=p.new myMonitor();
		Producer p1=p.new Producer(monitor);
		Consumer c1=p.new Consumer(monitor);
		c1.start();
		p1.start();
	}
}
