

import java.awt.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
public class Agenda {
    
    public CriteriuOrdonare criteriuCurent = CriteriuOrdonare.DUPA_NUME;
    public ArrayList contactList = new ArrayList<Contact>();
    
    
    public void adaugareContact(Contact ct) throws Exception{
        
        //daca agenda este goala si avem primul contact
        if(this.contactList==null || this.contactList.isEmpty()){
            System.out.println("Primul contact adaugat!");
            if(ct!=null){
                contactList.add(ct);
            }
        }
        else {
            if(ct!=null){
                if(existsAlready(ct)) throw new Exception("Contactul exista deja");
                else{
                    contactList.add(ct);
                    System.out.println("Contact Added!");
                }
            }
        }
        
    }
    
    public void stergeContact(Contact ct){
        if(ct!=null && contactList!=null){
            if(!contactList.isEmpty() && contactList.contains(ct)){
                contactList.remove(ct);
                System.out.println("Contact Deleted!");
            }
        }
    }
    
    public void updateContact(Contact ct){
        if(ct!=null && contactList!=null){
            if(!contactList.isEmpty() && contactList.contains(ct)){
                contactList.add(ct);
                System.out.println("Contact updated!");
            }
        }
    }
    
    public ArrayList getContactList(){
        return this.contactList;
    }

    private boolean existsAlready(Contact ct) {
        System.out.println("Se verifica daca este dublura!");
        Contact lct;
        try{
            for(Object localCt : contactList){
                    lct = (Contact) localCt; 
                    if (lct.toString().equals(ct.toString())){
                        System.out.println("Exista deja!!");
                        return true;                  
                    }
            }
        }
        catch (Exception e){
            System.err.println("Error!" + e);
        }
        return false;
    }

    public CriteriuOrdonare getCriteriuCurent() {
        return criteriuCurent;
    }

    public void setCriteriuCurent(CriteriuOrdonare criteriuCurent) {
        this.criteriuCurent = criteriuCurent;
        
        sortAgenda(criteriuCurent);
    }

    public void setContactList(ArrayList contactList) {
        this.contactList = contactList;
    }

    
    private void sortAgenda(CriteriuOrdonare criteriuCurent) {
        System.out.println("in metoda sortAgenda!!");
        switch (criteriuCurent) {
            case DUPA_NUME: {
                                ArrayList localList = this.getContactList();
                            
                                Comparator<Contact> comp = (Contact a, Contact b) -> {
                                    return a.nume.compareToIgnoreCase(b.nume);
                                };

                                Collections.sort(localList, comp);
                            
//                                for(int i=0;i<localList.size();i++){
//                                    System.out.println("Lista sorata dupa nume! : " + localList.get(i));
//                                }
                                this.setContactList(localList);
                            
                                break;
                            }
            case DUPA_PRENUME:{
                                ArrayList localList = this.getContactList();
                            
                                Comparator<Contact> comp = (Contact a, Contact b) -> {
                                    return a.prenume.compareToIgnoreCase(b.prenume);
                                };

                                Collections.sort(localList, comp);
                            
//                                for(int i=0;i<localList.size();i++){
//                                    System.out.println("Lista sorata dupa prenume! : " + localList.get(i));
//                                }
                                this.setContactList(localList);
                            
                                break;
                            }
            case DUPA_DATA:{
                                ArrayList localList = this.getContactList();
                            
                                //scriem regula de comparare a datelor
                                Comparator<Contact> comp = (Contact a, Contact b) -> {
                                    String dateFormat = "dd.MM.yyyy";
                                    System.out.println("Data: " + a.getDataNasterii());
                                    System.out.println("format: " + dateFormat);
		
                                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                                    sdf.setLenient(false);
		
                                    try {
			
                                        //transformam datele in Date sa comparam corect
                                        Date date1 = sdf.parse(a.getDataNasterii());
                                        Date date2 = sdf.parse(b.getDataNasterii());
                                        System.out.println("Date comparate cu succes!");
                                        return date1.compareTo(date2);
		
                                    } catch (ParseException e) {
                                        System.out.println("Eroare parsare date: " + e);
                                        
                                    }
		    
                                    return a.dataNasterii.compareToIgnoreCase(b.dataNasterii);
                                };

                                Collections.sort(localList, comp);
                            
//                                for(int i=0;i<localList.size();i++){
//                                    System.out.println("Lista sorata dupa data! : " + localList.get(i));
//                                }
                                this.setContactList(localList);
                            
                                break;
                            }
            default:
                throw new AssertionError(criteriuCurent.name());
                    
                
        }
    }
    
}
