import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by UGO on 16/06/2017.
 */
public class Clavier implements KeyListener {
    Boolean keyPressed;
    int keyEvente;
    int timer=62;
    int a ;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    a=e.getKeyCode();
    switch (a){
        case KeyEvent.VK_RIGHT:
            Main.scene.setDx(-32);
            break;
        case KeyEvent.VK_LEFT:
            Main.scene.setDx(32);
            break;
        case KeyEvent.VK_UP:
            Main.scene.setDy(32);
            break;
        case KeyEvent.VK_DOWN:
            Main.scene.setDy(-32);


    }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Main.scene.setDx(-32);
                timer = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Main.scene.setDx(32);
                timer = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                Main.scene.setDy(32);
                timer = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Main.scene.setDy(-32);
                timer = 0;
            }



          timer++;



    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed=false;
        Main.scene.setDx(0);
        Main.scene.setDy(0);

    }
}
