package MultiThreading;

//Real time Example of synchronization using Lambda Expression
class Atm {
	synchronized public void withdraw(String name,int amount) {
		System.out.println(name+" Entered the ATM");
	
	    try {
			Thread.sleep(3000);
			
			System.out.println(name+ " is Withdrawing Amount "+amount);
		    Thread.sleep(3000);
		    
		    System.out.println(name+" Complete the Transaction and Exit ATM");
	        Thread.sleep(3000);
	        
	    } catch (InterruptedException e) {
			System.out.println("Some Problem");
	      }
	}
}
public class P6 {
	public static void main(String[] args) {
		Atm a = new Atm();
		
		Runnable r1 = () -> a.withdraw("User 01", 2000);
		Runnable r2 = () -> a.withdraw("User 02", 5000);
		Runnable r3 = () -> a.withdraw("User 03", 7000);
	    
	    new Thread(r1).start();
	    new Thread(r2).start();
	    new Thread(r3).start();
	}

}
