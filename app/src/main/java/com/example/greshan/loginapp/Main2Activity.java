package com.example.greshan.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText PFname,PSname,Pweight,Pheight,Page,Psex;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new DatabaseHelper(this);

        PFname       = (EditText)findViewById(R.id.fname);
        PSname       = (EditText)findViewById(R.id.sname);
        Pweight       = (EditText)findViewById(R.id.weight);
        Pheight       = (EditText)findViewById(R.id.height);
        Page       = (EditText)findViewById(R.id.age);
        Psex       = (EditText)findViewById(R.id.sex);

        Update =(Button)findViewById(R.id.update);


        upDate();

    }



    public void upDate() {
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(PFname.getText().toString().equals("") || Pheight.getText().toString().equals("") || Pweight.getText().toString().equals("") || Page.getText().toString().equals("")|| Psex.getText().toString().equals("")){


                    Toast.makeText(getApplicationContext(),"Please Insert Data",Toast.LENGTH_LONG).show();

                    PFname.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Pweight.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Pheight.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Page.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Psex.setHintTextColor(Color.parseColor("#ffcc0000"));



                }
                else{
                        boolean isInserted = myDb.inserIntoData(PFname.getText().toString(),PSname.getText().toString(),Pheight.getText().toString(),Pweight.getText().toString(),Page.getText().toString(),Psex.getText().toString());

                        Intent j = new Intent(getApplicationContext(),Main4Activity.class);
                        startActivity(j);
                        Toast.makeText(getApplicationContext(),"Successfully Added The Information ",Toast.LENGTH_LONG).show();
                        finish();


                }





            }

        });
    }
}

