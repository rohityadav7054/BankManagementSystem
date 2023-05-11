
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class User{
    private String name;
    private double amount;

    public User(){

    }

    public User(String name, double amount){
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


class Bank{

    private List<User> users;

    public Bank(){
        this.users = new ArrayList<User>();
    }

    public void addAccount(){
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Amount: ");
        double amount = scanner.nextDouble();
        User user = new User(name, amount);
        this.users.add(user);
    }

    public void allAccounts(){
        System.out.println("\n\n");
        for(int i=0; i<this.users.size(); i++){
            System.out.println("Account #"+(i+1)+"\nName: "+this.users.get(i).getName()+"\nAmount: "+this.users.get(i).getAmount()+" \n\n");
        }
    }

    public void accountSearch(){
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();
        int account = this.searchAccount(name);
        if( account == -1){
            System.out.println("Sorry no account found.");
        }else{
            System.out.println("Name: "+this.users.get(account).getName()+"\nAmount: "+this.users.get(account).getAmount()+" \n\n");
        }
    }


    public void deposit(){
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();
        int account = this.searchAccount(name);
        if(account == -1){
            System.out.println("Sorry no account found.");
        }else{
            double current_amount = this.users.get(account).getAmount();
            System.out.print("Deposit amount: ");
            double amount = scanner.nextDouble();
            this.users.get(account).setAmount(current_amount + amount);
            System.out.println("Your total amount is "+this.users.get(account).getAmount());
        }

    }

    public void withdrawal(){
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();
        int account = this.searchAccount(name);
        if(account == -1){
            System.out.println("Sorry no account found.");
        }else{
            double current_amount = this.users.get(account).getAmount();
            System.out.print("Withdrawal amount: ");
            double amount = scanner.nextDouble();
            if(current_amount >= amount){
                this.users.get(account).setAmount(current_amount - amount);
                System.out.println("Your total amount is "+this.users.get(account).getAmount());
            }else{
                System.out.println("You have insufficient balance.");
            }
        }

    }


    private int searchAccount(String name){
        boolean flag = false;
        int account = -1;
        for (int i=0; i<this.users.size(); i++){
            if(this.users.get(i).getName().equals(name)){
                account = i;
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        if(flag){
            return account;
        }else{
            return account;
        }
    }


}




public class bankingSystem {

    public static void main(String[] args) {
        Bank bank = new Bank();
        while(true){
            System.out.println("==== Welcome To The MKBANK ====");
            System.out.println("1 => Add Account");
            System.out.println("2 => All Account");
            System.out.println("3 => Account Search");
            System.out.println("4 => Account Deposit");
            System.out.println("5 => Account Withdrawal");
            System.out.println("6 => Exit");
            System.out.print("your Choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                bank.addAccount();
            }else if(choice == 2){
                bank.allAccounts();
            }else if(choice == 3){
                bank.accountSearch();
            }else if(choice == 4){
                bank.deposit();
            }else if(choice == 5){
                bank.withdrawal();
            }else if (choice == 6){
                System.out.println("Application is terminated");
                break;
            }else{
                System.out.println("Wrong input try again.");
            }
        }
    }

}