package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumTask implements Callable<Integer>{

	public Integer call() throws Exception {
		  int sum = 0;
		  for(int i = 1;i<=10;i++) {
			  sum = sum + i;
		  }
		  return sum;
	}
	
}
public class P11 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
	// Create Executor Service
	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	// SumTask Object
	SumTask st = new SumTask();
	
	Future<Integer> result = executor.submit(st);
	
	Integer sum = result.get();
	
	System.out.println("Sum is : "+sum);
	executor.shutdown();
	}
}
