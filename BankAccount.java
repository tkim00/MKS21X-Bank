public class BankAccount{
  private double balance;
  private int accountID;
  private String password;

  public BankAccount(double initBalance, int id, String pass){
    balance = initBalance;
    accountID = id;
    password = pass;
  }

  public double getBalance(){
    return balance;
  }
  public int getAccountID(){
    return accountID;
  }
  public void setPassword(String newPass){
    password = newPass;
  }
  public String toString(){
    return "" + accountID + ": " + balance;
  }

  public boolean deposit(double amount){
    if(amount >= 0){
      balance += amount;
      return true;
    }
    return false;
  }
  public boolean withdraw(double amount){
    if(balance >= amount){
      balance -= amount;
      return true;
    }
    return false;
  }
  private boolean authenticate(String pass){
    return password.equals(pass);
  }
  /**Transfer money from this BankAccount to the other only when the password matches, and the withdrawal succeeds.
 *param other which BankAccount to GIVE the money to
 *param amount how much money to transfer, negative amounts will make this operation fail.
 *param password to be checked against the source account, incorrect password will make this operation fail.
 *return true if successful, false otherwise.
 */
  public boolean transferTo(BankAccount other, double amount, String password){
    if(amount >= 0 && this.authenticate(password) && this.withdraw(amount)){
      other.deposit(amount);
      return true;
    }
    return false;
  }
}
