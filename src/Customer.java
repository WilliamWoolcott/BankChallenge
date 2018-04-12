import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactionList = new ArrayList<Double>();

    public Customer(String customerName, double transaction) {
        this.customerName = customerName;
        this.transactionList = new ArrayList<Double>();
        transactionList.add(Double.valueOf(transaction));
    }

    public void addTransaction(double transaction){
        transactionList.add(Double.valueOf(transaction));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void printTransactionList(){
        for(int i = 0; i < transactionList.size(); i++) {
            System.out.println(transactionList.get(i) + "\n");
        }
    }

    public int getTransactionListSize(){
        return transactionList.size();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Double> getTransactionList(){
        return this.transactionList;
    }
}
