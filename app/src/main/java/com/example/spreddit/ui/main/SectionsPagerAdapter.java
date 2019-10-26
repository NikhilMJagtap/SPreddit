//package com.example.spreddit.ui.main;
//
//import android.content.Context;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.StringRes;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import com.example.spreddit.home_fragment;
//import com.example.spreddit.R;
//
///**
// * A [FragmentPagerAdapter] that returns a fragment corresponding to
// * one of the sections/tabs/pages.
// */
//public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//    int COUNT = 5;
//
//    private static final String[] TAB_TITLES = new String[]{"Tab 1", "Tab 2", "Tab 3", "Tab 4", "Tab 5"};
//    private final Context mContext;
//
//    public SectionsPagerAdapter(Context context, FragmentManager fm) {
//        super(fm);
//        mContext = context;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment (defined as a static inner class below).
//        return home_fragment.newInstance(position + 1);
//    }
//
//    @Nullable
//    @Override
//    public String getPageTitle(int position) {
//        return null;
//    }
//
//    @Override
//    public int getCount() {
//        // Show 2 total pages.
//        return COUNT;
//    }
//}