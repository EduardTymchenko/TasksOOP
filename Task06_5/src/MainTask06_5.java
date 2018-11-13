import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask06_5 {
    public static void main(String[] args) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String exit = "";
        MonitorDir monitorDir = new MonitorDir("1");
        System.out.println("to exit enter - q");
        try {
            exit = sc.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end Main");
    }
}
