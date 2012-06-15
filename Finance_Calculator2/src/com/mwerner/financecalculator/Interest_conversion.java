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

public class Interest_conversion extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interest_conversion);
		
		
		Button calc = (Button) findViewById(R.id.intcon_calc);
		//onclick for calc start
		calc.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				EditText rw = (EditText) findViewById(R.id.intconv_input_rw);
				EditText w = (EditText) findViewById(R.id.intcon_input_w);
				EditText y = (EditText) findViewById(R.id.intcon_input_y);
				//errormsg start
				if (rw.getText().toString().equals("") ||
						w.getText().toString().equals("") ||
						y.getText().toString().equals(""))
				{
					Toast errormsg = Toast.makeText(Interest_conversion.this, "Error! You need to input numbers in all fields!", 5000);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				}
				//errormsg end
				//calc start
				else {
					 double rw1 = Double.parseDouble(rw.getText().toString());
					 double w1 = Double.parseDouble(w.getText().toString());
					 double y1 = Double.parseDouble(y.getText().toString());
					 double answer1 = (
							 (Math.pow(1+(rw1/w1), w1/y1))	 -1)*y1;
					 answer1 = (double)(Math.round(answer1*100000))/100000;
					TextView answer = (TextView) findViewById(R.id.intcon_answer);
					answer.setText(""+answer1+" or "+answer1*100+"%");
				}
				//calc end
			}
		});
		//onclick for calc end
		
		
		Button clear = (Button) findViewById(R.id.intcon_clear);
		//onclick for clear start
		clear.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				TextView answer = (TextView) findViewById(R.id.intcon_answer);
				EditText w = (EditText) findViewById(R.id.intcon_input_w);
				EditText rw = (EditText) findViewById(R.id.intconv_input_rw);
				EditText y = (EditText) findViewById(R.id.intcon_input_y);
				answer.setText("");
				w.setText("");
				rw.setText("");
				y.setText("");
				
				
			}
		});
		//onclick for clear end
		
	}
}
