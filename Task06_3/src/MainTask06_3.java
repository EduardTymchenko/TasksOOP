import java.util.Arrays;
import java.util.Random;

public class MainTask06_3 {
    public static void main(String[] args) {
        //int[] arraySource = new int[10];
        int[] arraySource ={9,8,7,6,5,4,3,2,1};
        int[] arrayCopy = new int[arraySource.length];
        Random random = new Random();
        /*
        for (int i = 0; i < arraySource.length; i++) {
            arraySource[i] = random.nextInt(100);
        }
        */
        //System.out.println(Arrays.toString(arraySource));
        System.arraycopy(arraySource,0,arrayCopy,0,arraySource.length);

        MultiThreadSort.sortShellThreads(arrayCopy,1);
        System.out.println();
        System.out.println(Arrays.toString(arraySource));
        System.out.println(Arrays.toString(arrayCopy));

    }
}
