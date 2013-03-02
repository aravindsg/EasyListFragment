package com.aravind.project.elf.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 */
public abstract class CustomAdapter extends BaseAdapter {

	/**
	 * Method getCount.
	 * @return int
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public abstract int getCount() ;

	/**
	 * Method getItem.
	 * @param arg0 int
	 * @return Object
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		return null;
	}

	/**
	 * Method getItemId.
	 * @param arg0 int
	 * @return long
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	/**
	 * Method getView.
	 * @param arg0 int
	 * @param arg1 View
	 * @param arg2 ViewGroup
	 * @return View
	 * @see android.widget.Adapter#getView(int, View, ViewGroup)
	 */
	@Override
	public abstract View getView(int arg0, View arg1, ViewGroup arg2);

}