package MultiThreading;
class ATM {
	public synchronized void withDraw(String name, int amount) {
		System.out.println(name+" Enter ATM");
		try {
			Thread.sleep(3000);
			
			System.out.println(name+" WithDrawing Amount "+amount);
			Thread.sleep(3000);
			
			System.out.println(name+ " Complete Transaction");
			
		} catch (InterruptedException e) {
			
		}
	}
}
public class P9 {
	public static void main(String[] args) {
		
	ATM a = new ATM();
	Runnable r1 = () -> a.withDraw("User 01",3000);
	Runnable r2 = () -> a.withDraw("User 02",2000);
	Runnable r3 = () -> a.withDraw("User 03",6000);
	
	new Thread(r1).start();
    new Thread(r2).start();
    new Thread(r3).start();
	
	}
}
