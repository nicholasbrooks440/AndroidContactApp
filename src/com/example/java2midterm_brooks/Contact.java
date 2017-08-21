/*
 * Java2Midterm_Brooks
   Midterm Project: Contact Class
   March 6, 2014
   Java 2
 */
package com.example.java2midterm_brooks;

public class Contact 
{
	private String Name;
	private String Phone;
	private String Email;
	
	//Constructor taking three arguments
	public Contact (String aName, String aPhone, String aEmail)
	{
		Name = aName;
		Phone = aPhone;
		Email = aEmail;
	}
	//Get Methods
	public String getName()
	{
		return Name;
	}
	public String getPhone()
	{
		return Phone;
	}
	public String getEmail()
	{
		return Email;
	}
}
