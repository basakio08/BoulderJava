import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by UGO on 16/06/2017.
 */
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
    private int xPerso;
    private int yPerso;
    private int dx;
    private int dy;
    public int timer=0;
    private int tab[][];
    private int test=-1;
    private ArrayList arl;
    public ArrayList<Block> tabObject = new ArrayList<Block>();
    BDD bdd;

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Scene() throws SQLException, ClassNotFoundException {
        super();
        bdd = new BDD("mysql", "5.135.194.4", "MAP1", "root", "root66");
        bdd.Connection();
        arl = bdd.getTMap(1);
        tab = new int[Main.height / 32][Main.width / 32];
        for (int i = 0; i < Main.height / 32; i++) {
            for (int j = 0; j < Main.width / 32; j++) {
                test++;
                switch (Integer.valueOf((String) arl.get(test)).intValue()){
                    case 1:
                        tabObject.add(new Dirt(1,i,j));
                        break;
                    case 2:
                        tabObject.add(new Stone(2,i,j));
                        break;
                    case 3:
                        tabObject.add(new Diamond(3,i,j));
                        break;
                    case 4:
                        tabObject.add(new Brick(4,i,j));
                        break;
                    case 5:
                        tabObject.add(new Door(5,i,j));
                        break;}



            }
        }
        this.xPerso = 64;
        this.yPerso = 64;
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
        this.yPerso -= this.dy;
    }

    public void deplacementOriz() {
        this.xPerso -= this.dx;
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
        this.deplacementVert();
        this.deplacementOriz();
        this.setDy(0);
        this.setDx(0);
        g2.drawImage(this.imgFond, 0, 0, null);
        test=1;
        for (int i = 0; i < Main.height / 32; i++) {
            for (int j = 0; j < (Main.width / 32); j++) {
                for (Block n : tabObject) {
                    switch (n.id){
                    case 0:
                        test++;
                        break;
                    case 1:
                        g2.drawImage(this.imgDirt, j * 32, i * 32, null);
                        test++;
                        break;
                    case 2:
                        g2.drawImage(this.imgStone, j * 32, i * 32, null);
                        test++;
                        break;
                    case 3:
                        g2.drawImage(this.imgDiams, j * 32, i * 32, null);
                        test++;
                        break;
                    case 4:
                        g2.drawImage(this.imgBrick, j * 32, i * 32, null);
                        test++;
                        break;
                    default:
                        test++;
                        //System.out.print(tab[i][j]);
                        break;

                }}

                g2.drawImage(this.imgPerso, xPerso, yPerso, null);

            }

        }
        if(dx == -32){
            System.out.print(dx);
        }
    }}