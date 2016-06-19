package first_java;

public class TestSyn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Num num=new Num();
		Thread counter1= new Counter(num);
		Thread counter2= new Counter(num);
		for (int i = 0; i < 10; i++) {
			num.testEquals();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
		}
	}

}}


class Num{
	private int x=0;
	private int y=0;
	synchronized void increase(){
		x++;
		y++;
	}
	synchronized boolean testEquals(){
		boolean ok=(x==y);
		System.out.println(x+","+y+" "+ ok);
		return ok;
	}
}

class Counter extends Thread{
	private Num num;
	public Counter(Num num) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.start();
	}
	public void run() {
		while(true){
			this.num.increase();
		}
		
	}
}