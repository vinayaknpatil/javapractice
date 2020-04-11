import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues1 {

	public static void main(String [] args)
	{
		
		Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);
		
		// Throws No Such Element exception
		//System.out.println("Head of queue "+q1.element());
		
		q1.add(10);
		q1.add(11);
		q1.add(12);
		try
		{
			q1.add(20);
		}
		catch(IllegalStateException ex)
		{
			System.out.println("Queue is full");
		}
		
		System.out.println("Head of queue "+q1.element());
		
		
		
		for(Integer val: q1)
		{
			System.out.println(val);
		}
		
		int x = q1.remove();
		System.out.println(x);
		x = q1.remove();
		System.out.println(x);
		x = q1.remove();
		System.out.println(x);
		try
		{
			x = q1.remove();
		}
		catch(NoSuchElementException nex)
		{
			System.out.println("Queue is empty");
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);
		
		System.out.println("Peek "+q2.peek());
		
		q2.offer(10);
		q2.offer(11);
		if( !q2.offer(12))
		{
			System.out.println("Failed to add item");
		}
				
		System.out.println("Peek "+q2.peek());
		for(Integer val: q2)
		{
			System.out.println(val);
		}
		
		System.out.println("Q2 poll "+q2.poll());
		System.out.println("Q2 poll "+q2.poll());
		System.out.println("Q2 poll "+q2.poll());
		
	
		
	}
}
