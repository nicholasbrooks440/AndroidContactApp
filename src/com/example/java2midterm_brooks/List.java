/*
 * Java2Midterm_Brooks
   Midterm Project: List activity Class
   March 6, 2014
   Java 2
 */
package com.example.java2midterm_brooks;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class List extends Activity 
{
	private TextView listTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		// get the intent
		Intent intent = getIntent();
		
		// get the textView
		listTextView = (TextView)findViewById(R.id.listTextView); 
		
		//Set the TextView to the converted String Array
		listTextView.setText(intent.getStringExtra("contactsArray"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}
}
