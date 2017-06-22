import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Scene extends JPanel {
    private ImageIcon icoFond;
    private Image imgFond;
    private ImageIcon icoPerso;
    private Image imgPerso;
    private ImageIcon icoDirt;
    private Image imgDirt;
    private ImageIcon icoStone;
    private Image imgStone;
    private ImageIcon icoDiams;
    private Image imgDiams;
    private ImageIcon icoBrick;
    private Image imgBrick;
    public int dx;
    public int dy;
    private int test = -1;
    private ArrayList arl;
    Perso perso;
    public ArrayList<Block> tabObject = new ArrayList<Block>();
    BDD bdd;

    public Scene() throws SQLException, ClassNotFoundException {
        super();
        bdd = new BDD("mysql", "5.135.194.4", "MAP1", "root", "root66");
        bdd.Connection();
        arl = bdd.getTMap(3);
        perso = new Perso(10, 32, 32);
        for (int i = 0; i < Main.height / 32; i++) {
            for (int j = 0; j < Main.width / 32; j++) {
                test++;
                switch (Integer.valueOf((String) arl.get(test)).intValue()) {
                    case 0:
                        tabObject.add(new Empty(0,i,j));
                    case 1:
                        tabObject.add(new Dirt(1, i, j));
                        break;
                    case 2:
                        tabObject.add(new Stone(2, i, j));
                        break;
                    case 3:
                        tabObject.add(new Diamond(3, i, j));
                        break;
                    case 4:
                        tabObject.add(new Brick(4, i, j));
                        break;
                    case 5:
                        tabObject.add(new Door(5, i, j));
                        break;
                    case 6:
                        tabObject.add(new Empty(0,i,j));
                }


            }
        }
        System.out.print(test);

        System.out.print(tabObject.size());
        this.dx = 0;
        this.dy = 0;
        icoFond = new ImageIcon(getClass().getResource("/Pictures/Font.png"));
        this.imgFond = this.icoFond.getImage();
        icoPerso = new ImageIcon(getClass().getResource("/Pictures/Perso.png"));
        this.imgPerso = this.icoPerso.getImage();
        icoDirt = new ImageIcon(getClass().getResource("/Pictures/Dirt.png"));
        this.imgDirt = this.icoDirt.getImage();
        icoStone = new ImageIcon(getClass().getResource("/Pictures/Stone.png"));
        this.imgStone = this.icoStone.getImage();
        icoDiams = new ImageIcon(getClass().getResource("/Pictures/Diamond.png"));
        this.imgDiams = this.icoDiams.getImage();
        icoBrick = new ImageIcon(getClass().getResource("/Pictures/Brick.png"));
        this.imgBrick = this.icoBrick.getImage();


        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chrono = new Thread(new Chrono());
        chrono.start();

    }

    public void deplacementVert() {
        Main.scene.perso.setY(Main.scene.perso.getY() - Main.scene.dy);
    }

    public void deplacementOriz() {
        Main.scene.perso.setX(Main.scene.perso.getX() - Main.scene.dx);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        deplacementOriz();
        deplacementVert();
        this.setDy(0);
        this.setDx(0);
        g2.drawImage(this.imgFond, 0, 0, null);
        for (Block n : tabObject) {
            switch (n.id) {
                case 0:
                    //rien
                    break;
                case 1:
                    g2.drawImage(this.imgDirt, n.y * 32, n.x * 32, null);
                    break;
                case 2:
                    g2.drawImage(this.imgStone, n.y * 32, n.x * 32, null);
                    break;
                case 3:
                    g2.drawImage(this.imgDiams, n.y * 32, n.x * 32, null);
                    break;
                case 4:
                    g2.drawImage(this.imgBrick, n.y * 32, n.x * 32, null);
                    break;
            }
        }
        g2.drawImage(this.perso.getImg(), perso.x, perso.y, null);

        for(int i = 0; i < tabObject.size(); i++) {
            if (tabObject.get(i).getId() == 2) tabObject.get(i).tick(i, tabObject);
            if (tabObject.get(i).getId() == 3) tabObject.get(i).tick(i, tabObject);
        }
        /*Font fonte = new Font("TimesRoman ",Font.BOLD,22);
        g.setFont(fonte);
        g2.drawImage(this.imgDiams, 850, 0, null);
        g2.setColor(Color.black);
        g2.drawString( perso.NbrDia + "/12" , 900, 20);*/

    }
}