package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by Renjith M R on 25/8/16.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(3000);
                    }
                }
                catch (Exception ae)
                {
                    ae.printStackTrace();
                }
                finish();
                Intent intent=new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });thread.start();

    }
}
