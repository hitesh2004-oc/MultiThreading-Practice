package Day29;


public class P2 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				for(int i = 1; i<= 10;i++) {
					System.out.println(i);
				}
			}
		};
		Thread t2 = new Thread(r);
		t2.start();
		Runnable r1 = () ->{
			
				for(int i = 1; i<= 10;i++) {
					System.out.println(i);
						try {
				//it is Set Time duration between Threads
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
			
		};
		Thread t1 = new Thread(r1);
		t1.start();
		 
	}
}

