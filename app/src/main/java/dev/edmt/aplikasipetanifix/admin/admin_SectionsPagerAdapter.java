package dev.edmt.aplikasipetanifix.admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Windows on 2/25/2018.
 */

public class admin_SectionsPagerAdapter extends FragmentPagerAdapter {

    public admin_SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                admin_pageone pagee1 = new admin_pageone();
                return pagee1;

            case 1:
                admin_pagetwo pagee2 = new admin_pagetwo();
                return pagee2;

            case 2:
                admin_pagethree pagee3 = new admin_pagethree();
                return pagee3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Beranda";
            case 1:
                return "Profile";
            case 2:
                return "Chat";
            default:
                return null;
        }
    }

}
