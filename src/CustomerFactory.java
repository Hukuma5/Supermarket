import java.util.Random;

public class CustomerFactory {
    private int generateCountOfPurchases(){
        Random rnd = new Random();
        return rnd.nextInt(5) + 1;
    }

    public Customer generateCustomer(){
        Random rnd = new Random();
        int custNum = rnd.nextInt(3);
        Customer customer;
        int CountOfPurchases = this.generateCountOfPurchases();
        if (custNum == 0) {
            customer = new Child(CountOfPurchases);
        } else if (custNum == 1) {
            customer = new Women(CountOfPurchases);
        } else {
            customer = new Man(CountOfPurchases);
        }
        return customer;
    }
}
