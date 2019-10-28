
package pseudomacro;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PseudoMacro {
    public static void main(String[] args) {
        try {
            ReadSheet.readTable();
        } catch (IOException ex) {
            Logger.getLogger(PseudoMacro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
