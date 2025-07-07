import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Account
{
    private String name;
    private double balance;
    private int account_number;
    // Global shared account list
    public static List<Account> accountList = new ArrayList<>();

    public Account(String name, double balance, int account_number)
    {
        this.name = name ;
        this.balance = balance ;
        this.account_number = account_number ;
    }
    public String getName()
    {
        return name;
    }
   
    public double getBalance()
    {
        return balance;
    }
    public int getAccount_number()
    {
        return account_number;
    }
    public void  deposit(double amount)
    { 
        if(amount > 0)
        {
            balance+=amount;
            System.out.println("Deposited " + amount + " to " + name);
        }
        else
         {
            System.out.println("Invalid deposit amount.");
        }

    }
    public void withdraw (double amount)
    {
        if(amount > 0 && amount <= balance)
        {
              balance-= amount;
              System.out.println("Withdrawn " + amount + " from " + name);
        }
        else{
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
    public void transfer (Account reciever , double amount )
    {
        if(amount >0 && amount <= balance)
        {
            this.balance -= amount;
            reciever.balance += amount;
            System.out.println("Transferred " + amount + " from " + name + " to " + reciever.getName());
          }
            else
             {
            System.out.println("Transfer failed: insufficient funds or invalid amount.");
            }
    }
    public static void show_all_accounts() 
    {
        for (Account acc : accountList)
        {
              System.out.println("Name: " + acc.getName() + ", Account#: " + acc.getAccount_number() + ", Balance: " + acc.getBalance());
        }
       
    }
     public static void add(Account account)
     {
        accountList.add(account);
     }
     public static Account  find_account(int number)
     {
        for (Account account : accountList)
        {
            if(account.getAccount_number() == number)
            {
                return account;
            }

        }
        return null;
     }

}
public class BankManager {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        // ArrayList<Account> accounts = new ArrayList<>();

           
            boolean exit  = true;
            while(exit)
            {
                    System.out.println("\n🔸 Bank Menu 🔸");
                    System.out.println("1. Create Account");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer");
                    System.out.println("5. Show All Accounts");
                    System.out.println("6. Show Total Bank Balance");
                    System.out.println("0. Exit");
                    System.out.print("Select option: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                 switch (choice) {
                    case 1:
                          System.out.print("Enter name: ");
                          String name = sc.nextLine();
                           
                          System.out.print("Enter account number: ");
                           int account = sc.nextInt();
                            System.out.print("Enter initial balance: ");
                            double bal =  sc.nextDouble();
                            Account.add(new Account(name, bal, account));

                        break;
                    case 2:
                          System.out.print("Enter account number: ");
                          int account1 = sc.nextInt();
                          Account a = Account.find_account(account1);
                          if(a != null)
                          {
                            System.out.print("Enter amount to deposit: ");
                            double deposit = sc.nextDouble();
                            a.deposit(deposit);
                          }
                          else 
                          {
                          System.out.println(".Account not found.");
                         }
                         break;
                    case 3:
                         System.out.print("Enter account number: ");
                         int account2 = sc.nextInt();
                         Account b = Account.find_account(account2);
                         if(b != null)
                          {
                            System.out.print("Enter amount to withdraw: ");
                            double withdraw = sc.nextDouble();
                            b.withdraw(withdraw);
                          }
                          else 
                          {
                          System.out.println("Account not found.");
                          }
                          break;
                    case 4:
                           System.out.print("Sender account number: ");
                            int fromAcc = sc.nextInt();
                           System.out.print("Receiver account number: ");
                           int toAcc = sc.nextInt();
                            Account sender = Account.find_account(fromAcc);
                            Account reciever = Account.find_account(toAcc);
                            if(sender != null && reciever != null)
                            {
                                System.out.print("Enter amount to transfer: ");
                                sender.transfer(reciever , sc.nextDouble());
                            }
                            else
                            {
                                System.out.println("Account not found");
                            }
                            break;
                    case 5:
                         Account.show_all_accounts();
                         break;
                    case 6:
                         double total = 0;
                          for (Account q : Account.accountList)
                           {
                              total += q.getBalance();
                          }
                          System.out.println("🏦 Total Bank Balance: " + total);
                          break;
                           
                    case 0 :
                        exit = false;
                         
                        break;
                 }

            }

        
    }
}
