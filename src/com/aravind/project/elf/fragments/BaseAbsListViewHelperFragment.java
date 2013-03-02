package com.aravind.project.elf.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.androidquery.AQuery;
import com.aravind.project.elf.adapters.CustomAdapter;
import com.aravind.project.elf.interfaces.IAbsListViewSetup;
import com.aravind.project.elf.listeners.EndlessScrollListener;

/**
 */
public abstract class BaseAbsListViewHelperFragment extends BaseFragment implements IAbsListViewSetup {

	protected CustomAdapter adapter;
	BaseListViewListener mActivity;
	protected View progressView;
	protected EndlessScrollListener endlessScrollListener;
	protected AQuery aq;
	protected AbsListView absListView;
	protected LayoutInflater inflater;

	/**
	 */
	public interface BaseListViewListener extends BaseFragmentListener {

	}

	/**
	 * Method onAttach.
	 * @param activity Activity
	 */
	@Override
	public void onAttach(Activity activity) {

		try {
			mActivity = (BaseListViewListener) activity;
		} catch (ClassCastException e) {
			Log.e("Invalid Listerer", e.getMessage() + " ");
		}

		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mActivity = null;
	}

	/**
	 * Method onActivityCreated.
	 * @param savedInstanceState Bundle
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		setRetainInstance(true);
		aq = new AQuery(getActivity());
		inflater = getActivity().getLayoutInflater();

		super.onActivityCreated(savedInstanceState);

		bindAdapter();

		setupEndlessScrollListener();
	}

	private void setupEndlessScrollListener() {
		endlessScrollListener = new EndlessScrollListener() {
			
			@Override
			public void incrementLoop() {
				callServerApi();
				
			}
		};
		
		if (absListView != null) {
			absListView.setOnScrollListener(endlessScrollListener);
			aq.id(absListView).scrolled(endlessScrollListener);
		}
	}
}
