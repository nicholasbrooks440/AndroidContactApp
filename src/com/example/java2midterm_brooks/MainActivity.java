/*
 * Java2Midterm_Brooks
   Midterm Project: MainActivity Class
   March 6, 2014
   Java 2
 */
package com.example.java2midterm_brooks;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity 
{
	static //ARRAY List 
	ArrayList<Contact> contactList = new ArrayList<Contact>();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//add the contact to the ArrayList "contactList"
	public void addContact(String name, String phone, String email)
	{
	Contact object = new Contact(name,phone,email);
	contactList.add(object);
	}
	// Custom Dialog
	public void customDialogButtonOnClick(View v)
	{
		DialogFragment newFragment = new AddContactDialog();
		newFragment.show(getFragmentManager(), "Add Contact");
	}
	//list contacts button to display contacts in array list
	public void contactListOnClick(View v)
	{
		// create the intent to the second activity
		Intent listIntent = new Intent(this, List.class);
		
		//String Builder
		StringBuilder contactArray = new StringBuilder();
		
		//For each loop to get attributes
		for (Contact i : contactList) 
		{					
			contactArray.append("Name:" + i.getName() + 
			"\n" + "Phone:" + i.getPhone() +
			"\n" + "Email:" + i.getEmail()).append("\n");
		}
		//Convert String Builder to String & place in a object
		String arrayList = contactArray.toString();

		// put the data from the object in the intent
		listIntent.putExtra("contactsArray", arrayList);
		
		// start the activity 
		startActivity(listIntent);
	}
}