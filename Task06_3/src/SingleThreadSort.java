import java.util.Arrays;

public class SingleThreadSort implements Runnable {
    private int[] arrayInt;
    private int begin;
    private int end;
    private Thread thread;
    private int index;
    private boolean stop = false;

    public SingleThreadSort(int[] arrayInt, int begin, int end) {
        this.arrayInt = arrayInt;
        this.begin = begin;
        this.end = end;
        this.index = begin;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public int peekElement() {
        return arrayInt[index];
    }

    public int pollElement() {
        int temp = arrayInt[index];
        check();
        return temp;
    }

    public boolean isStop() {
        return stop;
    }

    private void check() {
        this.index++;
        if (this.index >= this.end) {
            this.stop = true;
        }
    }

    @Override
    public void run() {
        int increment = (end - begin) / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                //System.out.println(Arrays.toString(arrayInt));

                insertionSort(arrayInt, startIndex, increment);
            }
            increment = increment / 2;
            System.out.println(Arrays.toString(arrayInt));
        }
        //System.out.println(Arrays.toString(arrayInt));
    }

    private void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = begin; i < end ; i = i + increment) {
            for (int j = Math.min(i + increment, end - 1); j - increment >= 0; j = j - increment) {
                if (arr[j - increment] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - increment];
                    arr[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
