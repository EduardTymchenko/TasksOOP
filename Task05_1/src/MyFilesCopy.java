import java.io.*;

public class MyFilesCopy {

    public void copyFiles(String sourcePath, String receiverPath, String... extensions){
        File dirSource = new File("Task05_1/" + sourcePath);
        File dirReceiver = new File("Task05_1/" + receiverPath);
        FilenameFilter fileFilter = new FilenameFilter() {
            private String[] extArray = extensions;
            @Override
            public boolean accept(File dir, String name) {
                int index = name.lastIndexOf(".");
                if (index == -1) return false;
                String ext = name.substring(index + 1);
                return checkExtension(ext);
            }
            private boolean checkExtension(String ext) {
                for (String stringExt : extArray) {
                    if (stringExt.equals(ext)) return true;
                }
                return false;
            }
        };
        if (dirSource.isDirectory()) {
            String[] fileNames = dirSource.list(fileFilter);
            if (dirReceiver.isDirectory()){
                for (String filename : fileNames) {
                    System.out.println(filename); // for control
                    try (InputStream original = new BufferedInputStream(new FileInputStream(dirSource + "/" + filename));
                         OutputStream copyFile = new BufferedOutputStream(new FileOutputStream(dirReceiver + "/" + filename))){
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = original.read(buffer)) > 0) {
                            copyFile.write(buffer, 0, length);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println("Such Receiver does not exist!");
            }
        }else{
            System.out.println("Such Source does not exist!");
        }
    }
}
