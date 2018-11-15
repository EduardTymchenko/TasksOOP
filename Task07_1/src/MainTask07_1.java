public class MainTask07_1 {
    public static void main(String[] args) {
        Port port = new Port();
        try {
            port.shipManagement();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
