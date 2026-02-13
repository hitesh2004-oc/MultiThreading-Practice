package Day29;
//-------MultiThreading---------//
// There are Two Way Create MultiThreading
// (1) Thread Class
// (2) Runable Interface [ Functional Interface] [Imp]


//----Thread Class-----//
class MyThread1 extends Thread{
	public void run() {
		for(int i = 1; i<= 10;i++) {
			System.out.println(i);
		}
	}
}

//------Runable Interface------//
class MyThread2 implements Runnable{
	public void run() {
		for(int i = 1; i<= 10;i++) {
			System.out.println(i);
			
			// It is Basically show The Current Thread Name
			System.out.println(Thread.currentThread());
			
			try {
				//it is Set Time duration between Threads
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class P1 {
	public static void main(String[] args) {
		// Create Object of Thread Class
		MyThread1 mt1 = new MyThread1();
		// Internally Start method Call Run method in Thread Class
		mt1.start();
		
		// In Runable We Can Not Call Start Method Directly
		// Using Thread Class Convert Runable Object into Thread Class 
	    MyThread2 mt2 = new MyThread2();
	    Thread t1 = new Thread(mt2);
	    t1.start();
	    
	    // Using this Method You can set Thread Name
	    t1.setName("Thread - 01");
	}
}
