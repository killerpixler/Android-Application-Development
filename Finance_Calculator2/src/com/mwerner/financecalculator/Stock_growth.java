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

public class Stock_growth extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.stock_growth);
		
	Button calc = (Button) findViewById(R.id.sg_calc);
	//ondclickhandler start for calc
	calc.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			EditText divt = (EditText) findViewById(R.id.sg_input_div0);
			EditText divn = (EditText) findViewById(R.id.sg_input_divn);
			EditText n = (EditText) findViewById(R.id.sg_input_n);
			//errormsg start
			if (divt.getText().toString().equals("") ||
					divn.getText().toString().equals("") ||
					n.getText().toString().equals(""))
			{
				Toast errormsg = Toast.makeText(Stock_growth.this, "Error! You need to input numbers in all fields!", 5000);
				errormsg.setGravity(Gravity.CENTER, 0, 0);
				errormsg.show();
			}
			//errormsg end
			//calc start
			else {
				 double divt1 = Double.parseDouble(divt.getText().toString());
				 double divn1 = Double.parseDouble(divn.getText().toString());
				 double n1 = Double.parseDouble(n.getText().toString());
				 double answer1 = Math.pow((divt1/divn1), (1/n1))-1;
				 answer1 = (double)(Math.round(answer1*100000))/100000;
				 
				TextView answer = (TextView) findViewById(R.id.sg_answer);
				answer.setText(""+answer1+" or "+answer1*100+"%");
			}
			//calc end
			
		}
	});
	//onclickhandler end for calc
	Button clear = (Button) findViewById(R.id.sg_clear); 
	//onclickhandler start for clear
	clear.setOnClickListener(new OnClickListener() {			
		public void onClick(View v) {
			TextView answer = (TextView) findViewById(R.id.sg_answer);
			EditText divt = (EditText) findViewById(R.id.sg_input_div0);
			EditText divn = (EditText) findViewById(R.id.sg_input_divn);
			EditText n = (EditText) findViewById(R.id.sg_input_n);
			answer.setText("");
			divt.setText("");
			divn.setText("");
			n.setText("");
			
			
		}
	});
	//onclickhandler end for clear
	
	
	
	}

}
