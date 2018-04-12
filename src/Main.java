import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank FNB = new Bank("FNB");
        FNB.addBranch("Killarney");
        FNB.addCustomer("Killarney", "John", 300);
        FNB.addTransaction("Killarney", "John", -1000);
        FNB.addCustomer("Killarney", "Lucy", 40000);
        FNB.listCustomers("Killarney", true);
    }

}