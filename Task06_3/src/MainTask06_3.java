import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MainTask06_3 {
    public static void main(String[] args) {
        int[] arraySource = new int[10];
        int[] arrayCopy = new int[arraySource.length];
        Random random = new Random();
        for (int i = 0; i < arraySource.length; i++) {
            arraySource[i] = random.nextInt(100)-50;
        }

        System.arraycopy(arraySource,0,arrayCopy,0,arraySource.length);

        MultiThreadSort.sortShellThreads(arrayCopy,2);
        System.out.println("Source array");
        System.out.println(Arrays.toString(arraySource));
        System.out.println("Sorted array by Shell method");
        System.out.println(Arrays.toString(arrayCopy));

    }
}
