package com.stack.user.childconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import com.stack.user.childconnect.Adapter.LifebookMainAdapter;
import com.stack.user.childconnect.Models.LifebookMainModel;

import java.util.ArrayList;

/**
 * Created by Renjith M R on 20/7/16.
 */
public class LifeBookActivity extends Activity {
    private LinearLayout lyCreateLifebook;
    private ListView lvLifebookMain;
    private ImageView imgMenu,imgBack,imgFilter,imgAppName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_book_main);
        init();
        lyCreateLifebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeBookActivity.this, CreateLifeBookActivity.class);
                startActivity(intent);
            }
        });

   /*     ArrayList<LifebookMainModel> aryLifebook =new ArrayList<>();
        LifebookMainModel modLife*/

        ////adapter set
        LifebookMainAdapter lifebookMainAdapter=new LifebookMainAdapter(LifeBookActivity.this);
        lvLifebookMain.setAdapter(lifebookMainAdapter);
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
        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
          PopupMenu popup = new PopupMenu(LifeBookActivity.this, imgMenu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.poupup_menu, popup.getMenu());
               //  MenuItem item = item.findItem(R.id.one);
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();////showing popup menu
            }
        });
        imgAppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeBookActivity.this,ChildListActivity.class);
                startActivity(intent);
            }
        });
    }
    //////initialize views
    private void init(){
        lyCreateLifebook=(LinearLayout)findViewById(R.id.ly_create_lifebook);
        lvLifebookMain=(ListView)findViewById(R.id.lv_lifebook_main);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        imgBack=(ImageView)findViewById(R.id.img_back);
        imgFilter=(ImageView)findViewById(R.id.img_filter);
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
                Intent intent=new Intent(LifeBookActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });
    }


}
