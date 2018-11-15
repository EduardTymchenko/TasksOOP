import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyFileBlock implements Runnable {
    private String pathSourse;
    private String pathCopy;
    private long start;
    private long end;
    private Thread thr;
    private int numberThreads;
    int sizeBuffer = 10; //bytes


    public CopyFileBlock(String pathSourse, String pashCopy, long start, long end, int numberThreads) {
        this.pathSourse = pathSourse;
        this.pathCopy = pashCopy;
        this.start = start;
        this.end = end;
        this.numberThreads = numberThreads;
        thr = new Thread(this);
        thr.start();
    }

    public Thread getThr() {
        return thr;
    }

    public int getSizeBuffer() {
        return sizeBuffer;
    }

    public void setSizeBuffer(int sizeBuffer) {
        this.sizeBuffer = sizeBuffer;
    }

    private void progress(int sizeBuffer, long count) {
        int numberScrolls = Math.round((float) 10 / numberThreads);
        long full = (long) Math.ceil((double) (end - start) / sizeBuffer);
        if ((numberScrolls / full) > 0){
            for (int i = 0; i < (numberScrolls / full); i ++ ) {
                System.out.print("#");
            }
        } else if (count % ((full / numberScrolls)) == 0)
            System.out.print("#");
    }

    @Override
    public void run() {
        long count = 0;
        byte[] buffer;
        long iterator = start;
        try (RandomAccessFile sourceFile = new RandomAccessFile(pathSourse, "r");
             RandomAccessFile copyFile = new RandomAccessFile(new File(pathCopy), "rw")) {

            while (iterator < end) {
                sourceFile.seek(iterator);
                copyFile.seek(iterator);
                if ((end - iterator) >= sizeBuffer) buffer = new byte[sizeBuffer];
                else buffer = new byte[(int) (end - iterator)];
                sourceFile.read(buffer);
                copyFile.write(buffer);
                iterator += buffer.length;
                count++;
                progress(sizeBuffer, count);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist, " + getThr() + ": " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("File does not create, " + getThr() + ": "  + e.getMessage());
            System.exit(1);
        }
    }
}
