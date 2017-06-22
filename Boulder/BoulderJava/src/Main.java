import javax.swing.*;
import java.sql.SQLException;


public class Main
{
    public static Scene scene;
    public static int width=960;
    public static int height=960;
    public static void main(String argc[]) throws SQLException, ClassNotFoundException {
            JFrame fen = new JFrame("BoudlerDash");
            fen.setSize(width+18,height+45);
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fen.setLocationRelativeTo(null);
            fen.setResizable(true);
            fen.setAlwaysOnTop(true);
            fen.repaint();
            scene = new Scene();
            fen.setContentPane(scene);
            fen.setVisible(true);
    }
}
