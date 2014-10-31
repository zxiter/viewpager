package com.zhurui.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhurui.fragment.Fragment1;
import com.zhurui.fragment.Fragment2;
import com.zhurui.fragment.Fragment3;
import com.zhurui.fragment.Fragment4;
import com.zhurui.view.MyTabView.onTabSelectListener;

public class MainActivity extends FragmentActivity implements onTabSelectListener {

	
	private MyViewPager mvp ;
	private MyFragmentPagerAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mvp = (MyViewPager) findViewById(R.id.mvp);
		mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		mvp.setAdapter(mAdapter);
	
	}
	
	private class MyFragmentPagerAdapter extends FragmentPagerAdapter{

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new Fragment1();
				break;
			case 1:
				fragment = new Fragment2();
				break;
			case 2:
				fragment = new Fragment3();
				break;
			case 3:
				fragment = new Fragment4();
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}
		
	}

	@Override
	public void onTabSelect(int position) {
		// TODO Auto-generated method stub
		mvp.setCurrentItem(position);
	}
	

}
