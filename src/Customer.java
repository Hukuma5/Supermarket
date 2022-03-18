import java.util.Random;

public abstract class Customer {
    private int purchaseCount;
    private boolean isJustComeIn;
    private int remainsOfPurchases;

    public Customer(){
        int min = 1;
        int max = 5;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        this.purchaseCount = i;
        this.remainsOfPurchases = this.purchaseCount;
    }

    public int getRemainsOfPurchases(){
        return this.remainsOfPurchases;
    }

    public void setRemainsOfPurchases(int a){
        this.remainsOfPurchases = a;
    }

    public int getPurchaseCount(){
        return this.purchaseCount;
    }

    public void printPurchases(){
        System.out.print(this.getName());
        System.out.println(this.purchaseCount);
    }

    abstract Cash choosingCash(Cash[] cash);
    abstract String getName();
}
