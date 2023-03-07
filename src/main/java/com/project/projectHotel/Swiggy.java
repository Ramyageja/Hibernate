package com.project.ProjectHotel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*@Entity-------->create table using className
 *@DynamicUpdate---->No need to check all the attributes to update the value
 *@Column(name="HotelName",length=10,nullable=false)-->create column and change the name shopName to HotelName
 *@Id --->hotelId column act as primary key
 *@GeneratedValue(strategy = GenerationType.AUTO) --->primary key generate automatically
 */
@Entity
@DynamicUpdate
public class Swiggy {
	
	private static String NAME= "Ramya";
	private static String PASSWORD= "Ramya30";
	@Column(name="HotelName",length=10,nullable=false)
	private String shopName;
	@Column
	private String ownerName;
	private String location;
	private float rating;
	private String foodType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int hotelId;

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getHotelId() {
		return hotelId;
	}
	
	//if login is success it connected to db
	//otherwise it will print "USERNAME AND PASSWORD IS INVALID "
	public static void toCheckLogin(String username,String password,Swiggy hotelObj,int hotelId) {
		if(username.equals(NAME) && password.equals(PASSWORD)) {
			App.toConnect(hotelObj,hotelId);
		}
		else {
			System.out.println("USERNAME AND PASSWORD IS INVALID ");
		}
	}
	
	public static void toLogOut() {
		System.out.println("");
	}

	@Override
	public String toString() {
		return "HotelId= "+hotelId+"shopName=" + shopName + ", ownerName=" + ownerName + ", location=" + location
				+ ", rating=" + rating + ", foodType=" + foodType ;
	}

}



