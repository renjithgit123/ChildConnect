package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Renjith M R on 18/7/16.
 */
public class HomeActivity extends Activity {
    private Button btnJoinNow,btnLogin;
    private TextView txtvwHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        init();
        txtvwHeading.setText("Create a profile\nand keep connected\nwith your children");
        txtvwHeading.setTypeface(null, Typeface.BOLD);
        btnJoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ChildconnectActivityLogin.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        btnJoinNow=(Button)findViewById(R.id.btn_join_now);
        btnLogin=(Button)findViewById(R.id.btn_login);
        txtvwHeading=(TextView)findViewById(R.id.txtvw_heading);
    }
}
