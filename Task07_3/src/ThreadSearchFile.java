import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadSearchFile implements Callable<String> {
    private String fileName;
    private String dirName;

    public ThreadSearchFile(String fileName, String dirName) {
        this.fileName = fileName;
        this.dirName = dirName;
    }

    @Override
    public String call() throws Exception {
        File dir = new File(dirName);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Directory " + dirName + " is not exist!");
            System.exit(1);
        }
        File[] files = dir.listFiles();
        StringBuilder sb = new StringBuilder();
        ArrayList<Future> listDir = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                ThreadSearchFile threadSearchFile = new ThreadSearchFile(fileName, file.getAbsolutePath());
                FutureTask<String> futureTask = new FutureTask<>(threadSearchFile);
                listDir.add(futureTask);
                Thread thread = new Thread(futureTask);
                thread.start();
            } else {
                if (file.getName().equalsIgnoreCase(fileName))
                    sb.append(file.getAbsolutePath()).append("\n");
            }
        }
        for (Future item : listDir) {
            sb.append(item.get());
        }
        return sb.toString();
    }
}
