import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainTask09_1 {
    public static void main(String[] args) {
        myList();
    }
    public static void myList(){
        List<Integer> myList = new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            myList.add(random.nextInt(100));
        }
        for (Integer integer : myList){
            System.out.print(integer + " ");
        }
        System.out.println();
        myList.remove(0);
        myList.remove(0);
        myList.remove(myList.size() - 1);
        for (Integer integer : myList){
            System.out.print(integer + " ");
        }
    }
}
