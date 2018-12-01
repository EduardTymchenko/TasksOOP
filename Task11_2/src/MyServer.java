import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class MyServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private int port;
    private Thread thread;

    public MyServer(int port) {
        this.port = port;
    }

    public void startServer() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port);
                    System.out.println("Server start");
                    int count = 0;
                    while (!isInterrupted()) {
                        try {
                            socket = serverSocket.accept();
                            System.out.println("Connection accepted. ");
                            count++;
                            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                            pw.println(getInfo());
                            pw.println("Request number is " + count);
                        } catch (IOException e){
                            System.out.println("Server stop");
                        } finally {
                           if (socket != null) socket.close();
                        }
                    }
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error Server socket: " + e.getMessage());
                }
            }
        };
        thread.start();
    }


    public void stopServer()  {
        thread.interrupt();
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error Server socket: " + e.getMessage());
        }
    }

    private String getInfo() {
        Properties p = System.getProperties();
        Runtime r = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();
        sb.append("Operating system: ");
        sb.append(p.getProperty("os.name"));
        sb.append("\r\n");
        sb.append("Version system: ");
        sb.append(p.getProperty("os.version"));
        sb.append("\r\n");
        sb.append("Operating system architecture: ");
        sb.append(p.getProperty("os.arch"));
        sb.append("\r\n");
        sb.append("Username: ");
        sb.append(p.getProperty("user.name"));
        sb.append("\r\n");
        sb.append("Java version: ");
        sb.append(p.getProperty("java.version"));
        sb.append("\r\n");
        sb.append("Maximum memory for Java VM: ");
        sb.append(r.maxMemory());
        sb.append("\r\n");
        sb.append("Total memory for Java VM: ");
        sb.append(r.totalMemory());
        sb.append("\r\n");
        sb.append("Free memory for Java VM: ");
        sb.append(r.freeMemory());
        sb.append("\r\n");
        return sb.toString();
    }
}
