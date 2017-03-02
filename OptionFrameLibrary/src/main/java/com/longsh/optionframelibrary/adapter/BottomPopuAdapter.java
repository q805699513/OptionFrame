package com.longsh.optionframelibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.longsh.optionframelibrary.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class BottomPopuAdapter extends BaseAdapter {
    private List<String> lstImageItem;
    private Context mContext;
    public int po = 0;

    public BottomPopuAdapter(Context mContext, List<String> arg0) {
        this.lstImageItem = arg0;
        this.mContext = mContext;
    }

    public int getCount() {
        return lstImageItem.size();
    }

    public Object getItem(int position) {
        return lstImageItem.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {


        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_bottom_popu, null);
            viewHolder.addtext = (TextView) view.findViewById(R.id.addtext);
            viewHolder.addlayout = (LinearLayout) view.findViewById(R.id.addlayout);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String str = lstImageItem.get(position);
        viewHolder.addtext.setText(str);
        return view;
    }

    class ViewHolder {
        TextView addtext;
        LinearLayout addlayout;
    }
}
