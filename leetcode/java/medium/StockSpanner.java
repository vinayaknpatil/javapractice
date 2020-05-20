import java.util.Stack;

public class StockSpanner {

	public static void main(String[] args) {
		StockSpanner2 spanner = new StockSpanner2();
		
		System.out.println(spanner.next(100));
		System.out.println(spanner.next(80));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(70));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(75));
		System.out.println(spanner.next(85));
		System.out.println(spanner.next(101));


	}
	
	Stack<Integer> valueStack;
	Stack<Integer> spanDataStack;
	
	public StockSpanner()
	{
		valueStack = new Stack<>();
		spanDataStack = new Stack<>();
			
	}
	
	 public int next(int price) {
		 
		 int span = 1;
		 
		 while(!valueStack.isEmpty() && valueStack.peek() <= price)
		 {
			 valueStack.pop();
			 span += spanDataStack.pop();
		 }
		 
		 valueStack.push(price);
		 spanDataStack.push(span);
		 
		 return span;
		 
	 }

}

class StockSpanner2
{
	Stack<SpanData> spanStack;
	
	public StockSpanner2()
	{
		spanStack = new Stack<>();
	}
	
	public int next(int price) {
		int span = 1;
		
		while(!spanStack.isEmpty() && spanStack.peek().value <= price)
		{
			span += spanStack.pop().span;
		}
	
		
		SpanData data = new SpanData();
		data.span = span;
		data.value = price;
		
		spanStack.push(data);
		
		return span;
		
	}
	
	
}

class SpanData
{
	int span;
	int value;
}