package com.mwerner.mycalcfinance2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends ListActivity {
	
	String[] menuchoices={"Present Value", "Future Value"};
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       setListAdapter(new ArrayAdapter<String>(
    		   this,
    		   android.R.layout.simple_list_item_1,
    		   getResources().getStringArray(R.array.menuchoices)
    		   ));
        
    }
    
    @Override
    public void onListItemClick(ListView parent, View view, int position, long id) {
    	String choice = ((TextView) view).getText().toString();
    	   if ( choice.equals("Present Value")){startActivity(new Intent(Main.this, PresentValue.class));}
    	   if ( choice.equals("Future Value")){startActivity(new Intent(Main.this, FutureValue.class));}
    	   if ( choice.equals("Bond Pricing")){startActivity(new Intent(Main.this, BondPricing.class));}
       } //end of onclicklistener       
    
  
}
