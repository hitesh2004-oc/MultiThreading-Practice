package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
// Callable Method //
class Demo implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println("Call Method Executed.....");
	      Thread.sleep(3000);
		return "Success";
	     }
	}
	
public class P10 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo d = new Demo();
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i =1 ;i<=15;i++) {
			Future submit = es.submit(d);
			System.out.println(submit.get().toString());
			
		}
		es.shutdown();
	}
}
