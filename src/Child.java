import java.util.Random;

public class Child extends Customer {
    public Cash choosingCash(Cash[] cash){
        Random rnd = new Random();
        return cash[rnd.nextInt(cash.length)];
    }

    public String getName(){
        return "Child";
    }
}
