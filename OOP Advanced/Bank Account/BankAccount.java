import java.util.Random;

public class BankAccount {

    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int amoutOfAccounts = 0;
    private static double moneyTotal = 0;

    public BankAccount () {
        accountNumber = generateAccount ();
        checkingBalance = 0;
        savingsBalance = 0;
        amoutOfAccounts++;
    }

    private String generateAccount () {
        Random random = new Random();
        String numbers = "0123456789";
        String account = "";
        
        for (byte i = 0; i<10; i++) {   
            byte randomNumber = (byte)random.nextInt (10);
            account += numbers.charAt(randomNumber);
        }

        return account;
    }

    public double getCheckingBalance () {
        return checkingBalance;
    }

    public double getSavingsBalance () {
        return savingsBalance;
    }

    public void deposit (String account, double amount) {
        if (account == "checking") {
            checkingBalance += amount;
            moneyTotal += amount;
        } else if (account == "savings") {;
            savingsBalance += amount;
            moneyTotal += amount;
        } else {
            System.out.println ("Please enter a correct account type for the deposit (use checking or savings).");
        }
    }

    public boolean withdraw (String account, double amount) {
        if (account == "checking") {
            if (checkingBalance < amount) {
                System.out.println ("Insufficient funds in [" + accountNumber + "]checking account.");
                return false;
            }
            checkingBalance -= amount;
            moneyTotal -= amount;
            return true;
        } else if (account == "savings") {
            if (savingsBalance < amount) {
                System.out.println ("Insufficient funds in [" + accountNumber + "]savings account.");
                return false;
            }
            savingsBalance -= amount;
            moneyTotal -= amount;
            return true;
        } else {
            System.out.println ("Please enter a correct account type for the withdraw (use checking or savings).");
            return false;
        } 
    }

    public void AccountMoney () {
        System.out.println ("Checking account balance: " + checkingBalance + ", Savings account balance: " + savingsBalance);
    }
}