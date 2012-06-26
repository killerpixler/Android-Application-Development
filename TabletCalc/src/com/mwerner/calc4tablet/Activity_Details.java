package com.mwerner.calc4tablet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class Activity_Details extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		int id = extras.getInt(Intent.EXTRA_TEXT);

		switch (id) {
		case 0:
			Fragment frag = new Fragment_PV();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	 		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft.replace(R.id.details1, frag);
	 		ft.commit();			
	 		break;

		default:
			break;
		}
	}
}
