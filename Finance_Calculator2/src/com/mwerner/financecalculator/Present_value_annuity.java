package com.mwerner.financecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Present_value_annuity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.present_value_annuity);
		
		Button calc = (Button) findViewById(R.id.pvann_button_calc);
		//ondclickhandler start for calc
		calc.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				EditText pmt = (EditText) findViewById(R.id.pvann_input_pmt);
				EditText r = (EditText) findViewById(R.id.pvann_input_r);
				EditText n = (EditText) findViewById(R.id.pvann_input_n);
				//errormsg start
				if (pmt.getText().toString().equals("") ||
						r.getText().toString().equals("") ||
						n.getText().toString().equals(""))
				{
					Toast errormsg = Toast.makeText(Present_value_annuity.this, "Error! You need to input numbers in all fields!", 5000);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				}
				//errormsg end
				//calc start
				else {
					 double pmt1 = Double.parseDouble(pmt.getText().toString());
					 double r1 = Double.parseDouble(r.getText().toString());
					 double n1 = Double.parseDouble(n.getText().toString());
					 double answer1 = (pmt1/r1)*(1-(1/Math.pow(1+r1, n1)));
					 answer1 = (double)(Math.round(answer1*100))/100;
					TextView answer = (TextView) findViewById(R.id.pvann_answer);
					answer.setText(""+answer1);
				}
				//calc end
				
			}
		});
		//onclickhandler end for calc
		Button clear = (Button) findViewById(R.id.pvann_button_clear); 
		//onclickhandler start for clear
		clear.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				TextView answer = (TextView) findViewById(R.id.pvann_answer);
				EditText pmt = (EditText) findViewById(R.id.pvann_input_pmt);
				EditText r = (EditText) findViewById(R.id.pvann_input_r);
				EditText n = (EditText) findViewById(R.id.pvann_input_n);
				answer.setText("");
				pmt.setText("");
				r.setText("");
				n.setText("");
				
				
			}
		});
		//onclickhandler end for clear
		
	}
}
