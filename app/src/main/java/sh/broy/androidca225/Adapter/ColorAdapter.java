package sh.broy.androidca225.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import sh.broy.androidca225.Fragment.ChooseThemeFragment;
import sh.broy.androidca225.Fragment.ShowThemeFragment;

public class ColorAdapter extends FragmentStatePagerAdapter {

    public ColorAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment currentFragment = null;

        switch (i) {
            case 0:
                currentFragment = new ChooseThemeFragment();
                break;
            case 1:
                currentFragment = new ShowThemeFragment();
                break;

        }

        assert currentFragment != null;
        return currentFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Choose Theme";
        }
        return "Check Theme";
    }
}
