package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Renjith M R on 18/7/16.
 */
public class RegisterActivity extends Activity {
    private Button btnLogin;
    private TextView txtvwFirstnameHeading,txtvwLastnameHeading,txtvwEmailHeading,txtvwPhoneHeading,txtvwPaymentHeading;
    private TextView txtvwIam,txtvwAgency;
    private Spinner spnIam,spnAgency;
    private LinearLayout lyPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
        ////2 color text on single textview
        String text_firstname = "<font color=#232428>First Name</font><font color=#00B7F9>*</font>";
        String text_lastname = "<font color=#232428>Last Name</font><font color=#00B7F9>*</font>";
        String text_email = "<font color=#232428>Email</font><font color=#00B7F9>*</font>";
        String text_phone = "<font color=#232428>Phone</font><font color=#00B7F9>*</font>";
        String text_payment = "<font color=#232428>Payment Information</font><font color=#00B7F9>*</font>";
        String text_iam= "<font color=#232428>I am</font><font color=#00B7F9>*</font>";
        String text_agency= "<font color=#232428>Agency</font><font color=#00B7F9>*</font>";

        txtvwFirstnameHeading.setText(Html.fromHtml(text_firstname));
        txtvwLastnameHeading.setText(Html.fromHtml(text_lastname));
        txtvwEmailHeading.setText(Html.fromHtml(text_email));
        txtvwPhoneHeading.setText(Html.fromHtml(text_phone));
        txtvwPaymentHeading.setText(Html.fromHtml(text_payment));
        txtvwIam.setText(Html.fromHtml(text_iam));
        txtvwAgency.setText(Html.fromHtml(text_agency));
        //////set spinner arrow color
        spnIam.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);
        spnAgency.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);
        ArrayAdapter<String> adapter;
        ArrayList<String> aryIam = new ArrayList<String>();
        aryIam.add(0,"Adoptive");
        aryIam.add(1,"Birth");
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.spin, aryIam);
        spnIam.setAdapter(adapter);
        spnIam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1, int position, long arg3) {
                // TODO Auto-generated method stub
                String selection = spnIam.getSelectedItem().toString();
//                Log.e("SELECTION",selection);
                if (selection.equals("Adoptive")) {
                    txtvwPaymentHeading.setVisibility(View.VISIBLE);
                    lyPayment.setVisibility(View.VISIBLE);
                } else {
                    txtvwPaymentHeading.setVisibility(View.GONE);
                    lyPayment.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,ChildconnectActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
    ////initiallize views
    private void init(){
        btnLogin=(Button)findViewById(R.id.btn_login);
        txtvwFirstnameHeading=(TextView)findViewById(R.id.txtvw_firstaname_heading);
        txtvwLastnameHeading=(TextView)findViewById(R.id.txtvw_lastname_heading);
        txtvwEmailHeading=(TextView)findViewById(R.id.txtvw_email_heading);
        txtvwPhoneHeading=(TextView)findViewById(R.id.txtvw_phone_heading);
        txtvwPaymentHeading=(TextView)findViewById(R.id.txtvw_payment_heading);
        txtvwIam=(TextView)findViewById(R.id.txtvw_iam);
        txtvwAgency=(TextView)findViewById(R.id.txtvw_agency);
        spnIam=(Spinner)findViewById(R.id.spn_iam);
        spnAgency=(Spinner)findViewById(R.id.spn_agency);
        lyPayment=(LinearLayout)findViewById(R.id.ly_payment);
        btnLogin=(Button)findViewById(R.id.btn_login);
    }
}
