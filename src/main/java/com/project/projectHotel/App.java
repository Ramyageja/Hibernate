package com.project.ProjectHotel;


import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	private static Swiggy hotelObj=new Swiggy();
	private static Scanner scan=new Scanner(System.in);
	
	
	public static void toConnect(Swiggy hotelObj,int hotelId) {
    try {
			
			Configuration conf = new Configuration().configure().addAnnotatedClass(Swiggy.class);
			SessionFactory sessionFact = conf.buildSessionFactory(); 
			Session session = sessionFact.openSession();
			System.out.println("Enter the choice");
			int userChoice;
			do {
			userChoice=scan.nextInt();	
			switch(userChoice) {
			case 1:
			 createHotelDetails(session,hotelId);
			 break;
			case 2:
			 deleteById(session);
			 break;
			case 3:
			 updateById(session);
			 break;
			case 4:
			 display(hotelObj);
			 break;
			case 5:
				Swiggy.toLogOut();
				sessionFact.close();
				break;
			}
			}while(userChoice!=5);
		}
		catch(HibernateException obj) {
			System.out.println(obj);

		}
		catch(Exception expObj) {
			System.out.println(expObj);

		}
		
	}
	
	/*In main method we get username and password
	 *hotelObj.toCheckLogin(userName,password) method called*/
	public static void main( String[] args ) {
		System.out.println("Enter the username");
		String userName=scan.next();
		System.out.println("Enter the password");
		String password=scan.next();
		Swiggy.toCheckLogin(userName,password,hotelObj,hotelObj.getHotelId());		
	}

	private static void createHotelDetails(Session session,int hotelId) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getSwiggy());
		System.out.println("Restaurant details are created with id :"+hotelId);
		session.getTransaction().commit();
	}
	
	private static void deleteById(Session session)  {
		try {
		System.out.println("Enter the Id number to delete the hotel details");
		int hotelId=scan.nextInt();
		Swiggy delObj = session.get(Swiggy.class,+hotelId);

		if( delObj!= null) {
			session.beginTransaction();
			session.remove(delObj);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Restaraunt id doesnt exists..");

		}	
		}
		catch(Exception expObj) {
			System.out.println(expObj);
		}
	}
	
	private static void updateById(Session session) {
		System.out.println("Enter the Id number to update the hotel details");
		int hotelId=scan.nextInt();
		Swiggy updObj = session.get(Swiggy.class,+hotelId);

		if(updObj != null) {
			System.out.println("Enter the Restaurant location:");
			updObj.setLocation(scan.next());
			System.out.println("Enter the Restaurant foodType:");
			updObj.setFoodType(scan.next());
			session.beginTransaction();
			session.persist(updObj);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Restaraunt id doesnt found");

		}	
	}
	private static void displayById(Session session){
		System.out.println("Enter the Id number to view the hotel details");
		int hotelId=scan.nextInt();
		Swiggy viewObj = session.get(Swiggy.class,+hotelId);
		if(viewObj != null) {
			System.out.println(viewObj);
		}
		else {
			System.out.println("Restaraunt id doesnt exists..");

		}
	}
	private static void display(Swiggy hotelObj) {
		
		System.out.println(hotelObj);
		
	}
	
	private static Swiggy getSwiggy() {
		
		System.out.println("Enter the Restaurant name:");
		hotelObj.setShopName(scan.next());
		System.out.println("Enter the Restaurant owner name:");
		hotelObj.setOwnerName(scan.next());
		System.out.println("Enter the Restaurant rating:");
		hotelObj.setRating(scan.nextFloat());
		System.out.println("Enter the Restaurant location:");
		hotelObj.setLocation(scan.next());
		System.out.println("Enter the Restaurant foodType:");
		hotelObj.setFoodType(scan.next());
		return hotelObj;
	}
}

