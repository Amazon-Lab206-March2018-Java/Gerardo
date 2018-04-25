public class BankAccountTest {

    public static void main (String[] args) {
        BankAccount joses = new BankAccount();
        BankAccount stheves = new BankAccount();

        joses.deposit ("checking", 1000);
        joses.deposit ("gibberish", 1000);
        stheves.deposit ("savings", 500);

        joses.AccountMoney();
        stheves.AccountMoney();

        System.out.println (joses.withdraw("checking", 500) );
        System.out.println (joses.withdraw("savings", 500) );
        joses.AccountMoney();
    }
}