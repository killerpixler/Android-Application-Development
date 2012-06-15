package com.mwerner.financecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Button to Present Value
        Button topv = (Button) findViewById(R.id.topv);
        topv.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Present_value.class));
			}
		});
        //Button to PV end
        //Button to Future Value
        Button tofv = (Button) findViewById(R.id.tofv);
        tofv.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Future_value.class));
				
			}
		});
        //Button to FV end
        //Button to PV Annuity
        Button toannuity = (Button) findViewById(R.id.toannuity);
        toannuity.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Present_value_annuity.class));
			}
		});
        //Button to PV annuity end
        //Button to Intererst Conversion start
        Button tointconv = (Button) findViewById(R.id.tointconv);
        tointconv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Interest_conversion.class));
			}
		});
        //Button to Interest Conversion end
      //Button to Bonds start
        Button tobonds = (Button) findViewById(R.id.tobond);
        tobonds.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Bonds.class));
			}
		});
        //Button to Bonds end
      //Button to Bonds start
        Button tostockgrowth = (Button) findViewById(R.id.tostockgrowth);
        tostockgrowth.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main.this, Stock_growth.class));
			}
		});
        //Button to Bonds end
    }
}