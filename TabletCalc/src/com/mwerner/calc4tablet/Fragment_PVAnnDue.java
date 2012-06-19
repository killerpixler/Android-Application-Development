package com.mwerner.calc4tablet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_PVAnnDue extends Fragment {
	
	@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			return inflater.inflate(R.layout.fragment_pvanndue, container, false);
	}//oncreate ends

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		
		Button calc = 	(Button) getActivity().findViewById(R.id.pvanndue_calc);

		//clickhandler
				calc.setOnClickListener(new OnClickListener() {			
					public void onClick(View v) {
					EditText pv = (EditText) getActivity().findViewById(R.id.pvanndue_pv);
					EditText cf = (EditText) getActivity().findViewById(R.id.pvanndue_cf);
					EditText r = (EditText) getActivity().findViewById(R.id.pvanndue_r);
					EditText t = (EditText) getActivity().findViewById(R.id.pvanndue_t);
					
					TextView answer = (TextView) getActivity().findViewById(R.id.pv_answer);
					int emptyfieldss = 0;
					int choice = 0;
					if (pv.getText().toString().equals("")){
						emptyfieldss ++;
						choice = 1;
					}
					if (cf.getText().toString().equals("")){
						emptyfieldss ++;
						choice = 2;
					}
					if (r.getText().toString().equals("")){
						emptyfieldss ++;
						choice = 3;
					}
					if (t.getText().toString().equals("")){
						emptyfieldss ++;
						choice = 5;
					}
					if (emptyfieldss > 1){
						Toast errormsg = Toast.makeText(getActivity(), "Error! you left more than one field empty!", 5000);
						errormsg.setGravity(Gravity.CENTER, 0, 0);
						errormsg.show();
					}else{
					switch (choice) {
					case 1://pv
						double cf1 = Double.parseDouble(cf.getText().toString());
						double r1 = Double.parseDouble(r.getText().toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = cf1*((1-Math.pow(1+r1, t1))/r1)*(1+r1);
						result1 = (double)(Math.round(result1*100))/100;
						answer.setText("The Present Value of the cash flow is: "+result1);
						break;
					case 2://cf
						double pv2 = Double.parseDouble(pv.getText().toString());
						double r2 = Double.parseDouble(r.getText().toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = pv2/((1-Math.pow(1+r2, t2))/r2)*(1+r2);
						result2 = (double)(Math.round(result2*100))/100;
						answer.setText("The Future Value of the cash flow is: "+result2);
						break;
					case 3://r
						Toast error_pvannduer = Toast.makeText(getActivity(), "Sory, the interest rate cannot be calculated at this time", 5000);
						error_pvannduer.setGravity(Gravity.CENTER, 0, 0);
						error_pvannduer.show();
						break;
					case 4://t
						double pv4 = Double.parseDouble(pv.getText().toString());
						double cf4= Double.parseDouble(cf.getText().toString());
						double r4 = Double.parseDouble(r.getText().toString());
						double result4 =  ( Math.log(1/ ( 1- ((pv4*r4) / (cf4*(1+r4)) ) ) ) )/( Math.log( 1+r4 ) );
						result4 = (double)(Math.round(result4*100))/100;
						answer.setText("The number of years is: "+result4);
						break;
					default:
						Toast errormsg = Toast.makeText(getActivity(), "Error!", 5000);
						errormsg.setGravity(Gravity.CENTER, 0, 0);
						errormsg.show();
						break;
					}//switch ends
					}//else ends
					
						
								
					}			
				});
				//clickhandler end
		
	}//onActivityCreated ends
	
	
	
}//class ends
