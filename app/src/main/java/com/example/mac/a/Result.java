package com.example.mac.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    TextView infoField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        //getting the intent
        Intent intentActivity = getIntent();
        String info = intentActivity.getStringExtra("KEY_STRING1");

        TextView infoField = (TextView) findViewById(R.id.info_field);
        infoField.setText(info);

    }


    public void nextToDraw(View view) {
        Intent intentActivity = new Intent(this, Drawing.class);
        startActivity(intentActivity);
    }
}



