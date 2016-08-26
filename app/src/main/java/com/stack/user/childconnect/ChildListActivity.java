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
import android.widget.ListView;
import android.widget.PopupWindow;

import com.stack.user.childconnect.Adapter.ChildListAdapter;
import com.stack.user.childconnect.Models.ChildDetailModel;

import java.util.ArrayList;

/**
 * Created by Renjith M R on 18/7/16.
 */
public class ChildListActivity extends Activity {
    private ListView lvChildlist;
    private LinearLayout lyThink;
    private ImageView imgMenu,imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_list);
        init();
        ArrayList<ChildDetailModel> aryChildDetail=new ArrayList<>();
        ChildDetailModel modChildDetail=new ChildDetailModel();
        ChildDetailModel modChildDetail1=new ChildDetailModel();

        modChildDetail.setName("Jax");
        modChildDetail.setDate("11/13/2014");
        modChildDetail.setMessageType("New Message");
        modChildDetail.setImageId(R.drawable.jax);

        aryChildDetail.add(modChildDetail);

        modChildDetail1.setName("Merlin");
        modChildDetail1.setDate("04/06/2014");
        modChildDetail1.setMessageType("New Lifebook Event");
        modChildDetail1.setImageId(R.drawable.girl_);

        aryChildDetail.add(modChildDetail1);

        ChildListAdapter childListAdapter=new ChildListAdapter(ChildListActivity.this,aryChildDetail);
        lvChildlist.setAdapter(childListAdapter);
        lyThink.setOnClickListener(new View.OnClickListener() {
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
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();

            }
        });
    }
    private void init(){
        lvChildlist=(ListView)findViewById(R.id.lv_childlist);
        lyThink=(LinearLayout)findViewById(R.id.ly_think);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        imgBack=(ImageView)findViewById(R.id.img_back);
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
        ImageView imgMessageClose=(ImageView)popupView.findViewById(R.id.img_composemsg_popup_close);
        imgMessageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
    }
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
                Intent intent=new Intent(ChildListActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }
}
