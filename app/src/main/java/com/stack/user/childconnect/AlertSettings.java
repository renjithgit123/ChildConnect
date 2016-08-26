package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

/**
 * Created by Renjith M R on 21/7/16.
 */
public class AlertSettings extends Activity {
    private Spinner spndatenumber,spnday,spnbeforenumber,spnbeforedays;
    private ImageView imgMenu,imgBack,imgAppName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_settings);
        init();
        spndatenumber.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);
        spnday.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);
        spnbeforenumber.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);
        spnbeforedays.getBackground().setColorFilter(getResources().getColor(R.color.spinner_blue), PorterDuff.Mode.SRC_ATOP);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgAppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AlertSettings.this,ChildListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    /////initialize views
    private void init(){
        spndatenumber=(Spinner)findViewById(R.id.spn_reminder_date);
        spnday=(Spinner)findViewById(R.id.spn_reminder_days);
        spnbeforenumber=(Spinner)findViewById(R.id.spn_reminder_date_before);
        spnbeforedays=(Spinner)findViewById(R.id.spn_reminder_day_before);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        imgBack=(ImageView)findViewById(R.id.img_back);
        imgAppName=(ImageView)findViewById(R.id.img_appname);
    }
    ////////popup menu
    private void popupMenu(){
        final PopupWindow pw;
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_menu_layout, null);
        pw = new PopupWindow(
                popupView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                true);
        pw.setAnimationStyle(R.style.PopupAnimation);
        //   layoutParams.setMargins(30, 20, 30, 0);
        // The code below assumes that the root container has an id called 'main'
        pw.showAtLocation(this.findViewById(R.id.ly_main), Gravity.TOP, 230, 230);
        //  ImageView imgPopClose=(ImageView)popupView.findViewById(R.id.img_menu);
      /*  imgPopClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });*/
        LinearLayout lyLogout=(LinearLayout)popupView.findViewById(R.id.ly_popup_logout);
        lyLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AlertSettings.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }


}
