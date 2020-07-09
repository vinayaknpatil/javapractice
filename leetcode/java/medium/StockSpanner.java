/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days 
(starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], 
then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

 

Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation: 
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.

Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.
 */
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