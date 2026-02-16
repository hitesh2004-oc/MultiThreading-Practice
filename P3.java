package MultiThreading;
class Demo1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Child Thread Executiong...");
		System.out.println(Thread.currentThread().getState());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Some Problem");
		}
		System.out.println("Child Thread Task Completed");
	}

}
public class P3 {
	public static void main(String[] args) {
	     System.out.println("Main Thread Started....");
         Demo1 d1 = new Demo1();
         Thread t1 = new Thread(d1);
         
         t1.start();
         t1.setName("My Thread 01");
       //  t1.setPriority(Thread.MIN_PRIORITY);
       //  t1.setPriority(Thread.MAX_PRIORITY);
       //  t1.setPriority(Thread.NORM_PRIORITY);
       //  t1.setDaemon(true);
         
	}

}
