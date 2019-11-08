package mainPackage;

public class Sugestao {

    public String getNOME_ESC() {
        return NOME_ESC;
    }

    public void setNOME_ESC(String NOME_ESC) {
        this.NOME_ESC = NOME_ESC;
    }

    public String getNOME_ALU() {
        return NOME_ALU;
    }

    public void setNOME_ALU(String NOME_ALU) {
        this.NOME_ALU = NOME_ALU;
    }
    
    private String NOME_ESC;
    private String NOME_ALU;

    public int getID_SUG() {
        return ID_SUG;
    }

    public void setID_SUG(int ID_SUG) {
        this.ID_SUG = ID_SUG;
    }

    public String getSUG() {
        return SUG;
    }

    public void setSUG(String SUG) {
        this.SUG = SUG;
    }

    public String getDATA_SUG() {
        return DATA_SUG;
    }

    public void setDATA_SUG(String DATA_SUG) {
        this.DATA_SUG = DATA_SUG;
    }

    public String getRA_ALU() {
        return RA_ALU;
    }

    public void setRA_ALU(String RA_ALU) {
        this.RA_ALU = RA_ALU;
    }

    public int getID_ESC() {
        return ID_ESC;
    }

    public void setID_ESC(int ID_ESC) {
        this.ID_ESC = ID_ESC;
    }
    
    private int ID_SUG;
    private String SUG;
    private String DATA_SUG;
    private String RA_ALU;
    private int ID_ESC;
    

}
