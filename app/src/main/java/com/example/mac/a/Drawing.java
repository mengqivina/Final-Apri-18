package com.example.mac.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Drawing extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void readyToRead(MenuItem item) {
            Intent intentActivity = new Intent(this, ReadImage.class);
            startActivity(intentActivity);
        }

    private DrawingView customCanvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dv = new DrawingView(this);
        setContentView(R.layout.activity_drawing);
        customCanvas = findViewById(R.id.canvas);

        Button bt_clearAll = (Button) findViewById(R.id.bt_clearAll);
        bt_clearAll.setOnClickListener(new ButtonClick());

        Button bt_save = (Button) findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new ButtonClick());

        Button bt_write = (Button) findViewById(R.id.bt_write);
        bt_write.setOnClickListener(new ButtonClick());
        contextOfApplication = getApplicationContext();

    }

    public static Context contextOfApplication;

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

    public void clearCanvas() {
        customCanvas.clearCanvas();
    }

    public void saveCanvas() {
        customCanvas.saveToInternalStorage(customCanvas.mBitmap);
    }

    public void write() {
        customCanvas.writeToCloud(customCanvas.mBitmap);
    }

    class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_clearAll:
                    clearCanvas();
                    Toast.makeText(Drawing.this, "Ok, cleared my drawing", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_save:
                    saveCanvas();
                    Toast.makeText(Drawing.this, "Ok, saved my drawing in the app", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_write:
                    write();
                    Toast.makeText(Drawing.this, "Ok, wrote my drawing to cloud", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


}
