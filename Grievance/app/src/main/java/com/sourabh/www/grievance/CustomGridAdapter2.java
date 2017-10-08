package com.sourabh.www.grievance;

/**
 * Created by sourabh on 10/7/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGridAdapter2 extends BaseAdapter {

    private Context mContext;
    List<String> comp,status,id;

    public CustomGridAdapter2(Context mContext, List comp,List status, List id) {
        this.mContext = mContext;
        this.comp= comp;
        this.status =status;
        this.id=id;

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
            grid = inflater.inflate(R.layout.activity_custom_grid_adapter2, null);
            TextView textView = (TextView) grid.findViewById(R.id.textView22);
            TextView text = (TextView) grid.findViewById(R.id.textView72);


            textView.setText(comp.get(position));
            text.setText(status.get(position));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iny=new Intent(mContext,details.class);
                    iny.putExtra("comp",comp.get(position));
                    iny.putExtra("status",status.get(position));
                    iny.putExtra("id",id.get(position));
                    mContext.startActivity(iny);
                }
            });

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

