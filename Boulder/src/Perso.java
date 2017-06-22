import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Perso {
    int id, x, y, lastposx, lastposy;
    Image img;
    ImageIcon imgIco;
    int NbrDia;
    Block tempObject;

    public Perso(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        imgIco = new ImageIcon(getClass().getResource("/Pictures/Perso.png"));
        this.img = this.imgIco.getImage();
    }

    public void Collision(ArrayList<Block> tabObject) {
        for (int i = 0; i < tabObject.size(); i++) {
            if (tabObject.get(i).getX() * 32 == Main.scene.perso.y && tabObject.get(i).getY() * 32 == Main.scene.perso.x) {
                if (tabObject.get(i).getId() == 1) {
                    tabObject.get(i).setId(0);
                }
                if (tabObject.get(i).getId() == 4 || tabObject.get(i).getId() == 2) {

                    x = lastposx;
                    y = lastposy;

                }

            }/*
           tempObject = tabObject.get(i);
            if (tempObject.getId() == 3) {

                if (tempObject.getY() * 32 == Main.scene.perso.x) {
                    if (tempObject.getX() * 32 == Main.scene.perso.y) {
                        tabObject.remove(tempObject);
                        NbrDia = NbrDia + 1;

                    }
                }
            }*/
        }
    }

    public Image getImg() {
        return img;
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
