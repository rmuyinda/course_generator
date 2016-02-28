package com.codemovers.coursegenerator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        load_view();
    }

    // Load View
    public void load_view()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Thread.sleep(5000);
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                catch (Exception em)
                {
                    em.printStackTrace();
                }

            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        load_view();
    }
}
