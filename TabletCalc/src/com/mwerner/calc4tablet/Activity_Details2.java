package com.mwerner.calc4tablet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Activity_Details2 extends FragmentActivity {
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	Bundle extras = getIntent().getExtras();
	String choice = extras.getString("infos");
	
    //String choice = getIntent().getExtras().getString("infos");	
	
	if(choice.equals("pv")){
		setContentView(R.layout.fragment_pv_info);
	}
	
	
}
}
