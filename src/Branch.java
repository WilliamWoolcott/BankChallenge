import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customerList;

    public Branch(String branchName){
        this.branchName = branchName;
        this.customerList = new ArrayList<Customer>();
    }

    public boolean addCustomer(String customerName, double transaction){
        Customer customer = findCustomer(customerName);
        if (customer == null){
            customerList.add(new Customer(customerName, transaction));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transaction) {
        if (findCustomer(customerName) != null) {
            findCustomer(customerName).addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName){
        for(int i = 0; i < this.customerList.size(); i++){
            Customer customer = this.customerList.get(i);
            if(customer.getCustomerName().equals(customerName)){
                return customer;
            }
        }
        return null;
    }

    public String getBranchName(){
        return this.branchName;
    }

    public ArrayList<Customer> getCustomerList(){
        return this.customerList;
    }

}
