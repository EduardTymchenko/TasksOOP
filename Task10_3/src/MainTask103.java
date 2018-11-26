import java.util.*;

public class MainTask103 {
    public static void main(String[] args) {
        int[] arrayInt = new int[10];
        Random random = new Random();
        int min = -10;
        int max = 10;
        int diff = max - min;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = random.nextInt(diff + 1);
            arrayInt[i] += min;
            if (map.containsKey(arrayInt[i])) map.put(arrayInt[i],map.get(arrayInt[i])+1);
            else map.put(arrayInt[i],1);

        }
        System.out.println(Arrays.toString(arrayInt));
        Set<Map.Entry<Integer,Integer>> setMap = map.entrySet();
        for (Map.Entry<Integer,Integer> item : setMap){
            System.out.println("Number: " + item.getKey() + " repeats: " + item.getValue());
        }
    }
}
