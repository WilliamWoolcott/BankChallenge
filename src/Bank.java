import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName){
        this.bankName = bankName;
        this.branchList = new ArrayList<Branch>();
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
        if(findBranch(branchName) == null){
            this.branchList.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = (findBranch(branchName));
        if(branch != null) {
            return branch.addCustomer(customerName, transaction);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transaction){
        if(findBranch(branchName) != null){
            return findBranch(branchName).addTransaction(customerName, transaction);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        if(findBranch(branchName) != null){
            ArrayList<Customer> branchCustomers = findBranch(branchName).getCustomerList();
            for(int i = 0; i < branchCustomers.size(); i++){
                System.out.println(branchCustomers.get(i).getCustomerName() + "\n");
                    if(showTransactions){
                        ArrayList<Double> customerTransactions =
                                branchCustomers.get(i).getTransactionList();
                        for(int j = 0; j < customerTransactions.size(); j++){
                            System.out.println((j + 1) + ". " + customerTransactions.get(j) + "\n");
                        }
                    }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public void listBranches(){
        for(int i = 0; i < branchList.size(); i++){
            System.out.println(branchList.get(i).getBranchName() + "\n");
        }
    }

    public Branch findBranch(String branchName){
        for(int i = 0; i < branchList.size(); i++){
            if(this.branchList.get(i).getBranchName().equals(branchName)){
                return this.branchList.get(i);
            }
        }
        return null;
    }
}
