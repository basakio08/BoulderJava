import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by UGO on 13/06/2017.
 */
public class BDD {
    private String BDD;
    private String ip;
    private String nmBDD;
    private String identifiant;
    private String mdp;
    private String adrsDeCo;
    private Connection conn;
    private Statement state;
    private ResultSet result;
    private Statement stmt;

    public BDD(String aBDD, String aip, String anmBDD, String aidentifiant, String amdp) {
        this.BDD = aBDD;
        this.ip = aip;
        this.nmBDD = anmBDD;
        this.identifiant = aidentifiant;
        this.mdp = amdp;
        this.adrsDeCo = "jdbc:" + aBDD + "://" + aip + "/" + anmBDD;


    }

    public void Connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(adrsDeCo, identifiant, mdp);
        state = conn.createStatement();
        stmt = conn.createStatement();

    }

    public void CréerTable(String nom, String caca[]) throws SQLException {
        String tab[][] = new String[caca.length / 2 + 1][2];
        System.out.print("    ");
        try {
            for (int i = 0; i < caca.length; i++) {
                if (i == 0) {
                    tab[0][0] = caca[0];
                } else {
                    if (i % 2 == 0) {
                        tab[(i / 2)][0] = caca[i];
                    }
                    if (i % 2 != 0) {
                        tab[i / 2][1] = caca[i];
                    }
                }
            }
        } catch (Exception e) {
        }

        stmt.executeUpdate("CREATE TABLE " + nom + " (test int)");
        try {

            for (int i = 0; tab[i][0] != null; i++) {
                stmt.executeUpdate("ALTER TABLE " + nom + " ADD " + tab[i][0] + " " + tab[i][1]);
            }
            stmt.executeUpdate("ALTER TABLE " + nom + " DROP test");
        } catch (Exception e) {
            stmt.executeUpdate("DROP TABLE " + nom);
            System.out.print("la syntaxe des paramettre est invalide, pensez a ne pas mettre d'espace dans vos colone et a bien mettre les type de donnée");
        }
    }

    public String getValeur(String table, String colone, String ligne, int quelLigne) throws SQLException {
        ResultSet er = state.executeQuery("SELECT " + colone + " FROM " + table + " WHERE " + ligne + " = " + quelLigne);
        er.next();
        return er.getObject(1).toString();
    }

    public void afficheTTLaMap(int nom) throws SQLException {
        ArrayList l = getTMap(nom);
        for (int i = 1; i < l.size(); i++) {
            System.out.print(l.get(i) + "\t |");
        }
    }


    public ArrayList getTMap(int nom) throws SQLException {
        ArrayList arl = new ArrayList();
        int iint = 0;
        result = state.executeQuery("{call Select_map(" + nom + ")}");



        while (result.next()) {

            ResultSetMetaData resultMeta = result.getMetaData();
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                iint++;
                arl.add(result.getObject(i).toString());
            }

        }


        return arl;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getState() {
        return state;
    }

    public void setState(Statement state) {
        this.state = state;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public String toString() {
        String tostringg = "cette base de donnée a pour ip : " + ip + "elle utilise : " + BDD + " la base de donnée a pour nom: " + nmBDD + " l'identifiant est :" + identifiant + " et le mot de passe est :" + mdp + " l'adresse final est :" + adrsDeCo;
        return tostringg;
    }

    public String getBDD() {
        return BDD;
    }

    public void setBDD(String BDD) {
        this.BDD = BDD;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNmBDD() {
        return nmBDD;
    }

    public void setNmBDD(String nmBDD) {
        this.nmBDD = nmBDD;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdrsDeCo() {
        return adrsDeCo;
    }

    public void setAdrsDeCo(String adrsDeCo) {
        this.adrsDeCo = adrsDeCo;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
