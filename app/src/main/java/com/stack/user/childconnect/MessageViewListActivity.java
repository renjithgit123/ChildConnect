package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.stack.user.childconnect.Adapter.MessageViewListAdapter;

/**
 * Created by Renjith M R on 21/7/16.
 */
public class MessageViewListActivity extends Activity {
    private ListView lvMessageList;
    private ImageView imgMenu,imgBack,imgAppName;
    private LinearLayout lyComposeMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_message_list);
        init();
        /////set adapter
        MessageViewListAdapter messageViewListAdapter=new MessageViewListAdapter(MessageViewListActivity.this);
        lvMessageList.setAdapter(messageViewListAdapter);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();
            }
        });
        lyComposeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeMessagePopup();
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
                Intent intent=new Intent(MessageViewListActivity.this,ChildListActivity.class);
                startActivity(intent);
            }
        });

    }
    /////Initialize views
    private void init(){
        lvMessageList=(ListView)findViewById(R.id.lv_msg_view_list);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        lyComposeMessage=(LinearLayout)findViewById(R.id.ly_compose_mesage);
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
                Intent intent=new Intent(MessageViewListActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }

    private void composeMessagePopup(){
        final PopupWindow pw;
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.compose_message_popup, null);
        pw = new PopupWindow(
                popupView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                true);
        pw.showAtLocation(this.findViewById(R.id.ly_main), Gravity.CENTER, 0, 0);
     /*   ImageView imgClose=(ImageView)popupView.findViewById(R.id.img_composemsg_popup_close);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });*/
    }

}
