import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank FNB = new Bank("FNB");

    public static void main(String[] args){

        boolean quit = false;
        printInstructions(FNB);
        while(!quit){
            System.out.println("Enter your choice.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions(FNB);
                    break;
                case 1:
                    listBranches(FNB);
                    break;
                case 2:
                    addBranch(FNB);
                    break;
                case 3:
                    addCustomer(FNB);
                    break;
                case 4:
                    addTransaction(FNB);
                    break;
                case 5:
                    listCustomers(FNB);
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(Bank myBank){
        myBank.printInstructions();
    }

    public static void listBranches(Bank myBank){
        myBank.listBranches();
    }

    public static void addBranch(Bank myBank){
        System.out.println("Enter branch name");
        String branchName = scanner.nextLine();
        if(myBank.addBranch(branchName)){
            System.out.println("Branch added.");
        }
        else{
            System.out.println("Error: branch already exists");
        }
    }

    public static void addCustomer(Bank myBank){
        System.out.println("Enter branch name");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction");
        double transaction = scanner.nextDouble();

        if(myBank.addCustomer(myBank.getBranch(branchName), customerName, transaction)){
            System.out.println(customerName + " added with transaction " + transaction +
                    " at " + branchName);
        }
        else{
            System.out.println("Error. Branch does not exist or branch already exists and " +
                    "customer already exists");
        }
    }

    public static void addTransaction(Bank myBank){
        System.out.println("Enter branch name");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction");
        double transaction = scanner.nextDouble();

        if(myBank.addTransaction(myBank.getBranch(branchName), customerName, transaction)){
            System.out.println("Transaction " + transaction + " added for " + customerName
                    + " at branch " + branchName);
        }
        else{
            System.out.println("Error");
        }
    }

    public static void listCustomers(Bank myBank){
        System.out.println("Enter branch name");
        String branchName = scanner.nextLine();
        myBank.getBranch(branchName).listCustomers();
    }
}
