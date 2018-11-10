public class SingleThreadSumm implements Runnable {
    private int begin;
    private int end;
    private int[] arrayInt;
    private Thread thread;
    private int summa;

    public SingleThreadSumm(int begin, int end, int[] arrayInt) {
        this.begin = begin;
        this.end = end;
        this.arrayInt = arrayInt;
        thread = new Thread(this);
        thread.start();
    }

    public int getSumma() {
        return summa;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++){
            summa += arrayInt[i];
        }
    }
}
