import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void printCashes(Cash[] cash){
        int maxSize = 0;
        for (Cash c : cash){
            if (maxSize < c.getLenghtOfQueue()){
                maxSize = c.getLenghtOfQueue();
            }
        }
        System.out.printf("%10s", "Cash №1");
        System.out.printf("%10s", "Cash №2");
        System.out.printf("%10s", "Cash №3");
        System.out.printf("%10s%n", "Cash №4");
        for (int i = 0; i < maxSize; i++){
            for (int j = 0; j < cash.length; j++){
                if (cash[j].getLenghtOfQueue() - 1 < i){
                    System.out.printf("%10s", "");
                } else {
                    String name = cash[j].getQueue().get(i).getName();
                    System.out.printf("%10s", name);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countOfCustomers = in.nextInt();
        Cash[] cashes = new Cash[4];
        System.out.println("Write speeds of 4 cashes");
        for (int i = 0; i < cashes.length; i++){
            int speed = in.nextInt();
            while (speed < 1 || speed > 3){
                System.out.println("Please, write correct speed. It should be 1 <= speed <= 3");
                speed = in.nextInt();
            }
            cashes[i] = new Cash(speed);
        }
        int countOfSteps = in.nextInt();
        for (int i = 0; i < countOfSteps; i++){
            if (countOfCustomers > i) {
                Random rnd = new Random();
                int custNum = rnd.nextInt(3);
                Customer customer;
                if (custNum == 0) {
                    customer = new Child();
                } else if (custNum == 1) {
                    customer = new Women();
                } else {
                    customer = new Man();
                }
                Cash choosingCash = customer.choosingCash(cashes);
                choosingCash.addCustomer(customer);
                customer.printPurchases();
            }
            for (Cash c : cashes){
                c.service();
            }
            printCashes(cashes);
        }

    }
}
