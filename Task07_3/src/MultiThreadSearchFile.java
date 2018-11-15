import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThreadSearchFile {
    public static String searchFile(String fileName, String dirName) throws ExecutionException, InterruptedException {

        ThreadSearchFile threadSearchFile = new ThreadSearchFile(fileName, dirName);
        FutureTask<String> task = new FutureTask<>(threadSearchFile);
        Thread thread = new Thread(task);
        thread.start();
        return task.get();

    }
}
