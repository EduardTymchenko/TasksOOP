import java.util.Random;

public class MainTask06_2 {
    public static void main(String[] args) {
        int[] arrayInteger = new int[100000];
        Random random = new Random();

        for (int i = 0; i < arrayInteger.length; i++){
            arrayInteger[i] = random.nextInt(100);
        }

        long timeStart1 = System.currentTimeMillis();
        System.out.println("Total summa (thread 1): " + MultiTreadSumm.summaThreads(arrayInteger,1));
        System.out.println("Lead time: " + (System.currentTimeMillis() - timeStart1));

        long timeStart5 = System.currentTimeMillis();
        System.out.println("Total summa (thread 5): " + MultiTreadSumm.summaThreads(arrayInteger,5));
        System.out.println("Lead time: " + (System.currentTimeMillis() - timeStart5));

        long timeStart10 = System.currentTimeMillis();
        System.out.println("Total summa (thread 10): " + MultiTreadSumm.summaThreads(arrayInteger,10));
        System.out.println("Lead time: " + (System.currentTimeMillis() - timeStart10));

        long timeStart20 = System.currentTimeMillis();
        System.out.println("Total summa (thread 20): " + MultiTreadSumm.summaThreads(arrayInteger,20));
        System.out.println("Lead time: " + (System.currentTimeMillis() - timeStart20));

    }
}
