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
            stmt.setString(3, alu.getNOME_ALU());
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
    
    public List<Aluno> readAlu() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList();

        try {
            stmt = con.prepareStatement("RA_ALU,NOME_ALU,NOME_ESC,ANO_ALU\n"
                    + "FROM ALUNO\n"
                    + "LEFT JOIN ESCOLA_INI\n"
                    + "ON ALUNO.ID_ESC = ESCOLA_INI.ID_ESC\n"
                    + "ORDER BY NOME_ALU DESC;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setRA_ALU(rs.getString("RA_ALU"));
                aluno.setNOME_ALU(rs.getString("NOME_ALU"));
                aluno.setNOME_ESC(rs.getString("NOME_ESC"));
                aluno.setANO_ALU(rs.getString("ANO_ALU"));

                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EscolaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunos;
    }
}
