import java.util.Random;
public class BankAccount {
        private double checkingBal = 0;
        private double savingsBal = 0;
        private long accountNumber;
        static int numOfAccounts = 0;
        static double sumOfAccounts = 0;
        public BankAccount(double checkingBal, double savingsBal){
          this.checkingBal = checkingBal;
          this.savingsBal = savingsBal;
          this.accountNumber = this.generateAccountNumber();
          numOfAccounts++;
          sumOfAccounts+=(checkingBal + savingsBal);
        }
  private long generateAccountNumber(){
    Random random = new Random();
    long number = random.nextLong();
    number = Math.abs(number);
    number = number % 10000000000L;
    return number;
  }
  public long getAccountNumber(){
    return this.accountNumber;
  }

  public double getCheckingBal() {
    return this.checkingBal;
  }

  public void setCheckingBal(double checkingBal) {
    this.checkingBal = checkingBal;
  }

  public double getSavingsBal() {
    return this.savingsBal;
  }

  public void setSavingsBal(double savingsBal) {
    this.savingsBal = savingsBal;
  }

  //identifier to be 0 = checking 1 = savings
  public void deposit(int identifier, double deposit){
    if(identifier == 0){
      this.setCheckingBal(this.checkingBal += deposit);
    } else{
      this.setSavingsBal(this.savingsBal += deposit);
    }
    sumOfAccounts += deposit;
  }

  //identifier to be 0 = checking 1 = savings
  public void withdraw(int identifier, double amount){
    if(identifier == 0 && this.checkingBal >= amount){
      this.setCheckingBal(this.checkingBal -= amount);
    sumOfAccounts -= amount;
    } else if(this.savingsBal >= amount){
      this.setSavingsBal(this.savingsBal -= amount);
    sumOfAccounts -= amount;
    } else{
      System.out.println("Insufficent funds");
    }
  }
  public void view(){
    System.out.println("Checking: " + this.getCheckingBal());
    System.out.println("Savings: " + this.getSavingsBal());
  }
  
    
  
    }