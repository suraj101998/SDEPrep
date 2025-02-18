package BankAccount;
/*
 * It should have 3 data members
accountNumber: String
balance: int
roi:double (Should represent rate of interest)
It should have 2 methods
getSimpleInterest: It should take time (in years) as a parameter. The data type of time should be int. It should return Simple Interest as a double.
getBalanceWithInterest: It should take time (in years) as a parameter. The data type of time should be int. It should return a new balance (including simple interest) as a double.
 */
public class BankAccount {
    // write the code of bank account class here
    public String accountNumber;
    public int balance;
    public double roi;

    public BankAccount() {
        this.accountNumber = "";
        this.balance = 0;
        this.roi = 0.0;
    }
    public BankAccount(String accountNumber, int balance, double roi){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.roi = roi;
    }

    double getSimpleInterest(int time){
        return (balance*roi*time)/100.0;
    }
    double getBalanceWithInterest(int time){
        double interest = getSimpleInterest(time);
        return balance+interest;
    }

    public String getaccountNumber(){
        return accountNumber;
    }
    public void setaccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }
}

