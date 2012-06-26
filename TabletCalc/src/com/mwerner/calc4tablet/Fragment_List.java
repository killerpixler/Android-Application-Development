package com.mwerner.calc4tablet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



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
    		
		if(mDualPane && id == 0){
			Fragment frag0 = new Fragment_PV();
			Fragment frag01 = new Fragment_PV_Info();
    		FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
    		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    		ft.replace(R.id.content1, frag0);
    		ft.replace(R.id.content2, frag01);
    		ft.commit();
		}
		
		if(mDualPane && id == 1){
			Fragment frag1 = new Fragment_PVAnn();
			Fragment frag11 = new Fragment_PVAnn_Info();
 		   	FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
 			ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
 			ft1.replace(R.id.content1, frag1);
 			ft1.replace(R.id.content2, frag11);
 			ft1.commit();
 		}
		if(mDualPane && id == 2){
			Fragment frag2 = new Fragment_PVAnnDue();
			Fragment frag21 = new Fragment_PVAnnDue_Info();
	 		FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft2.replace(R.id.content1, frag2);
	 		ft2.replace(R.id.content2, frag21);
	 		ft2.commit();
		}
		if(mDualPane && id == 3){
			Fragment frag3 = new Fragment_FVAnn();
			Fragment frag31 = new Fragment_FVAnn_Info();
	 		FragmentTransaction ft3 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft3.replace(R.id.content1, frag3);
	 		ft3.replace(R.id.content2, frag31);
	 		ft3.commit();
		}
		if(mDualPane && id == 4){
			Fragment frag4 = new Fragment_FVAnnDue();
			Fragment frag41 = new Fragment_FVAnnDue_Info();
	 		FragmentTransaction ft4 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft4.replace(R.id.content1, frag4);
	 		ft4.replace(R.id.content2, frag41);
	 		ft4.commit();
		}
		if(mDualPane && id == 5){
			Fragment frag5 = new Fragment_Bonds();
			Fragment frag51 = new Fragment_Bonds_Info();
	 		FragmentTransaction ft5 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft5.replace(R.id.content1, frag5);
	 		ft5.replace(R.id.content2, frag51);
	 		ft5.commit();
		}
		if(mDualPane && id == 6){
			Fragment frag6 = new Fragment_Growth();
			Fragment frag61 = new Fragment_Growth_Info();
	 		FragmentTransaction ft6 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft6.replace(R.id.content1, frag6);
	 		ft6.replace(R.id.content2, frag61);
	 		ft6.commit();
		}
	 	if(mDualPane && id == 7){
			Fragment frag7 = new Fragment_NPV();
			Fragment frag71 = new Fragment_NPV_Info();
	 		FragmentTransaction ft7 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft7.replace(R.id.content1, frag7);
	 		ft7.replace(R.id.content2, frag71);
	 		ft7.commit();
	 	}
	 	//here is where the phone selection will be made work
	 	if(mDualPane == false && id == 0){
	 		/*
	 		Fragment frag = new Fragment_PV();
	 		FragmentTransaction ft0 = getActivity().getSupportFragmentManager().beginTransaction();
	 		ft0.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	 		ft0.replace(R.id.list, frag);
	 		*/
	 		Intent intent = new Intent();
            intent.setClass(getActivity(), Activity_Details.class);
            intent.putExtra("index", id);
            startActivity(intent);
	 	}
	 	

    }//list item click listener ends here
}