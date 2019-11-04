package mainPackage;

import connectionsPackage.EscolaDAO;
import framesPackage.FrameRanking;
import framesPackage.LoginTela;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main extends ReadSheet {

    public static void main(String[] args) throws IOException, Exception {

//        String str = "5,33";
//        str = str.replaceAll(",",".");
//        float f = Float.parseFloat(str);
//        System.out.println(str);

        //false lê anos iniciais, true lê anos finais
        //ReadSheet.readTableIniFin(false);
//        Escola escola = new Escola();
//        EscolaDAO escolaDAO = new EscolaDAO();
//        
//        escola.setID_ESC(11024666);
//        escola.setRANK_ESC(1);
//        escola.setNOME_ESC("EMEIEF BOA ESPERANCA");
//        escola.setMED_INI((float)00.00);
//        escola.setMED_FIN((float)00.00);
//        escola.setMED_MED((float)00.00);
//        escola.setMED_IDEB((float)00.00);
//        
//        escolaDAO.create(escola);
//FRAME DE RANKING
        FrameRanking fr = new FrameRanking();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
//        LoginTela lt = new LoginTela();
//        lt.setLocationRelativeTo(null);
//        lt.setVisible(true);
    }

}
