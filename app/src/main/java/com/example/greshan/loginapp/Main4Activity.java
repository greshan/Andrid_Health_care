package com.example.greshan.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    Button Info,Search;
    TextView User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Info =(Button)findViewById(R.id.pinfo);
        Search =(Button)findViewById(R.id.infosearch);
        User =(TextView) findViewById(R.id.text);



        inFo();
        searchInfo();
    }

    private void searchInfo() {
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent j = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(j);
                //finish();
            }
        });
    }

    private void inFo() {
        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Main4Activity.this,Main2Activity.class);
                startActivity(i);
                //finish();
            }
        });
    }
}
