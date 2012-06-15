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

public class Present_value extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.present_value);
		
		
		
		Button calc = (Button) findViewById(R.id.pv_button_calc);
		
		//clickhandler
		calc.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				EditText fv = (EditText) findViewById(R.id.pv_input_fv);
				EditText r = (EditText) findViewById(R.id.pv_input_r);
				EditText n = (EditText) findViewById(R.id.pv_input_n);
				EditText t = (EditText) findViewById(R.id.pv_input_t);
				if (fv.getText().toString().equals("") ||
						r.getText().toString().equals("") ||
						n.getText().toString().equals("") ||
						t.getText().toString().equals("")) {					
					Toast errormsg = Toast.makeText(Present_value.this, "Error! You need to input numbers in all fields!", 5000);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				}
				//calculation beginn
				else {
					 double fv1 = Double.parseDouble(fv.getText().toString());
					 double r1 = Double.parseDouble(r.getText().toString());
					 double n1 = Double.parseDouble(n.getText().toString());
					 double t1 = Double.parseDouble(t.getText().toString());
					 double answer1 = fv1/(Math.pow(1+(r1/n1) ,n1*t1 ));
					 answer1 = (double)(Math.round(answer1*100))/100;
					TextView answer = (TextView) findViewById(R.id.pv_answer);
					answer.setText(""+answer1);
					
				}
				//calculation end				
			}			
		});
		//clickhandler end
		Button clear = (Button) findViewById(R.id.pv_button_clear);
		
		//clickhandler start
		clear.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				TextView answer = (TextView) findViewById(R.id.pv_answer);
				EditText fv = (EditText) findViewById(R.id.pv_input_fv);
				EditText r = (EditText) findViewById(R.id.pv_input_r);
				EditText n = (EditText) findViewById(R.id.pv_input_n);
				EditText t = (EditText) findViewById(R.id.pv_input_t);
				answer.setText("");
				fv.setText("");
				r.setText("");
				n.setText("");
				t.setText("");
				
			}
		});
		//clickhandler end
		
		
		
		
		
		
		
	}
	
}
