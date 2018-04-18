package com.example.mac.a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    CheckBox female;
    CheckBox male;
    EditText name;
    String inputName;
    EditText description;
    String inputDescription;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name_field);
        database = FirebaseDatabase.getInstance();

        description = (EditText) findViewById(R.id.description_field);
        female = (CheckBox) findViewById(R.id.female);
        male = (CheckBox) findViewById(R.id.male);

        //web view
        String url = "http://google.com/";
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }

    //button: go to next page
    public void nextToResult(View view) {
        inputName = name.getText().toString();
        inputDescription = description.getText().toString();
        Intent intentActivity = new Intent(this, Result.class);
        // pass a string to the second activity
        if (female.isChecked() && male.isChecked() == false) {
            intentActivity.putExtra("KEY_STRING1", "Name:" + inputName + "\nGender: Female" + "\nDescription:" + inputDescription);
        } else if (male.isChecked() && female.isChecked() == false) {
            intentActivity.putExtra("KEY_STRING1", "Name:" + inputName + "\nGender: Male" + "\nDescription:" + inputDescription);
        } else {
            Toast.makeText(this, "At least one and only one gender please", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intentActivity);
    }

    //firebase
    public void writeToCloud(View view) {
        myRef = database.getReference("Name：");
        myRef.setValue(name.getText().toString());
        Toast.makeText(this, "Stored, check now!", Toast.LENGTH_SHORT).show();
    }

}
