import java.io.File;

public class MultiThreadCopy {
    public static void copy(String sourceDir, String copyDir, int numberThreads) {
        ThreadCopy[] arrayThread = new ThreadCopy[numberThreads];
        File sourceDirFiles = new File("Task06_4/" + sourceDir);
        File[] listOfFiles = sourceDirFiles.listFiles();

        for (int i = 0; i < arrayThread.length; i++) {
            int sizeOfThread = Math.round((float) listOfFiles.length / numberThreads) ;
            int begin = i * sizeOfThread;
            int end = ((i + 1) * sizeOfThread);
            if (i == arrayThread.length - 1) end = listOfFiles.length;

            File[] listOfThread = new File[end - begin];
            System.arraycopy(listOfFiles,begin,listOfThread,0,end - begin);
            arrayThread[i] = new ThreadCopy(sourceDir, copyDir, listOfThread);
        }

    }
}
