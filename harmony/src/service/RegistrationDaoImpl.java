package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//import org.hibernate.Query;

import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.Registration;




public class RegistrationDaoImpl implements RegistrationDao
{
	public boolean SaveorUpdate(Registration r)
	{
		 Session session =HibernateUtil.openSession();
		 if(session.isConnected())
		 { 
		    Transaction tx = null;	
		    try 
		    {
			 tx = session.getTransaction();
			 tx.begin();
			 System.out.println(1212121212121l);
			 session.saveOrUpdate(r);		
			 tx.commit();
			} 
		 catch (Exception e) 
		    {
			 e.printStackTrace();
		     } 
		    finally 
		    {
			 session.close();
		 }
		}
		 return true;
		}
	

		
	
	
	public boolean Delete(Registration R)
	{
//		session.ddelete(R);
		return true;
	}
	
	public Registration get(int id)
	{
		Registration u=null;
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Registration where Register_id='"+id+"'");
			 u = (Registration)query.uniqueResult();
//			 u.get
//			 tx.commit();
			 if(u!=null) 
		       result = true;
		      }
		  catch(Exception ex){
		 }finally{
			 session.close();
		 }
		 return u;
	}
	public Registration getemail(String email)
	{
		System.out.println(email);
		Registration u=null;
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Registration where email='"+email+"'");
			 u = (Registration)query.uniqueResult();
//			 u.get
//			 tx.commit();
			 if(u!=null) 
		       result = true;
			 else 
				 result = false;
		      }
		 
		  catch(Exception ex){
		 }finally{
			 session.close();
		 }
		 return u;
	}
	
	 public List<Registration> Li()
	{
		 List<Registration> list = new ArrayList<Registration>();
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 try 
		 {
		 tx = session.getTransaction();
		 tx.begin();
		 list = session.createQuery("from Registration").list(); 
		 tx.commit();
		 } 
		 catch (Exception e) 
		 {
		 e.printStackTrace();
		 }
		 finally {
		 session.close();
		 }
		 return list;
	}

}
