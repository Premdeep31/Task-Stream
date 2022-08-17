package com.locker.Locker;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entities.Customer;
import com.entities.Locker;
import com.util.HibernateUtil;

public class App {
    public static void main( String[] args ) throws ParseException {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
    	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
    	
    	Locker locker = new Locker();
    	locker.setLockerId("LOC101");
    	locker.setLockerType("Small");
    	locker.setRent(1100);
    	
    	Customer customer = new Customer();
    	customer.setCustomerName("William");
    	customer.setDateOfBirth(formatter.parse("17-05-1995"));
    	customer.setAddress("Kolkata");
    	customer.setPhoneNo(9067767872l);
    	customer.setLockerId(locker);
    	
    	Session session = sf.openSession();
		session.beginTransaction();
		session.save(customer);
		session.save(locker);
		session.getTransaction().commit();
		session.close();
    	
    }
}
