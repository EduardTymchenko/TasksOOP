import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainTask111 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Task11_1/listSites.txt"))) {
            InetAddress inetAddress;
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    inetAddress = InetAddress.getByName(line.trim());
                    System.out.println("Site " + inetAddress + " available");
                } catch (UnknownHostException ei) {
                    System.out.println("Site " + ei.getMessage() + " NOT available");
                }
            }
        } catch (IOException e) {
            System.out.println("Error read file: " + e.getMessage());
            System.exit(1);
        }
    }
}
