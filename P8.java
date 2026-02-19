package MultiThreading;
class BankAccount {

    private int balance = 10000;

    
    public synchronized void Payment(String user, int amount) {

        System.out.println(user + " trying to pay: " + amount);

        if (balance >= amount) {

            System.out.println("Payment processing for " + user);

            try {
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
            
            }

            balance = balance - amount;

            System.out.println("Payment successful for " + user);
            System.out.println("Remaining balance: " + balance);

        } else {
            System.out.println("Payment failed for " + user + " Not Enough Balance..");
        }

        System.out.println("---------------------");
    }
}


public class P8 {
    public static void main(String[] args) {

        BankAccount a = new BankAccount();

        Runnable r1 = () -> a.Payment("User 01", 2000);
		Runnable r2 = () -> a.Payment("User 02", 5000);
		Runnable r3 = () -> a.Payment("User 03", 7000);

		new Thread(r1).start();
	    new Thread(r2).start();
	    new Thread(r3).start();
    }
}

