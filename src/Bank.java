import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branchList = new ArrayList<Branch>();

    public Bank(String bankName){
        this.bankName = bankName;
    }

    public void printInstructions(){
        System.out.println("Welcome to " + bankName +"!\n" +
                "0. Print instructions again.\n" +
                "1. List branches.\n" +
                "2. Add new branch. \n" +
                "3. Add a new customer to a branch with an initial transaction. \n" +
                "4. Add a transaction for an existing customer \n" +
                "5. List all branches, customers and transactions. \n" +
                "6. Quit");
    }

    public boolean addBranch(String branchName){
        if(!isOnFile(branchName)){
            branchList.add(new Branch(branchName));
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addCustomer(Branch myBranch, String customerName, double transaction) {
        if (!isOnFile(customerName)) {
            if (myBranch.addCustomer(customerName, transaction)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean addTransaction(Branch myBranch, String customerName, double transaction){
        if(myBranch.addTransaction(customerName, transaction)){
            return true;
        }
        else{
            return false;
        }
    }

    public void listCustomers(Branch myBranch){
        myBranch.listCustomers();
    }

    public void listBranches(){
        for(int i = 0; i < branchList.size(); i++){
            System.out.println(branchList.get(i).getBranchName() + "\n");
        }
    }

    public Branch getBranch(String branchName){
        for(int i = 0; i < branchList.size(); i++){
            if(branchList.get(i).getBranchName().contains(branchName)){
                return branchList.get(i);
            }
        }
        return null;
    }

    public boolean isOnFile(String branchName){
        for(int i = 0; i < branchList.size(); i++){
            if(branchList.get(i).getBranchName().contains(branchName)) {
                return true;
            }
        }
        return false;
    }

    public void listAllCustomers(){
        for(int i = 0; i < branchList.size(); i++){
            System.out.println(branchList.get(i).getBranchName());


        }
    }

    //list customers and optionally a list of their transactions?
}
