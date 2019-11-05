package connectionsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mainPackage.Escola;

public class EscolaDAO {

    public void createMed(Escola esc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESCOLA_MED "
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_MED,MED_IDEB)"
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
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_INI,MED_IDEB)"
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
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_FIN,MED_IDEB)"
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
}
