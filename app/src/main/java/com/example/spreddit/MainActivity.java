package com.example.spreddit;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

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

//TODO: Exit app if the user is signed in and back is pressed on home screen

public class MainActivity extends AppCompatActivity {

    private int[] tabIcons = {R.drawable.ic_home_black_24dp, R.drawable.ic_apps_black_24dp, R.drawable.ic_mode_edit_black_24dp,
            R.drawable.ic_chat_black_24dp, R.drawable.ic_account_circle_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_main);
//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
//        setupViewPager(viewPager);
//        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new homeFragment(), null);
        adapter.addFragment(new subFragment(), null);
        adapter.addFragment(new postFragment(), null);
        adapter.addFragment(new messageFragment(), null);
        adapter.addFragment(new profileFragment(), null);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        for(int i=0; i<adapter.getCount(); ++i){
            tabs.getTabAt(i).setIcon(tabIcons[i]);
            if(i==0)
                tabs.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.tabSelectedIcon), PorterDuff.Mode.SRC_IN);
            else
                tabs.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.tabUnselectedIcon), PorterDuff.Mode.SRC_IN);
        }
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                super.onTabSelected(tab);
                int tabIconColor = ContextCompat.getColor(context, R.color.tabSelectedIcon);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){
                super.onTabUnselected(tab);
                int tabIconColor = ContextCompat.getColor(context, R.color.tabUnselectedIcon);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab){
                super.onTabReselected(tab);
            }
        });
    }

//    private void setupViewPager(ViewPager viewPager){
//        SectionsPagerAdapter adapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
////        adapter.
//        viewPager.setAdapter(adapter);
//    }

}

class ViewPageAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mfragmentList = new ArrayList<>();
    private final List<String> mfragmentTitleList = new ArrayList<>();

    public ViewPageAdapter(FragmentManager fm){
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