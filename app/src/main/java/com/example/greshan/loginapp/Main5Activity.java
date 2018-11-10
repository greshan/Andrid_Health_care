package com.example.greshan.loginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    DatabaseHelper db;
    EditText SearchId;
    Button Search;
    ListView Lv;
    List item;
    private ArrayAdapter<String> adapter;

    String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        db = new DatabaseHelper(this);

        SearchId = (EditText) findViewById(R.id.patientId);
        Search   = (Button) findViewById(R.id.search);
        Lv = (ListView) findViewById(R.id.lst);

        item = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        Lv.setAdapter(adapter);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String id = (SearchId.getText().toString());
                db = new DatabaseHelper(getApplicationContext());
                name = db.getid(id);
                if(name != null)
                {
                    //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                    for(int i=0;i<=5;i++) {
                        adapter.add(name[i]);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}


