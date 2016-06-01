package first_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStackandQueue {
	static String[] months={ 
			"January", "February", "March", "April",
			"May", "June", "July", "August", "September",
			"October", "November", "December" };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stk=new Stack<>();
		for (int i = 0; i < months.length; i++) {
			stk.push(months[i]+" ");}
		System.out.println("stk = "+ stk);
		System.out.println("######popping elements#########");
		while(!stk.empty())
			System.out.println(stk.pop());         //Last In Frist Out
		
		System.out.println("########test Queue######");
		Queue<Integer> queue=new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty())
			System.out.println(queue.poll());   //First In First Out
	}

}
