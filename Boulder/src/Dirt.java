import com.sun.org.apache.xpath.internal.operations.Bool;

public class Dirt extends Block {
    public Dirt( int id,int x, int y) {
        super(id, x, y);

    }
    public void tick(){
        if (y== Main.scene.perso.getY() && x == Main.scene.perso.getX()){
            id = 0;
        }
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
