package com.cricket.admin_2.cricketerdetails.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cricket.admin_2.cricketerdetails.R;

/**
 * Created by admin_2 on 01/03/2018.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private Context context;
    private ViewHolder viewHolder;
    public CardViewAdapter(Context context) {
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.card_view_activity, parent, false);
           /* viewHolder = new ViewHolder();
            viewHolder.textView1 = convertView.findViewById(R.id.text_one);
            viewHolder.textView2 = convertView.findViewById(R.id.text_two);
            convertView.setTag(viewHolder);*/
        }
        else
        {
            /*viewHolder = (ViewHolder)convertView.getTag();*/
        }
        return convertView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = layoutInflater.inflate(R.layout.card_view_activity, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
