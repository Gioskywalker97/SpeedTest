package com.gio.listwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    Context context;
    String[] list = {"Treehouse", "Android", "Java", "Kotlin", "Anko"};

    public WidgetAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView, list[position]);

        Intent intent = new Intent();
        intent.putExtra(WidgetProvider.KEY_ITEM, list[position]);
        remoteViews.setOnClickFillInIntent(R.id.list_item, intent);

        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        // Used to put a view if widget is slow to load
        return null;
    }

    @Override
    public int getViewTypeCount() {
        //Because only one view
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        //Since IDS wont be changing
        return true;
    }
}
