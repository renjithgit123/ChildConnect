package com.stack.user.childconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.stack.user.childconnect.Fragment.PartenInfoFragment;
import com.stack.user.childconnect.Fragment.PersonelInfoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renjith M R on 19/7/16.
 */
public class InfoTabeActivity  extends ActionBarActivity {
    private ImageView imgMenu,imgBack,imgAppName;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_tab_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        imgMenu=(ImageView)findViewById(R.id.img_menu);
        imgBack=(ImageView)findViewById(R.id.img_back);
        imgAppName=(ImageView)findViewById(R.id.img_appname);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.setupWithViewPager(viewPager);
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
                Intent intent=new Intent(InfoTabeActivity.this,ChildListActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonelInfoFragment(), "Personal Info");
        adapter.addFragment(new PartenInfoFragment(), "Partner Info");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
        pw.showAtLocation(this.findViewById(R.id.ly_main), Gravity.TOP, 230, 230);
        LinearLayout lyLogout=(LinearLayout)popupView.findViewById(R.id.ly_popup_logout);
        lyLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InfoTabeActivity.this,ChildconnectActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
    }

}

