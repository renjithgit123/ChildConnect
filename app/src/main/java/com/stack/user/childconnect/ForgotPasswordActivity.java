package com.stack.user.childconnect;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Renjith M R on 18/7/16.
 */
public class ForgotPasswordActivity extends Activity {
    private TextView txtvwForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        init();
        String text_forgotPassword="Please enter your email Id registered with us and press \"SUBMIT\" .if you donot know User Id or have any other questions please enter a help desk ticket at ";
        /*String sourceString=text_forgotPassword + "<b>" + "help.cairsolutions.com" + "</b> ";*/
        String sourceString=text_forgotPassword + "<font color=#003663><b>help.cairsolutions.com</font>";;
        txtvwForgotPassword.setText(Html.fromHtml(sourceString));
    }
    ////initialize views
    private void init(){
        txtvwForgotPassword=(TextView)findViewById(R.id.txtvw_forgotpassword);
    }
}
