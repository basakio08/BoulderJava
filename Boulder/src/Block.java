import java.awt.*;
import java.util.ArrayList;

/**
 * Created by UGO on 19/06/2017.
 */
public class Block {

    int x;
    int y;
    int id;

    public Block(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void tick(int i, ArrayList<Block> tabObject) {

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
