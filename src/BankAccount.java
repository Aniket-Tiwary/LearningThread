import java.util.Random;

public class BankAccount {
    private long number; //account number
    private long balance; // account balance

    public BankAccount(long initialDeposit){
        this.number = createAccountNumber();
        this.balance = initialDeposit;
    }

    public synchronized long getBalance(){
        return this.balance;
    }

    public synchronized void deposit(long depositAmount){
        this.balance += depositAmount;
    }

    private long createAccountNumber(){
        Random random = new Random();
        return random.nextLong();
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        System.out.println(account1.getBalance());
        System.out.println(account1.number);
    }
}
