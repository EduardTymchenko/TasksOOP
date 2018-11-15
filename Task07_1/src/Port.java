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

    public void shipManagement() throws InterruptedException {
        Thread thread;
        while (!emptyShips(arrayShips)) {
            for (int i = 0; i < arrayShips.length; i++) {
                if (arrayShips[i] != null) {
                    for (Doc doc : arrayDocs) {
                        if (doc.isFree()) {
                            doc.setShip(arrayShips[i]);
                            thread = new Thread(doc);
                            thread.start();
                            thread.join();
                            arrayShips[i] = null;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("All ships unloaded");
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
