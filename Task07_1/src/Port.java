public class Port {
    Ship[] arrayShips = new Ship[3];
    Doc[] arrayDocs = new Doc[2];

    public Port() {
        createPort();
    }

    private void createPort() {
        for (int i = 0; i < arrayShips.length; i++) {
            arrayShips[i] = new Ship("Ship" + (i + 1));
        }
        for (int i = 0; i < arrayDocs.length; i++) {
            arrayDocs[i] = new Doc("Doc #" + (i + 1));
        }
    }

    public void shipManagement(){
        Thread thread;
        while (!emptyShips(arrayShips)) {
            for (int i = 0; i < arrayShips.length; i++) {
                if (arrayShips[i] != null) {
                    for (int j = 0; j < arrayDocs.length; j++) {
                        if (arrayDocs[j].isFree()) {
                            arrayDocs[j].setShip(arrayShips[i]);
                            arrayDocs[j].setFree(false);
                            thread = new Thread(arrayDocs[j]);
                            thread.start();
                            arrayShips[i] = null;
                            break;
                        }
                    }
                }
            }
        }
    }


    private boolean emptyShips(Ship[] ships) {
        boolean empty = true;
        for (Ship ship : ships) {
            if (ship != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }
}
