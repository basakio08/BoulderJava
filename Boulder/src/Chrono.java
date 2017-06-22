public class Chrono implements Runnable {
    private int boucle = 5;
    public int timer = 0;

    @Override
    public void run() {
        while (true) {
            Main.scene.repaint();
          //  Main.scene.deplacementOriz();
          //  Main.scene.deplacementVert();
            Main.scene.perso.Collision(Main.scene.tabObject);
            /*try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                this.chutDepierre();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            try {
                Thread.sleep(boucle);
            } catch (InterruptedException e) {
            }


        }

    }

    public void chutDepierre() throws InterruptedException {
        for (int i = 0; i < Main.scene.tabObject.size(); i++) {
            if (Main.scene.tabObject.get(i).getId() == 2  ) {
                if (Main.scene.tabObject.get(i + 30).getId() == 0) {
                    Main.scene.tabObject.set(i, new Empty(0, Main.scene.tabObject.get(i).getX(), Main.scene.tabObject.get(i).getY()));
                    Main.scene.tabObject.set(i + 30, new Stone(2, Main.scene.tabObject.get(i).getX() + 1, Main.scene.tabObject.get(i).getY()));
                }
            }
            if ( Main.scene.tabObject.get(i).getId() == 3) {
                if (Main.scene.tabObject.get(i + 30).getId() == 0) {
                    Main.scene.tabObject.set(i, new Empty(0, Main.scene.tabObject.get(i).getX(), Main.scene.tabObject.get(i).getY()));
                    Main.scene.tabObject.set(i + 30, new Diamond(3, Main.scene.tabObject.get(i).getX() + 1, Main.scene.tabObject.get(i).getY()));
                }
            }
        }
    }

}

