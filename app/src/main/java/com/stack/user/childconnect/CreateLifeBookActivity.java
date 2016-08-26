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

/**
 * Created by Renjith M R on 20/7/16.
 */
public class CreateLifeBookActivity extends Activity {
    private ImageView imgMenu,imgBack,imgAppName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_lifebook);
        init();
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();
            }
        });
        imgAppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreateLifeBookActivity.this,ChildListActivity.class);
                startActivity(intent);
            }
        });


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
                Intent intent=new Intent(CreateLifeBookActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }

    //////initialize
    private void init(){
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        imgBack=(ImageView)findViewById(R.id.img_back);
        imgAppName=(ImageView)findViewById(R.id.img_appname);
    }

}
