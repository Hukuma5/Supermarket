import java.util.LinkedList;
import java.util.Queue;

public class Cash {
    private int speed;
    private LinkedList<Customer> queue;

    public Cash(int speed){
        this.speed = speed;
        this.queue = new LinkedList<Customer>();
    }

    public void addCustomer(Customer unit){
        this.queue.add(unit);
    }

    public void service(){
        int k = this.speed;
        for (Customer unit : this.queue){
            k -= unit.getRemainsOfPurchases();
            if (k == 0){
                unit.setRemainsOfPurchases(0);
                this.queue.remove(unit);
                break;
            } else if(k > 0){
                this.queue.remove(unit);
            } else {
                unit.setRemainsOfPurchases(-k);
                break;
            }
        }
    }

    public int getLenghtOfQueue(){
        return this.queue.size();
    }

    public int getSpeed(){
        return this.speed;
    }

    public LinkedList<Customer> getQueue(){
        return this.queue;
    }

}
