package com.example.spreddit;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.spreddit.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class authenticationActivity extends AppCompatActivity {

//    private String[] tabList = {"Log In", "Sign Up"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
            return;
        }
        setContentView(R.layout.activity_authentication);
        ViewPager viewPager = findViewById(R.id.view_pager2);
        TabLayout tabs = findViewById(R.id.tabs2);
        ViewPageAdapter2 adapter = new ViewPageAdapter2(getSupportFragmentManager());
        adapter.addFragment(new loginFragment(), "Log In");
        adapter.addFragment(new signupFragment(), "Sign Up");
        tabs.setTabTextColors(ContextCompat.getColor(this, R.color.tabSelectedIcon), ContextCompat.getColor(this, R.color.tabSelectedIcon));
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
//        tabs.setTabTextColors(R.color.tabSelectedIcon, R.color.tabSelectedIcon);
//        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
//            @Override
//            public void onTabSelected(TabLayout.Tab tab){
//                super.onTabSelected(tab);
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab){
//                super.onTabUnselected(tab);
////                int tabIconColor = ContextCompat.getColor(context, R.color.tabUnselectedIcon);
////                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab){
//                super.onTabReselected(tab);
//            }
//        });
    }


}

class ViewPageAdapter2 extends FragmentPagerAdapter{
    private final List<Fragment> mfragmentList = new ArrayList<>();
    private final List<String> mfragmentTitleList = new ArrayList<>();

    public ViewPageAdapter2(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount(){
        return mfragmentList.size();
    }

    public void addFragment(Fragment f, String s){
        mfragmentList.add(f);
        mfragmentTitleList.add(s);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return mfragmentTitleList.get(position);
    }
}