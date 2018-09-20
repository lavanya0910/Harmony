package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import model.accummodate;

public class accummodateDaoImpl implements accummodateDao  
{
	public boolean SaveorUpdate(accummodate r)
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
	public boolean Delete(accummodate R)
	{
//		session.ddelete(R);
		return true;
	}
	public accummodate get(String id)
	{
		accummodate u=null;
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from accummodate where Register_id='"+id+"'");
			 u = (accummodate)query.uniqueResult();
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
	public accummodate getemail(String email)
	{
		accummodate u=null;
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from accummodate where email='"+email+"'");
			 u = (accummodate)query.uniqueResult();
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
	public List<accummodate> Li()
	{
		 List<accummodate> list = new ArrayList<accummodate>();
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 try 
		 {
		 tx = session.getTransaction();
		 tx.begin();
		 list = session.createQuery("from accummodate").list(); 
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
