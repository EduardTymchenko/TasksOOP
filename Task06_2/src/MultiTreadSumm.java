public class MultiTreadSumm {
    public static int summaThreads(int[] arrayInt, int numberThreads){
        SingleThreadSumm[] arrayThread = new SingleThreadSumm[numberThreads];
        for (int i = 0; i < arrayThread.length; i++){
            int size = arrayInt.length/numberThreads;
            int begin = i * size;
            int end = ((i + 1) * size);
            if ((arrayInt.length - end) < size) end = arrayInt.length;
            arrayThread[i] = new SingleThreadSumm(begin, end, arrayInt);
        }
        for (int i = 0; i < arrayThread.length; i++) {
            try {
                arrayThread[i].getThread().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        int summaThread = 0;
        for (int i = 0; i < arrayThread.length; i++) {
                summaThread += arrayThread[i].getSumma();
        }
        return summaThread;
    }
}
