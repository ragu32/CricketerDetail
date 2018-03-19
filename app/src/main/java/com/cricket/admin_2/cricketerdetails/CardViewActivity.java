package com.cricket.admin_2.cricketerdetails;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cricket.admin_2.cricketerdetails.interfaces.CardViewInterface;

public class CardViewActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView cardViewImage;
    TextView cardViewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);
        setResult(RESULT_OK);

        cardViewText = findViewById(R.id.text_one);
        cardViewImage = findViewById(R.id.image_one);
    }
}
