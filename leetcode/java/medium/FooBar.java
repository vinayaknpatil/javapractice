/**
 * Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * @author vpatil
 *
 */
class FooBar {
    private int n;
    private int count = 0;
    
    

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this)
            {
                try
                {
                    while(count % 2 ==1)
                    {
                        wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    
                    count++;
                }
                finally
                {
                    notify();
                }
            }
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
           synchronized(this)
            {
                try
                {
                    while(count % 2 == 0)
                    {
                        wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    
                    count++;
                }
                finally
                {
                    notify();
                }
            }
        }
    }
}
