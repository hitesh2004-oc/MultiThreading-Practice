package MultiThreading;

class Car implements Runnable{

	// Synchronization Method
	public synchronized void run() {
		
		try {
			System.out.println(Thread.currentThread().getName()+" has entered the Parking Lot");
			Thread.sleep(3000);
			
			System.out.println(Thread.currentThread().getName()+" Got into Car to drive");
			Thread.sleep(3000);
			
			System.out.println(Thread.currentThread().getName()+" Start to Drive the Car");
			Thread.sleep(3000);
			
			System.out.println(Thread.currentThread().getName()+" came back and Parked the car");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Some Problem");
		}
		
	}
	
}
public class P4 {
	public static void main(String[] args) {
		Car c = new Car();
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		
		t1.setName("Son 01");
		t2.setName("Son 02");
		t3.setName("Son 03");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
