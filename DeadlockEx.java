package MultiThreading;
// Deadlock Real Time Example
class Library implements Runnable{
	String res1 = new String("Java");
	String res2 = new String("MySQL");
	String res3 = new String("DSA");
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		if(name.equals("STUDENT-01")) {
			try {
				Thread.sleep(3000);
			     synchronized(res1) {
			    	 System.out.println("Student-01 has aquired the "+res1);
			    	 Thread.sleep(3000);
			     
			     synchronized(res2) {
			    	 System.out.println("Student-01 has aquired the "+res2);
			    	 Thread.sleep(3000);
			     
			     synchronized(res3) {
			    	 System.out.println("Student-01 has aquired the "+res3);
			    	 Thread.sleep(3000);
			     }
			    }
			   }
			} catch (InterruptedException e) {
			System.out.println("Some Problem");
			}
		}else {
			try {
				Thread.sleep(3000);
			     synchronized(res3) {
			    	 System.out.println("Student-02 has aquired the "+res3);
			    	 Thread.sleep(3000);
			     
			     synchronized(res2) {
			    	 System.out.println("Student-02 has aquired the "+res2);
			    	 Thread.sleep(3000);
			     
			     synchronized(res1) {
			    	 System.out.println("Student-02 has aquired the "+res1);
			    	 Thread.sleep(3000);
			     }
			    }
			   }
			} catch (InterruptedException e) {
			System.out.println("Some Problem");
			}
		}
	}
}

public class DeadlockEx {
	public static void main(String[] args) {
		Library lib = new Library();
		Thread t1 = new Thread(lib);
		Thread t2 = new Thread(lib);
		
		t1.setName("STUDENT-01");
		t2.setName("STUDENT-02");
	
		t1.start();
		t2.start();
	}
}

