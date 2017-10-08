package com.sourabh.www.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {

    private Context mContext;
    List<String> comp,status;

    public adapter(Context mContext, List comp, List status) {
        this.mContext = mContext;
        this.comp= comp;
        this.status =status;

    }

    @Override
    public int getCount() {
        return comp.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.activity_adapter, null);
            TextView textView = (TextView) grid.findViewById(R.id.textView22);
            TextView text = (TextView) grid.findViewById(R.id.textView72);


            textView.setText(comp.get(position));
            text.setText(status.get(position));

        } else {
            grid = convertView;
        }

        return grid;
    }



    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

