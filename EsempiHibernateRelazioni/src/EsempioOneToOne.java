import hibernateUtility.HibernateUtility;
import model.Computer;
import model.Persona;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EsempioOneToOne {
	
	public static void main (String[] args){
		
        Session session=HibernateUtility.openSession();
		
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        
	            tx.begin();
	            
	            Computer c1 = new Computer();
	            Computer c2 = new Computer();
	            c1.setModello("HP");
	            c2.setModello("Asus");
	            
	            Persona p1 = new Persona();
	            p1.setNome("Luca");
	            p1.setCognome("Umoretto");
	            Persona p2 = new Persona();
	            p2.setNome("Martina");
	            p2.setCognome("Debernardi");
	            //p1.setComputer(c1);
	            p1.addComputer(c1);
	            p1.addComputer(c2);
	            
	            //c1.setPersona(p1);
	            //c2.setPersona(p1);
	            c1.addPersona(p1);
	            c1.addPersona(p2);
	            
	            
	            session.save(c1);
	            session.save(c2);
	            session.save(p1);
	            session.save(p2);
	            tx.commit(); 
	            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	}

}
