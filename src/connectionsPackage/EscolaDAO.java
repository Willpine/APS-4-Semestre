package connectionsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainPackage.Escola;

public class EscolaDAO {

    public void createMed(Escola esc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESCOLA_MED "
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_MED,IDEB_MED)"
                    + " VALUES (?,?,?,?,?)");

            stmt.setInt(1, esc.getID_ESC());
            stmt.setInt(2, esc.getRANK_ESC());
            stmt.setString(3, esc.getNOME_ESC());
            stmt.setFloat(4, esc.getMED_MED());
            stmt.setFloat(5, esc.getMED_IDEB());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void createIni(Escola esc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESCOLA_INI "
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_INI,IDEB_INI)"
                    + " VALUES (?,?,?,?,?)");

            stmt.setInt(1, esc.getID_ESC());
            stmt.setInt(2, esc.getRANK_ESC());
            stmt.setString(3, esc.getNOME_ESC());
            stmt.setFloat(4, esc.getMED_INI());
            stmt.setFloat(5, esc.getMED_IDEB());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void createFin(Escola esc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESCOLA_FIN "
                    + "(ID_ESC,RANK_ESC,NOME_FIN,MED_FIN,IDEB_FIN)"
                    + " VALUES (?,?,?,?,?)");

            stmt.setInt(1, esc.getID_ESC());
            stmt.setInt(2, esc.getRANK_ESC());
            stmt.setString(3, esc.getNOME_ESC());
            stmt.setFloat(4, esc.getMED_FIN());
            stmt.setFloat(5, esc.getMED_IDEB());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Escola> readMed(int tipo) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Escola> escolas = new ArrayList();
        String ensino = null;
        String ordem = "DESC";
        switch(tipo){
            case 1:ensino = "NOME_ESC";ordem="ASC";break;
            case 2:ensino = "MED_INI";break;
            case 3:ensino = "MED_FIN";break;
            case 4:ensino = "MED_MED";break;
            case 5:ensino = "IDEB_INI";break;
            case 6:ensino = "IDEB_FIN";break;
            case 7:ensino = "IDEB_MED";break;
            
        }

        try {
            stmt = con.prepareStatement("SELECT NOME_ESC,MED_INI,MED_FIN,MED_MED,IDEB_INI,IDEB_MED,IDEB_FIN\n"
                    + "FROM ESCOLA_INI\n"
                    + "LEFT JOIN ESCOLA_FIN\n"
                    + "ON ESCOLA_INI.ID_ESC = ESCOLA_FIN.ID_ESC\n"
                    + "LEFT JOIN ESCOLA_MED\n"
                    + "ON ESCOLA_INI.ID_ESC = ESCOLA_MED.ID_ESC\n"
                    + "ORDER BY "+ensino+" "+ordem);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setNOME_ESC(rs.getString("NOME_ESC"));
                escola.setMED_INI(rs.getFloat("MED_INI"));
                escola.setMED_FIN(rs.getFloat("MED_FIN"));
                escola.setMED_MED(rs.getFloat("MED_MED"));
                escola.setINI_IDEB(rs.getFloat("IDEB_INI"));
                escola.setFIN_IDEB(rs.getFloat("IDEB_FIN"));
                escola.setMED_IDEB(rs.getFloat("IDEB_MED"));

                escolas.add(escola);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return escolas;
    }

    public List<Escola> readCod() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Escola> escolas = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT ID_ESC,NOME_ESC\n"
                    + "FROM ESCOLA_INI\n"
                    + "ORDER BY NOME_ESC DESC;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setNOME_ESC(rs.getString("NOME_ESC"));
                escola.setID_ESC(rs.getInt("ID_ESC"));

                escolas.add(escola);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return escolas;
    }
}
