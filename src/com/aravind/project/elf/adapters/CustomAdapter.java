package com.aravind.project.elf.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CustomAdapter extends BaseAdapter {

	@Override
	public abstract int getCount() ;

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public abstract View getView(int arg0, View arg1, ViewGroup arg2);

}