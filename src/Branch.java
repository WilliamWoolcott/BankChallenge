import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customerList;

    public Branch(String branchName){
        this.branchName = branchName;
    }

    public boolean addCustomer(String customerName, double transaction){
        if (findCustomer(customerName) == null){
            return false;
        }
        else{
            customerList.add(new Customer(customerName, transaction));
            return true;
        }
    }

    public boolean addTransaction(String customerName, double transaction) {
        if (findCustomer(customerName) == null) {
            findCustomer(customerName).addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName){
        for(int i = 0; i < customerList.size(); i++){
            if(this.customerList.get(i).getCustomerName().equals(customerName)){
                return this.customerList.get(i);
            }
        }
        return null;
    }

    public void listCustomers(){
        for(int i = 0; i < customerList.size(); i++){
            System.out.println(customerList.get(i).getCustomerName() + ": \n");
            for(int j = 0; j < customerList.get(i).getTransactionListSize(); j++){
                customerList.get(j).printTransactionList();
            }
        }
    }

    public String getBranchName(){
        return this.branchName;
    }

}
