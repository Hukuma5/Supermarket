public class Women extends Customer{
    public Cash choosingCash(Cash[] cash){
        int minLenght = cash[0].getLenghtOfQueue();
        Cash choosenCash = cash[0];
        for (Cash i : cash){
            if (minLenght > i.getLenghtOfQueue()){
                minLenght = i.getLenghtOfQueue();
                choosenCash = i;
            }
        }
        return choosenCash;
    }

    public String getName(){
        return "Women";
    }
}
