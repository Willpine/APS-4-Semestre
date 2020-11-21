package connectionsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainPackage.Aluno;
import mainPackage.Escola;

public class AlunoDAO {

    public void createAlu(Aluno alu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ALUNO "
                    + "(RA_ALU,NOME_ALU,ANO_ALU,SENHA_ALU,ID_ESC)"
                    + " VALUES (?,?,?,?,?)");

            stmt.setString(1, alu.getRA_ALU());
            stmt.setString(2, alu.getNOME_ALU());
            stmt.setString(3, alu.getANO_ALU());
            stmt.setString(4, alu.getSENHA_ALU());
            stmt.setInt(5, alu.getID_ESC());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean checkAluno(String ra_alu, String senha_alu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM ALUNO WHERE RA_ALU = ? AND SENHA_ALU = ?");
            stmt.setString(1, ra_alu);
            stmt.setString(2, senha_alu);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public String getNome(String ra_alu) {
        String nome = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT NOME_ALU FROM ALUNO WHERE RA_ALU = ?");
            stmt.setString(1, ra_alu);
            rs = stmt.executeQuery();
            if (rs.next()) {
                nome = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nome;
    }

    public int getEscId(String ra_alu) {
        int idEsc = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT ALUNO.ID_ESC\n"
                    + "FROM ALUNO\n"
                    + "LEFT JOIN ESCOLA_INI\n"
                    + "ON ALUNO.ID_ESC = ESCOLA_INI.ID_ESC\n"
                    + "WHERE RA_ALU = ?");
            stmt.setString(1, ra_alu);
            rs = stmt.executeQuery();
            if (rs.next()) {
                idEsc = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return idEsc;
    }
}
