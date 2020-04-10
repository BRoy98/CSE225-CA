package sh.broy.androidca225.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import sh.broy.androidca225.Adapter.ColorAdapter;
import sh.broy.androidca225.Listener.ColorChanger;
import sh.broy.androidca225.Fragment.ShowThemeFragment;
import com.broy.androidca225.R;
import com.google.android.material.tabs.TabLayout;

public class P2Activity extends AppCompatActivity
        implements ColorChanger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);

        ColorAdapter adapter = new ColorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void changeColor(final String title, final String color) {
        ShowThemeFragment showThemeFragment = (ShowThemeFragment) getSupportFragmentManager().getFragments().get(1);
        showThemeFragment.setTheme(title, color);
    }
}
