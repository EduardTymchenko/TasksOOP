
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
    public  void run() {
        int increment = (end - begin) / 2;
        while (increment >= 1) {
            for (int startIndex = begin; startIndex < (increment + begin ); startIndex++) {
                insertionSort(arrayInt, startIndex, increment );
            }
            increment = increment / 2;
        }
    }

    private void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = startIndex + increment; i < end ; i = i + increment) {
            int tmp = arr[i];
            int j = i - increment;
            while (  j >= startIndex && tmp < arr[j]){
                arr[j + increment] = arr[j];
                j = j - increment;
            }
            arr[j + increment] = tmp;
        }
    }
}
