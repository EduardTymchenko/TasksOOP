import java.time.LocalDateTime;

public class Doc implements Runnable{
    private boolean free = true;
    private String docNumber;
    private Ship ship;

    public Doc(String docNumber) {
        this.docNumber = docNumber;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public  void run() {
        for (int i = ship.getNumberBoxes(); i > 0 ; ){
            try {
                Thread.sleep(500);
                i--;
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        System.out.println(ship.getNameShip() + " unloaded in doc " + docNumber + " " + LocalDateTime.now());
        ship = null;
        free = true;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "free=" + free +
                ", docNumber='" + docNumber + '\'' +
                '}';
    }
}
