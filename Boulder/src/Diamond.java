/**
 * Created by UGO on 20/06/2017.
 */
public class Diamond extends Block {
    public Diamond(int id, int x, int y) {
        super(id, x, y);
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
