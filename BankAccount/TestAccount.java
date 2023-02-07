public class TestAccount {
    public static void main(String[] args){
        BankAccount newAccount = new BankAccount(0, 0);
        newAccount.deposit(0, 100);
        newAccount.view();
        BankAccount accountTwo = new BankAccount(1000, 1000);
        accountTwo.view();
        accountTwo.withdraw(1, 1100);
        accountTwo.withdraw(1, 900);

        System.out.println(BankAccount.numOfAccounts);
        System.out.println(BankAccount.sumOfAccounts);

    }
}
