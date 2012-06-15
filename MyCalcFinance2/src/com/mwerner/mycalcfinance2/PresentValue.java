package com.mwerner.mycalcfinance2;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PresentValue extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentvalue);
	Button calc = 	(Button) findViewById(R.id.pv_calculate);
	
	//clickhandler
			calc.setOnClickListener(new OnClickListener() {			
				public void onClick(View v) {
					EditText cf = (EditText) findViewById(R.id.pv_cashflow);
					EditText r = (EditText) findViewById(R.id.pv_discountrate);
					EditText n = (EditText) findViewById(R.id.pv_periods);
					EditText t = (EditText) findViewById(R.id.pv_years);
					if (cf.getText().toString().equals("") ||
							r.getText().toString().equals("") ||
							t.getText().toString().equals("") ||
							n.getText().toString().equals("")) {					
						Toast errormsg = Toast.makeText(PresentValue.this, "Error! You need to input numbers in all fields!", 5000);
						errormsg.setGravity(Gravity.CENTER, 0, 0);
						errormsg.show();
					}
					//calculation beginn
					else {
						 double cf1 = Double.parseDouble(cf.getText().toString());
						 double r1 = Double.parseDouble(r.getText().toString());
						 double n1 = Double.parseDouble(n.getText().toString());
						 double t1 = Double.parseDouble(t.getText().toString());
						 double answer1 = cf1/(Math.pow(1+(r1/n1) ,n1*t1 ));
						 answer1 = (double)(Math.round(answer1*100))/100;
						TextView answer = (TextView) findViewById(R.id.pv_answer);
						answer.setText("The present Value of the cash flow is: "+answer1);
						
					}
					//calculation end				
				}			
			});
			//clickhandler end
		
		//Custom Dialog Box	
		Button theory = (Button) findViewById(R.id.pv_info);
		theory.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Dialog d = new Dialog(PresentValue.this);
				d.setContentView(R.layout.pv_theory);
				d.setTitle("Present Value Theory");
				d.show();
				
			}
		});
		//Custom Dialog Box end
	}
	
}
