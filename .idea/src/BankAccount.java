class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
    System.out.println("Deposited: Rs."+amount);
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount>balance){
            throw new InsufficientBalanceException("Insufficient balance! Available: Rs."+ balance);

        }
        balance -=amount;
    System.out.println("Withdrawn: Rs."+amount);
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}

public class BankAccount {
    public static void main(String [] args){
        Account acc = new Account("1234567890", 1000.0);
        acc.deposit(500);
        try{
            acc.withdraw(2000);
        } catch (InsufficientBalanceException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}