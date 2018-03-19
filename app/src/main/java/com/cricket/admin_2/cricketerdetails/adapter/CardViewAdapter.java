package com.cricket.admin_2.cricketerdetails.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cricket.admin_2.cricketerdetails.CardViewActivity;
import com.cricket.admin_2.cricketerdetails.R;
import com.cricket.admin_2.cricketerdetails.RecyclerViewActivityActivity;
import com.cricket.admin_2.cricketerdetails.interfaces.CardViewInterface;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by admin_2 on 01/03/2018.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private Context context;
    private ViewHolder viewHolder;
    public CardViewInterface cardViewInterface;
    private RecyclerViewActivityActivity recyclerViewActivityActivity;
    private static final int RESULT_LOAD_IMAGE = 1;
    public CardViewAdapter(Context context, RecyclerViewActivityActivity recyclerViewActivityActivity) {
        this.context = context;
        this.recyclerViewActivityActivity = recyclerViewActivityActivity;
    }

    /*public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.card_view, parent, false);

        }

        return convertView;
    }*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = layoutInflater.inflate(R.layout.card_view, parent, false);
        viewHolder = new ViewHolder(convertView);
        viewHolder.textView1 = convertView.findViewById(R.id.text_one);
        viewHolder.imageView1 = convertView.findViewById(R.id.image_one);
        convertView.setTag(viewHolder);

        viewHolder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Log.d("LogTag", "in side onClickCardView");
                        Intent textClickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                recyclerViewActivityActivity.startActivityForResult(textClickImage, RESULT_LOAD_IMAGE);
            }
        });
        return new ViewHolder(convertView);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recyclerViewActivityActivity.onActivityResult();
        if(resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            cardViewImage.setImageURI(selectedImage);
        }
    }*/


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 1;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        ImageView imageView1;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
