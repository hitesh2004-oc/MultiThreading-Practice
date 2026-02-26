package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Free implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" Call Method Executing....");
		Thread.sleep(3000);	
		return "Success..";	
	}
}
public class P12 {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		Free f = new Free();
		
		// We can not pass callable Direct to the Thread Object
		//** Thread t = new Thread(f);  [Not Possible] **//
		
		//so We use ExecutorService to Create ThreadPool to Manage Thread
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i = 1;i<=15;i++) {
			Future a = es.submit(f);
			System.out.println(a.get().toString());
		}
		es.shutdown();
	}
}
