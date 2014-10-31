 package com.zhurui.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.zhurui.viewpager.R;

public class MyTabView  extends LinearLayout implements View.OnClickListener{

	private onTabSelectListener listener;
	
	private List<RadioButton> views ;
	
	private int currentPosition;
	
	private List<Integer> selectImages = new ArrayList<Integer>();
	
	private List<Integer> unSelectImages = new ArrayList<Integer>();
	
	
	public MyTabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	
	}
	public void init(){
		
		View contentView =  LayoutInflater.from(getContext()).inflate(R.layout.my_tab, this);
		views = new ArrayList<RadioButton>();
		views.add((RadioButton) contentView.findViewById(R.id.rb_1));
		views.add((RadioButton) contentView.findViewById(R.id.rb_2));
		views.add((RadioButton) contentView.findViewById(R.id.rb_3));
		views.add((RadioButton) contentView.findViewById(R.id.rb_4));
		
		selectImages.add(R.drawable.find_1);
		selectImages.add(R.drawable.map_1);
		selectImages.add(R.drawable.add_1);
		selectImages.add(R.drawable.tickets_1);
		
		unSelectImages.add(R.drawable.find_2);
		unSelectImages.add(R.drawable.map_2);
		unSelectImages.add(R.drawable.add_2);
		unSelectImages.add(R.drawable.tickets_2);
		
		for(RadioButton rb:views){
			rb.setOnClickListener(this);
		}
		
		
		Activity activity = (Activity) getContext();
		if(!(activity instanceof onTabSelectListener)){
			throw new IllegalStateException("Activity must implement TabSelectView OnTableSelectListener.");
		}
		listener = (onTabSelectListener) activity;
	}
	
	
	public interface onTabSelectListener{
		public void onTabSelect(int position);
	}


	
	@Override
	public void onClick(View v) {
		
		currentPosition = getSelectPosition(v);
		setPosition(currentPosition);
		
		listener.onTabSelect(currentPosition);
		
	}
	
	private void setPosition(int position) {
		
		for(int i=0;i<views.size();i++){
			if(position==i){
				views.get(i).setTextColor(getContext().getResources().getColor(R.color.checked));
				views.get(i).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(selectImages.get(i)), null, null);
			}else{
				views.get(i).setTextColor(Color.WHITE);
				views.get(i).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(unSelectImages.get(i)), null, null);
			}
		}
	}
	
	
	private int getSelectPosition(View v) {
		for(int i =0;i<views.size();i++){
			if(views.get(i)==v){
				return i;
			}
		}
		return 0;
	}
	
	

}
