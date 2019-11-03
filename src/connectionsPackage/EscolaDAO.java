package connectionsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mainPackage.Escola;

public class EscolaDAO {

    public void create(Escola esc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESCOLA "
                    + "(ID_ESC,RANK_ESC,NOME_ESC,MED_INI,MED_FIN,MED_MED,MED_IDEB)"
                    + " VALUES (?,?,?,?,?,?,?)");
            
            stmt.setInt(1, esc.getID_ESC());
            stmt.setString(2, Integer.toString(esc.getRANK_ESC()));
            stmt.setString(3, esc.getNOME_ESC());
            stmt.setFloat(4, esc.getMED_INI());
            stmt.setFloat(5, esc.getMED_FIN());
            stmt.setFloat(6, esc.getMED_MED());
            stmt.setFloat(7, esc.getMED_IDEB());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
