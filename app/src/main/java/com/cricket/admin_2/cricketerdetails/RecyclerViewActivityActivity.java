package com.cricket.admin_2.cricketerdetails;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cricket.admin_2.cricketerdetails.adapter.CardViewAdapter;

public class RecyclerViewActivityActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        RecyclerView recyclerView = findViewById(R.id.card_List);
        CardViewAdapter cardViewAdapter = new CardViewAdapter(getApplicationContext(), this);
        recyclerView.setAdapter(cardViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            //cardViewImage.setImageURI(selectedImage);
        }
    }
}
