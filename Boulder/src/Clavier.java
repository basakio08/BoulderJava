import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by UGO on 16/06/2017.
 */
public class Clavier implements KeyListener {
    int a;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        a = e.getKeyCode();
        switch (a) {
            case KeyEvent.VK_RIGHT:
                Main.scene.perso.lastposx = Main.scene.perso.x;
                Main.scene.perso.lastposy = Main.scene.perso.y;
                Main.scene.setDx(-32);


                break;
            case KeyEvent.VK_LEFT:
                Main.scene.perso.lastposx = Main.scene.perso.x;
                Main.scene.perso.lastposy = Main.scene.perso.y;
                Main.scene.setDx(32);
                //Main.scene.perso.A = 32;

                break;
            case KeyEvent.VK_UP:
                Main.scene.perso.lastposx = Main.scene.perso.x;
                Main.scene.perso.lastposy = Main.scene.perso.y;
                Main.scene.setDy(32);
               // Main.scene.perso.B = 32;

                break;
            case KeyEvent.VK_DOWN:
                Main.scene.perso.lastposx = Main.scene.perso.x;
                Main.scene.perso.lastposy = Main.scene.perso.y;
                Main.scene.setDy(-32);
                //Main.scene.perso.B = -32;


        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.setDx(0);
        Main.scene.setDy(0);

    }
}
