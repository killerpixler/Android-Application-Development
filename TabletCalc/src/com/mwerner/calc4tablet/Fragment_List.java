package com.mwerner.calc4tablet;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment_List extends ListFragment {

    boolean mDualPane;
    
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onActivityCreated(savedInstanceState);
    
    	//populate the list from strings.xml
    	
        setListAdapter(new ArrayAdapter<String>(
     		   getActivity(),
     		   android.R.layout.simple_list_item_1,
     		   getResources().getStringArray(R.array.menuchoices)
     		   ));
        
     // check to see if there are the frame layouts (i.e. is the device in landscape?
        View detailsFrame = getActivity().findViewById(R.id.content1);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
            
    }
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    	
    	int id2 = (int) id;
    	switch (id2) {
		case 0:
			Fragment frag0 = new Fragment_PV();
			Fragment frag01 = new Fragment_PV_Info();
    		FragmentTransaction ft = getFragmentManager().beginTransaction();
    		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    		ft.replace(R.id.content1, frag0);
    		ft.replace(R.id.content2, frag01);
    		ft.commit();
			break;
		case 1:
			Fragment frag1 = new Fragment_PVAnn();
			Fragment frag11 = new Fragment_PVAnn_Info();
 		   	FragmentTransaction ft1 = getFragmentManager().beginTransaction();
 			ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
 			ft1.replace(R.id.content1, frag1);
 			ft1.replace(R.id.content2, frag11);
 			ft1.commit();
 			break;
		case 2:
			Fragment frag2 = new Fragment_PVAnnDue();
			Fragment frag21 = new Fragment_PVAnnDue_Info();
	 		FragmentTransaction ft2 = getFragmentManager().beginTransaction();
	 		ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft2.replace(R.id.content1, frag2);
	 		ft2.replace(R.id.content2, frag21);
	 		ft2.commit();
	 		break;

		default:
			Toast t = Toast.makeText(getActivity(), "Error Default Break on selction", 10000);
			t.setGravity(Gravity.CENTER, 0, 0);
			t.show();
			break;
    	}

    }//list item click listener ends here
  
    			
    		
    		

    }

