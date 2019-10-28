package mainPackage;

import framesPackage.FrameRanking;
import framesPackage.LoginTela;
import java.io.IOException;

public class Main extends ReadSheet {

    public static void main(String[] args) throws IOException {

        //FRAME DE RANKING
        FrameRanking fr = new FrameRanking();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        //LoginTela lt = new LoginTela();
        //lt.setLocationRelativeTo(null);
        //lt.setVisible(true);
    }

}
