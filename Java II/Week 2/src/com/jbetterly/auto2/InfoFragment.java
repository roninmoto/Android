/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 16, 2013
 */
package com.jbetterly.auto2;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Bundle;

public class InfoFragment extends Fragment
{
	private InfoListener ilistener;
	
	public interface InfoListener{
		
		/**
		 * On main page.
		 */
		public void onMainPage();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.infopage, container, false);
		
		Button B1 = (Button) view.findViewById(R.id.button1);
    	B1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			ilistener.onMainPage();
    		}
    	});
		
		return view;
		
	};
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			ilistener = (InfoListener) activity;
		}catch (ClassCastException e){
			throw new ClassCastException(activity.toString() + " must implement InfoListener");
		}
	}
	
} //end
