package es.udc.psi.citizen.view.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import es.udc.psi.citizen.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.city_tab_text_1, R.string.city_tab_text_2, R.string.city_tab_text_3, R.string.city_tab_text_4};
    private final Context mContext;
    private int gameId, cityId;

    public SectionsPagerAdapter(Context context, FragmentManager fm, int gameId, int cityId) {
        super(fm);
        mContext = context;
        this.gameId = gameId;
        this.cityId = cityId;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return ResumeCityFragment.newInstance(gameId, cityId);
            case 1:
                return PlaceholderFragment.newInstance(-1);
            default:
                return PlaceholderFragment.newInstance(position +1);
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}