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

public class Bonds extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.bonds);

	Button calc = (Button) findViewById(R.id.bonds_calc);
	
	//onlcick start calc
	calc.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			EditText cpr = (EditText) findViewById(R.id.bonds_input_cpr);
			EditText y = (EditText) findViewById(R.id.bonds_input_y);
			EditText t = (EditText) findViewById(R.id.bonds_input_t);
			EditText fv = (EditText) findViewById(R.id.bonds_input_fv);
			EditText n = (EditText) findViewById(R.id.bonds_input_n);
			//errormsg start
			if (cpr.getText().toString().equals("") ||
					t.getText().toString().equals("") ||
					y.getText().toString().equals("") ||
					n.getText().toString().equals("") ||
					fv.getText().toString().equals(""))
			{
				Toast errormsg = Toast.makeText(Bonds.this, "Error! You need to input numbers in all fields!", 5000);
				errormsg.setGravity(Gravity.CENTER, 0, 0);
				errormsg.show();
			}
			//errormsg end
			//calc start
			else {
				 double cpr1 = Double.parseDouble(cpr.getText().toString());
				 double y1 = Double.parseDouble(y.getText().toString());
				 double t1 = Double.parseDouble(t.getText().toString());
				 double fv1 = Double.parseDouble(fv.getText().toString());
				 double n1 = Double.parseDouble(n.getText().toString());
				 double answer1 =
						 	((fv1*cpr1)/n1 /   (y1/n1)) *
						 	(1-(1/Math.pow(1+(y1/n1), n1*t1))) +
						 	(fv1/(Math.pow(1+(y1/n1), n1*t1)));
				 answer1 = (double)(Math.round(answer1*100))/100;
				TextView answer = (TextView) findViewById(R.id.bonds_answer);
				answer.setText(""+answer1);
			}
			//calc end
		}
	});
	//onclick end calc
	Button clear = (Button) findViewById(R.id.bonds_clear);
	//onclick for clear start
	clear.setOnClickListener(new OnClickListener() {			
		public void onClick(View v) {
			TextView answer = (TextView) findViewById(R.id.bonds_answer);
			EditText cpr = (EditText) findViewById(R.id.bonds_input_cpr);
			EditText y = (EditText) findViewById(R.id.bonds_input_y);
			EditText t = (EditText) findViewById(R.id.bonds_input_t);
			EditText fv = (EditText) findViewById(R.id.bonds_input_fv);
			EditText n = (EditText) findViewById(R.id.bonds_input_n);
			answer.setText("");
			cpr.setText("");
			t.setText("");
			y.setText("");
			fv.setText("");
			n.setText("");
			
			
		}
	});
	//onclick for clear end

}
}
