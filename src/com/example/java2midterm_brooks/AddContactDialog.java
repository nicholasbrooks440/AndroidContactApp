/*
 * Java2Midterm_Brooks
   Midterm Project: Add Contact Dialog
   March 6, 2014
   Java 2
 */
package com.example.java2midterm_brooks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AddContactDialog extends DialogFragment
{
	private EditText nameText;
	private EditText phoneText;
	private EditText emailText;
	private LayoutInflater inflater;
	private AlertDialog.Builder builder;
	private View rootView;
	
	// called when the DialogFragment is created
		public Dialog onCreateDialog(Bundle savedInstanceState)
		{
			// create the dialog builder
			builder = new AlertDialog.Builder(getActivity());     
			
			// Get the layout inflater object    
			inflater = getActivity().getLayoutInflater();    
			
			// Inflate and set the layout for the dialog     
			// Pass null as the parent view because its going in the dialog layout 
			rootView = inflater.inflate(R.layout.add_contact_dialog, null);
			builder.setView(rootView); 
		
			//Set title
			builder.setTitle("Add Contact");
			
			// set the negative button
			builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
			{                
				public void onClick(DialogInterface dialog, int id) 
				{   
					// Cancel the dialog.
					AddContactDialog.this.getDialog().cancel();  				
				}            
			 });
			
			//Set the positive button
			builder.setPositiveButton(R.string.create, new DialogInterface.OnClickListener() 
			{                
				public void onClick(DialogInterface dialog, int id) 
				{   
					//get the user name
					nameText = (EditText)rootView.findViewById(R.id.nameText);
					//get the phone
					phoneText = (EditText)rootView.findViewById(R.id.phoneText);
					//get the email
					emailText = (EditText)rootView.findViewById(R.id.emailText);
							
					//get textViews & convert them to strings
					String name  = nameText.getText().toString();
					String phone = phoneText.getText().toString();
					String email = emailText.getText().toString();
					
					// get the main activity so we can call the set method
					MainActivity ma = (MainActivity)getActivity();
				
					//Add the contact the array
					ma.addContact(name, phone, email);
				}            
			 });
			return builder.create();
		}
}
