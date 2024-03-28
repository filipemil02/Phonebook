
//import com.sun.xml.internal.fastinfoset.stax.events.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Emil
 */
public class Contact {
    String nume = "";
    String prenume = "";
    String dataNasterii = "";
    NrTel nrTel = null;

    //Constructor cu parametri
    public Contact(String nume, String prenume, String dataNasterii, NrTel nr) throws Exception{

        
            if(nume==null){
                throw new Exception("Campul Nume este invalid!");
            }
            else this.nume = nume;
            
            if(prenume==null){
                throw new Exception("Campul Prenume este invalid!");
            }
            else this.prenume = prenume;
            
            if(!validareDataNasterii(dataNasterii,"dd.MM.yyyy")){
                throw new Exception("Campul Data Nasterii este invalid! Nu respecta formatul sau a fost introdusa data de azi!");
            }
            else this.dataNasterii = dataNasterii;
            
            if(nr==null){
                throw new Exception("Campul Numar Telefon este invalid!");
            }
            else this.nrTel = nr;
        
        
    }

    //suprascriem metoda equals pentru a intoarce true
    //daca toate campurile din clasa Contact sunt egale
    @Override
    public boolean equals(Object ct){ 
        //ne asiguram ca obiectul de comparat nu este NULL
        if(ct!=null){
            //ne asiguram ca obiectul este de tip Contact
            if(ct instanceof Contact){
                //incepem comparatia
                Contact con = (Contact)ct;
                //comparam numele
                if(this.getNume()!=null && con.getNume()!=null){
                    if(!con.getNume().equalsIgnoreCase(this.nume)){
                        //daca numele difera, returnam false, clar obiectele sunt
                        //diferite, nu mai continuam executia
                       return false;
                    }
                }
                if(this.getPrenume()!=null && con.getPrenume()!=null){
                    if(!con.getPrenume().equalsIgnoreCase(this.prenume)){
                        return false;
                    }
                }
                if(this.getDataNasterii()!=null && con.getDataNasterii()!=null){
                    if(!con.getDataNasterii().equalsIgnoreCase(this.dataNasterii)){
                        return false;
                    }
                }
                if(this.getNrTel()!=null && con.getNrTel()!=null){
                    if(!con.getNrTel().equals(this.nrTel)){
                        return false;
                    }
                }
            }
        }
        else {
            //daca obiectul comparat este null, obiectele sunt egale
            //daca si valorile locale sunt toate NULL
            if(this.nume == null && this.prenume == null 
                    && this.dataNasterii == null && this.nrTel == null)
                return true;
        }
        //daca ajungem aici, inseamna ca n-am trecut prin nici un return
        //din cele de mai sus, deci obiectele sunt egale
        return true;
    }

    //suprascriem metoda toString
    @Override
    public String toString() {
        return "Contact{" + "nume=" + nume + ", prenume=" + prenume + ", dataNasterii=" + dataNasterii + ", nrTel=" + nrTel + '}';
    }
    
    
    
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public NrTel getNrTel() {
        return nrTel;
    }

    public void setNrTel(NrTel nrTel) {
        this.nrTel = nrTel;
    }

    public boolean validareDataNasterii(String dateToValidate, String dateFromat){
		System.out.println("Data: " + dateToValidate);
                System.out.println("format: " + dateFromat);
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		
		try {
			
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
                        Date today = new Date();
			System.out.println("Data introdusa" + date);
                        System.out.println("Data curenta" + new Date());
                        //verificam daca daca introdusa este data de azi
                        //si daca da, consideram invalid input-ul
                        if(date.getDate()==today.getDate() 
                                && date.getMonth() == today.getMonth()
                                && date.getYear() == today.getYear()){
                            return false;
                        }
		
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
    
    
}
