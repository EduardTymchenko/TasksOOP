import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ThreadCopy implements Runnable {
    private File[] listFiles;
    private String pathSource;
    private String pathCopy;
    private Thread thread;

    public ThreadCopy(String source, String copy, File[] listFiles) {
        pathSource = "Task06_4/" + source;
        pathCopy = "Task06_4/" + copy;
        this.listFiles = listFiles;
        thread = new Thread(this);
        thread.start();
    }

    private void checkDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!dir.isDirectory()) {
            System.out.println("Directory " + path + " not exist and not create!");
            System.exit(1);
        }
    }

    @Override
    public void run() {
        checkDir(pathSource);
        checkDir(pathCopy);
        for (File file : listFiles) {
            try {
                Files.copy(file.toPath(), Paths.get((pathCopy + "/" + file.getName())), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error copy files from " + pathSource + " to " + pathCopy);
            }
        }

    }
}
