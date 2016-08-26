package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Renjith M R on 18/7/16.
 */
public class ChildDetailViewActivity extends Activity {
    private LinearLayout lyPasswordReset,lyComposeMessage,lyHelp,lyAlertSettings,lyLifeBook,lyAddress;
    private ImageView imgMenu,imgBack,imgChildImage,imgAppName;
    private TextView txtvwAlert,txtvwPasswordReset,txtvwName,txtvwDob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_detail_view);
        init();
        Intent intent=getIntent();
        int photoId=intent.getIntExtra("childPhoto", 0);
        String name=intent.getStringExtra("ChildName");
        String dob=intent.getStringExtra("ChildDob");
        imgChildImage.setImageResource(photoId);
        txtvwName.setText(name);
        txtvwDob.setText(dob);
        txtvwAlert.setText("Alert\nSettings");
        txtvwPasswordReset.setText("Password\nReset");
        lyPasswordReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildDetailViewActivity.this, PasswordResetActivity.class);
                startActivity(intent);
            }
        });
        lyComposeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildDetailViewActivity.this, MessageViewListActivity.class);
                startActivity(intent);
            }
        });
        lyHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChildDetailViewActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });
        lyAlertSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildDetailViewActivity.this, AlertSettings.class);
                startActivity(intent);
            }
        });
        lyLifeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildDetailViewActivity.this, LifeBookActivity.class);
                startActivity(intent);
            }
        });
        lyAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildDetailViewActivity.this, InfoTabeActivity.class);
                startActivity(intent);
            }
        });
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
                Intent intent=new Intent(ChildDetailViewActivity.this,ChildListActivity.class);
                startActivity(intent);
            }
        });

    }
    //////initialize views
    private void init(){
        lyPasswordReset=(LinearLayout)findViewById(R.id.ly_password_reset);
        lyComposeMessage=(LinearLayout)findViewById(R.id.ly_compose_mesage);
        lyHelp=(LinearLayout)findViewById(R.id.ly_help);
        lyAlertSettings=(LinearLayout)findViewById(R.id.ly_alert_settings);
        lyLifeBook=(LinearLayout)findViewById(R.id.ly_life_book);
        lyAddress=(LinearLayout)findViewById(R.id.ly_address);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        txtvwAlert=(TextView)findViewById(R.id.txtvw_alert);
        txtvwName=(TextView)findViewById(R.id.txtvw_name);
        txtvwDob=(TextView)findViewById(R.id.txtvw_dob);
        txtvwPasswordReset=(TextView)findViewById(R.id.txtvw_password_reset);
        imgBack=(ImageView)findViewById(R.id.img_back);
        imgChildImage=(ImageView)findViewById(R.id.child_image);
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
                Intent intent=new Intent(ChildDetailViewActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }

}
