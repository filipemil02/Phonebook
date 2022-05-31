/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emil
 */
public class NrTel  {
    public String nr = "";
    public boolean isMobile = true;

    //constructor cu parametru nrTel
    public NrTel(String nrTel) throws Exception{
       
        if(validareNumar(nrTel)==true){
              this.nr = nrTel; 
        }
        else
            throw new Exception("Numarul de telefon este gol/invalid!");
        
    }

    //metoda validare numar telefon
    private boolean validareNumar(String nrTel) {
        
        //verificam ca nu este gol
        if(nrTel!=null && !"".equals(nrTel)){
            //verificam ca nrTel contine doar numere
            String regexNr = "^[0-9]*$";
            if(!nrTel.matches(regexNr)){
                //daca nu contine doar numere, nu este numar corect
                return false;
            }
            this.isMobile = isNrTelMobile(nrTel);
            //numar valid
            return true;
        }
        //numar invalid
        else return false;        
    }

    private boolean isNrTelMobile(String nrTel) {
        String regexStr = "^[0-9]{10}$";
        if(nrTel.matches(regexStr) && nrTel.startsWith("07")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.nr;
    }

}
