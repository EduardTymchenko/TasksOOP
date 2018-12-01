import java.util.Arrays;

public class MultiThreadSort {
    public static void sortShellThreads(int[] arrayInt, int numberThreads){
        SingleThreadSort[] arrayThread = new SingleThreadSort[numberThreads];
        for (int i = 0; i < arrayThread.length; i++){
            int size = Math.round((float) arrayInt.length / numberThreads) ;
            int begin = i * size;
            int end = ((i + 1) * size);
            if (i == arrayThread.length - 1) end = arrayInt.length;
            arrayThread[i] = new SingleThreadSort(arrayInt,begin, end);
            //System.out.println(Arrays.toString(arrayInt));
        }
        for (int i = 0; i < arrayThread.length; i++) {
            try {
                arrayThread[i].getThread().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.arraycopy(mergeArrays(arrayInt, arrayThread), 0, arrayInt, 0, arrayInt.length);
    }
    private static int[] mergeArrays(int[] array, SingleThreadSort[] threadarray) {
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < threadarray.length; j++) {
                if (!threadarray[j].isStop() && min > threadarray[j].peekElement()) {
                    min = threadarray[j].peekElement();
                    k = j;
                }
            }
            if (k != -1) {
                arr[i] = threadarray[k].pollElement();
            }
        }
        return arr;
    }
}
