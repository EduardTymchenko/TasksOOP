public class Ship {
    private String nameShip;
    private int numberBoxes = 10;

    public Ship(String nameShip) {
        this.nameShip = nameShip;
    }

    public String getNameShip() {
        return nameShip;
    }

    public int getNumberBoxes() {
        return numberBoxes;
    }

    public void setNumberBoxes(int numberBoxes) {
        this.numberBoxes = numberBoxes;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "nameShip='" + nameShip + '\'' +
                ", numberBoxes=" + numberBoxes +
                '}';
    }
}
