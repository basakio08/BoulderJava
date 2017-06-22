import java.util.ArrayList;

/**
 * Created by UGO on 20/06/2017.
 */
public class Diamond extends Block {
    private int timer;

    public Diamond(int id, int x, int y) {
        super(id, x, y);
        timer = 0;
    }

    public void tick(int i, ArrayList<Block> tabObject) {
        if (Main.scene.tabObject.get(i + 30).getId() == 0 && timer > 60) {
            this.timer = 0;
            if (Main.scene.tabObject.get(i + 30).getX() * 32 != Main.scene.perso.getY() || Main.scene.tabObject.get(i + 30).getY() * 32 != Main.scene.perso.getX()) {
                Main.scene.tabObject.set(i, new Empty(0, Main.scene.tabObject.get(i).getX(), Main.scene.tabObject.get(i).getY()));
                Main.scene.tabObject.set(i + 30, new Diamond(3, Main.scene.tabObject.get(i).getX() + 1, Main.scene.tabObject.get(i).getY()));

            }
        }

        this.timer++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
