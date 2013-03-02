package com.aravind.project.elf.listeners;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/**
 */
public abstract class EndlessScrollListener implements OnScrollListener {

	private int visibleThreshold = 15;
	private boolean loading = true;
	private int previousTotal = 0;
	int page = 1;

	public abstract void incrementLoop();

	public EndlessScrollListener() {
	}

	/**
	 * Constructor for EndlessScrollListener.
	 * @param visibleThreshold int
	 */
	public EndlessScrollListener(int visibleThreshold) {
		this.visibleThreshold = visibleThreshold;
	}

	/**
	 * Method onScroll.
	 * @param view AbsListView
	 * @param firstVisibleItem int
	 * @param visibleItemCount int
	 * @param totalItemCount int
	 * @see android.widget.AbsListView$OnScrollListener#onScroll(AbsListView, int, int, int)
	 */
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

		if (loading) {
			if (totalItemCount > previousTotal) {
				loading = false;
				previousTotal = totalItemCount;
				page++;
			}
		}
		if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
			incrementLoop();
			loading = true;
		}
	}

	/**
	 * Method getPage.
	 * @return int
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Method setPage.
	 * @param page int
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * Method onScrollStateChanged.
	 * @param view AbsListView
	 * @param scrollState int
	 * @see android.widget.AbsListView$OnScrollListener#onScrollStateChanged(AbsListView, int)
	 */
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
	}
}