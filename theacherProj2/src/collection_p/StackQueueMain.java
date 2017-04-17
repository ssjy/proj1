package collection_p;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		Queue qq = new LinkedList();
		
		//add와 push 같음
		//st.push(1);	
		//st.push(2);
		//st.push(3);
		
		st.add(1);	
		st.add(2);
		st.add(3);
		
		System.out.println(st);
		
		System.out.println("Stack for 출력 FIFO---------------");
		for (int i = 0; i < st.size(); i++) {
			System.out.println(st.get(i));
		}
		System.out.println("Stack pop 출력 LIFO------------");
		
		while(!st.empty())
		{
			System.out.println(st.pop());
		}
		
		//add와 offer 같음
		//qq.add(1);
		//qq.add(2);
		//qq.add(3);
		
		qq.offer(1);
		qq.offer(2);
		qq.offer(3);
		
		System.out.println(qq);
		
		System.out.println("Queue 출력 FIFO---------------");
		
		while(!qq.isEmpty())
		{
			System.out.println(qq.poll());
		}
	}

}
