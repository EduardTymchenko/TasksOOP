import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class MainTask111 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Task11_1/listSites.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = "http://" + line;
                try {
                    URL url = new URL(line);
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    if (http.getResponseCode() >= 400) System.out.println("Site NOT available :" + http.getResponseCode());
                    else System.out.println("Site " + url + " available - code response " + http.getResponseCode());

                } catch (IOException e) {
                    System.out.println("Error connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error read file: " + e.getMessage());
            System.exit(1);
        }
    }
}
