import java.io.File;
import java.io.IOException;

public class MultiThredCopyFile {
    public static void multiCopyFile(String fileNameSource, String fileNameCopy, int numberThreads) {
        String fileSourcePath = "Task07_2/" + fileNameSource;
        String fileCopyPath = "Task07_2/" + fileNameCopy;
        CopyFileBlock[] arrayBlocks = new CopyFileBlock[numberThreads];
        File fileSource = new File(fileSourcePath);

        prepareOutFile(fileCopyPath);
        long sizeBlock = Math.round((float) fileSource.length() / numberThreads);

        for (int i = 0; i < arrayBlocks.length; i++) {
            long begin = i * sizeBlock;
            long end = (i + 1) * sizeBlock;
            if (i == (arrayBlocks.length - 1)) end = fileSource.length();
            arrayBlocks[i] = new CopyFileBlock(fileSourcePath, fileCopyPath, begin, end, numberThreads);
        }
        for (int i = 0; i < arrayBlocks.length; i++) {
            try {
                arrayBlocks[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void prepareOutFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Output file does not create: " + e.getMessage());
            System.exit(1);
        }
    }

}
