import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask112 {
    public static void main(String[] args) {

        MyServer myServer = new MyServer(9999);
        myServer.startServer();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command;
        do {
            System.out.println("To stop the server enter - exit: ");
            try {
                command = br.readLine();
                if (command.equalsIgnoreCase("exit")) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
        myServer.stopServer();
    }
}
