package com.example.greshan.loginapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login, Sinup;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.User);
        Password = (EditText) findViewById(R.id.Pass);

        Login = (Button) findViewById(R.id.Login);
        Sinup = (Button) findViewById(R.id.Sinup);


        myDb = new DatabaseHelper(this);


        sinUP();
        logIn();

        AlarmManager alarmMgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 777, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 58);

        // setRepeating() lets you specify a precise custom interval--in this case,
        // 20 minutes.

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 1, alarmIntent);


    }

    public boolean flag = false;

    public void logIn() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                Cursor res = myDb.getData();
                while (res.moveToNext()) {
                    if (res.getString(0).equals(Username.getText().toString()) && res.getString(1).equals(Password.getText().toString())) {


                        flag = true;
                        Intent i = new Intent(MainActivity.this, Main4Activity.class);
                        i.putExtra("name", Username.getText().toString());
                        startActivity(i);

                        Username.setText("");
                        Password.setText("");

                        Toast.makeText(getApplicationContext(), "Log In Successful......", Toast.LENGTH_LONG).show();
                    }
                }

                if (!flag) {
                    Toast.makeText(getApplicationContext(), "Username or Password Incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void sinUP() {
        Sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(k);


            }
        });
    }

}