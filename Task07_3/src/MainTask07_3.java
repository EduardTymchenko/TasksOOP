import java.util.concurrent.ExecutionException;

public class MainTask07_3 {
    public static void main(String[] args) {
        try {
            System.out.println(MultiThreadSearchFile.searchFile("1.txt","Task07_3/testDir"));
        } catch (ExecutionException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}
