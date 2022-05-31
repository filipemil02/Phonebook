
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emil
 */
public class Filtre {
    public Map filtre = new HashMap<Double,String>();
    
    static double NR_MOBILE = 1;
    static double NR_FIXE = 2;
    static double DATA_AZI = 3;
    static double DATA_LUNA_CURENTA = 4;
    static double PERSONALIZAT = 5;
    static double FARA_FILTRE = 0;
    
    static String COD_SECRET = "112233";
    
    public Map getFiltre() {
        return filtre;
    }

    public void setFiltre(Map filtre) {
        this.filtre = filtre;
    }

    public Filtre() {
        filtre.put(FARA_FILTRE,"Fara Filtre");
        filtre.put(NR_MOBILE,"Doar Numere Mobile");
        filtre.put(NR_FIXE,"Doar Numere Fixe");
        filtre.put(DATA_AZI,"Data Nasterii Azi");
        filtre.put(DATA_LUNA_CURENTA,"Data Nasterii Luna curenta");
        filtre.put(PERSONALIZAT,"Personalizat");
    }
    
    
}
