public class Chrono implements Runnable {
 private int boucle =5;
    @Override
    public void run() {
        while (true){

        Main.scene.repaint();


            try {Thread.sleep(boucle);} catch (InterruptedException e) {}}

    }
}
