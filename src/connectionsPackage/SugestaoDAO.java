package connectionsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainPackage.Sugestao;

public class SugestaoDAO {

    public void createSug(Sugestao sug) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO SUGESTAO "
                    + "(SUG,DATA_SUG,RA_ALU,ID_ESC)"
                    + " VALUES (?,?,?,?)");

            stmt.setString(1, sug.getSUG());
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setString(3, sug.getRA_ALU());
            stmt.setInt(4, sug.getID_ESC());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(SugestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Sugestao> readSug() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sugestao> sugestoes = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT SUG, DATA_SUG, NOME_ALU,NOME_ESC\n"
                    + "FROM SUGESTAO\n"
                    + "LEFT JOIN ESCOLA_INI\n"
                    + "ON SUGESTAO.ID_ESC = ESCOLA_INI.ID_ESC\n"
                    + "LEFT JOIN ALUNO\n"
                    + "ON SUGESTAO.RA_ALU = ALUNO.RA_ALU");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Sugestao sugestao = new Sugestao();
                sugestao.setSUG(rs.getString("SUG"));
                sugestao.setDATA_SUG(rs.getString("DATA_SUG"));
                sugestao.setNOME_ALU(rs.getString("NOME_ALU"));
                sugestao.setNOME_ESC(rs.getString("NOME_ESC"));

                sugestoes.add(sugestao);

                System.out.println("Salvo com sucesso");
            }
            }catch (SQLException ex) {
            Logger.getLogger(SugestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return sugestoes;

    }
}

