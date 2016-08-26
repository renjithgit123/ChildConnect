package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildconnectActivityLogin extends Activity {
    private Button btnLogin,btnJoinNow;
    private TextView txtvwForgotPassword;
    private TextView txtvwUsernameHeading,txtvwPasswordHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.childconnect_login);
        init();
        String text_username = "<font color=#232428>Username</font><font color=#00B7F9>*</font>";
        txtvwUsernameHeading.setText(Html.fromHtml(text_username));
        String text_password = "<font color=#232428>Password</font><font color=#00B7F9>*</font>";
        txtvwUsernameHeading.setText(Html.fromHtml(text_username));
        txtvwPasswordHeading.setText(Html.fromHtml(text_password));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildconnectActivityLogin.this, ChildListActivity.class);
                startActivity(intent);
            }
        });
        txtvwForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChildconnectActivityLogin.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        btnJoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChildconnectActivityLogin.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        btnLogin=(Button)findViewById(R.id.btn_login);
        txtvwForgotPassword=(TextView)findViewById(R.id.txtvw_forgot_password);
        txtvwUsernameHeading=(TextView)findViewById(R.id.txtvw_username_heading);
        txtvwPasswordHeading=(TextView)findViewById(R.id.txtvw_password_heading);
        btnJoinNow=(Button)findViewById(R.id.btn_join_now);
    }
}
