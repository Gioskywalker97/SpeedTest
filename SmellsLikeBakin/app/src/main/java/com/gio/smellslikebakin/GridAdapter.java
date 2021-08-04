package com.gio.smellslikebakin;

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = (GridFragment.OnRecipeSelectedInterface) listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}