/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 16, 2013
 */
package com.jbetterly.auto2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class FormFragment extends Fragment
{

	private FormListener listener;

	
	public interface FormListener{
		
		/**
		 * On info page.
		 */
		public void onInfoPage();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.activity_main, container, false);
		
		Button B = (Button) view.findViewById(R.id.infoPage);
		B.setOnClickListener(new OnClickListener() {
			
			@Override
			
				public void onClick(View v) {
				listener.onInfoPage();
			}
		});
		
		return view;
	};
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		try
		{
			listener = (FormListener) activity;
		}catch (ClassCastException e)
		
		{
			throw new ClassCastException(activity.toString() + " must implement FormListener");
		}
	}
	
	
}//end
