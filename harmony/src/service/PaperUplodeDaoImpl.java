package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import hibernate.HibernateUtil;
import model.PaperUplode;
import model.accummodate;


public class PaperUplodeDaoImpl implements PaperUplodeDao
{




		public boolean SaveorUpdate(PaperUplode r)
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
		

			
		
		
		public boolean Delete(PaperUplode R)
		{
//			session.ddelete(R);
			return true;
		}
		
		public PaperUplode get(int id)
		{
			PaperUplode u=null;
			Session session = HibernateUtil.openSession();
			 boolean result = false;
			 Transaction tx = null;
			 try{
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("from PaperUplode where Register_id='"+id+"'");
				 u = (PaperUplode)query.uniqueResult();
//				 u.get
//				 tx.commit();
				 if(u!=null) 
			       result = true;
			      }
			  catch(Exception ex){
			 }finally{
				 session.close();
			 }
			 return u;
		}
//		public PaperUplode getemail(String email)
//		{
//			System.out.println(email);
//			PaperUplode u=null;
//			Session session = HibernateUtil.openSession();
//			 boolean result = false;
//			 Transaction tx = null;
//			 try{
//				 tx = session.getTransaction();
//				 tx.begin();
//				 Query query = session.createQuery("from PaperUplode where email='"+email+"'");
//				 u = (PaperUplode)query.uniqueResult();
////				 u.get
////				 tx.commit();
//				 if(u!=null) 
//			       result = true;
//			      }
//			  catch(Exception ex){
//			 }finally{
//				 session.close();
//			 }
//			 return u;
//		}
		
		 public List<PaperUplode> Li()
		{
			 List<PaperUplode> list = new ArrayList<PaperUplode>();
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;
			 try 
			 {
			 tx = session.getTransaction();
			 tx.begin();
			 list = session.createQuery("from PaperUplode").list(); 
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
		 public List<PaperUplode> Lis()
		 {
			 List<PaperUplode> list = new ArrayList<PaperUplode>();
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;
				 try{
					 tx = session.getTransaction();
					 tx.begin();
					 
					 list = session.createQuery("from PaperUplode where status='"+"Painding"+"'").list();
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
		 public List<PaperUplode> Liss()
		 {
			 List<PaperUplode> list = new ArrayList<PaperUplode>();
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;
				 try{
					 tx = session.getTransaction();
					 tx.begin();
					 
					 list = session.createQuery("from PaperUplode where status='"+"Approve"+"'").list();
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


