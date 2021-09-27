package com.Hibernate.Table.Dao; 
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Hibernate.Table.Pojo.Annotation;
import com.Hibernate.Table.Pojo.AutoTablePojo;
public class AutoTableDao {

	public static void main(String[] args) {
		
		Configuration conref = new Configuration();
		conref.configure("Hibernate.cfg.xml");
		SessionFactory sfref = conref.buildSessionFactory();
		Session sref = sfref.openSession();
		Transaction tref = sref.beginTransaction();
		
		Annotation an= new Annotation();
		an.setId(1);
		an.setName("John");
		an.setLocation("Paris");
		sref.save(an);
		/*
		boolean state = true;
		int id1 = 0;
		
		System.out.println("1.)Login" + " \n" + "2.) Admin");
		Scanner scobj = new Scanner(System.in);
		int uoption = scobj.nextInt();
		
		if(uoption == 1) {
			System.out.println("Enter your email/username");
			String ename = scobj.next();
			System.out.println("Enter password:");
			String pass = scobj.next();
			
			Query qsref = sref.createQuery("select active,id from AutoTablePojo where email = :eref or name = :en and password = :pref");
			qsref.setParameter("eref", ename);
			qsref.setParameter("en", ename);
			qsref.setParameter("pref", pass);
			List lsref = qsref.list();
			Iterator itsref = lsref.iterator();
			while(itsref.hasNext()) {
				Object o[] = (Object[])itsref.next();
				state = (boolean) o[0];
				id1 =(int)o[1];
				
			}
			
			if(state == true) {
				System.out.println("1.)Update " + "\n" + "2.)Delete");
				int choice = scobj.nextInt();
				if(choice ==1) {
					System.out.println("Enter your age to update");
					int age = scobj.nextInt();
					Query quref = sref.createQuery("update from AutoTablePojo set age = :ref where id = :idref ");
					quref.setParameter("ref", age);
					quref.setParameter("idref", id1);
					quref.executeUpdate();
					System.out.println("value updated!");
					
				}
			
				if(choice == 2) {
					Query qdref = sref.createQuery("update from AutoTablePojo set active = :aref where id = :idref");
					qdref.setParameter("aref", false);
					qdref.setParameter("idref", id1);
					qdref.executeUpdate();
					System.out.println("your account id deactivated");
				}
				
			}
			if(state == false) {
				System.out.println("Your account is deactivated");
				System.out.println("Do you want to activate your account?");
				System.out.println("Enter your mobile number");
				int mobile = scobj.nextInt();
				Query qmref = sref.createQuery("select mobile from AutoTablePojo where id = :idref");
				qmref.setParameter("idref", id1);
				List lmref =qmref.list();
				int m = (int)lmref.get(0);
				if(mobile == m) {
					Query qdref = sref.createQuery("update from AutoTablePojo set active = :aref where id = :idref");
					qdref.setParameter("aref", true);
					qdref.setParameter("idref", id1);
					qdref.executeUpdate();
					System.out.println("your account is now activated");
				}
				else {
					System.out.println("Invalid details");
				}
			}
		}
			
		if(uoption == 2) {
	    	System.out.println("Enter username /email");
	    	String ename = scobj.next();7;
	    	String pass = scobj.next();
	    	Query aq = sref.createQuery("from AutoTablePojo where email = :eref or name = :en and password = :pr");
	    	aq.setParameter("eref", ename);
	    	aq.setParameter("en", ename);
	    	aq.setParameter("pr", pass);==
	    	if(ename.equals("admin") ||ename.equals("admin@123") && pass.equals("123")) {
	    	System.out.println("Admin Login successfully!");
	    	System.out.println("Welcome Admin - What operation would you like to perform?");
	    	System.out.println("1.)Active Users" + "\n" + "2.) Inactive users" + "\n" + "3.)Activate a user " + "\n" + "4.)Deactivate a user");
	    	System.out.println("Enter your option:");
	    	int opt = scobj.nextInt();
	    	Query qaref = sref.createQuery("select id, name, email, password, mobile from AutoTablePojo where isActive = :aref");
	    	if(opt ==1) {
	    		System.out.println("Following are the active users");
	    		qaref.setParameter("aref", true);
	    		List laref = qaref.list();
	    		Iterator iaref = laref.iterator();
	    		while(iaref.hasNext()) {
	    			Object o[] = (Object[])iaref.next();
					System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3] + " " + o[4]);
	    		}
	    		
	    	}
	    	if(opt == 2) {
	    		System.out.println("Following are the inactive users");
	    		qaref.setParameter("aref", false);
	    		List laref = qaref.list();
	    		Iterator iaref = laref.iterator();
	    		while(iaref.hasNext()) {
	    			Object o[] = (Object[])iaref.next();
					System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3] + " " + o[4]);
	    		}
	    		
	    	}
	    	if(opt == 3) {
	    		System.out.println("Enter an id to activate a user");
	    		int id = scobj.nextInt();
	    		Query qlref = sref.createQuery("select active from AutoTablePojo where id = :idf");
				qlref.setParameter("idf", id);
				List lmref =qlref.list();
				boolean a = (boolean)lmref.get(0);
				if(a == false) {
					Query qa = sref.createQuery("update  from AutoTablePojo set active = :ref where id = :id");
					qa.setParameter("ref", true);
					qa.setParameter("id", id);
					qa.executeUpdate();
					System.out.println("User is now activated");
				}
				if(a == true){
					System.out.println("The user you selected is already in active state!");
					
				}
	    	}
	    	
	    	if(opt == 4) {
	    		System.out.println("Enter an id to deactivate a user");
	    		int id = scobj.nextInt();
	    		Query qlref = sref.createQuery("select active from AutoTablePojo where id = :idf");
				qlref.setParameter("idf", id);
				List lmref =qlref.list();
				boolean a = (boolean)lmref.get(0);
				if(a == true) {
					Query qa = sref.createQuery("update  from AutoTablePojo set active = :ref where id = :id");
					qa.setParameter("ref", false);
					qa.setParameter("id", id);
					qa.executeUpdate();
					System.out.println("User is now deactivated");
				}
				if(a == false) {
					System.out.println("The user you selected is already in deactivate state");
				}
	    	}
	    	}
	    }*/
		tref.commit();
		sref.close();
		sfref.close();
		
		}
}
