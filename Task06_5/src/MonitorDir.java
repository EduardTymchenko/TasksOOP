import java.io.File;

public class MonitorDir implements Runnable {
    private String dirName;
    private Thread threadMonitor;

    public MonitorDir(String dirName) {
        this.dirName = "Task06_5/" + dirName;
        threadMonitor = new Thread(this);
        threadMonitor.setDaemon(true);
        threadMonitor.start();
    }

    @Override
    public void run() {
        File monitorDir = new File(dirName);
        String[] filesList = monitorDir.list();
        int current = filesList.length;
        int before = filesList.length;
        int delta;
        while (true) {
            if (!monitorDir.exists()) monitorDir.mkdir();
            filesList = monitorDir.list();
            current = filesList.length;
            delta = before - current;
            if (delta > 0) System.out.println("Deleted " + delta + " files to the directory " + dirName);
            if (delta < 0) System.out.println("Added " + Math.abs(delta) + " files to the directory " + dirName);
            if (delta == 0) System.out.println("No change  to the directory " + dirName);
            before = current;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
