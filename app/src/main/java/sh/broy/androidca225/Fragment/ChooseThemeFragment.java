package sh.broy.androidca225.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.broy.androidca225.R;
import java.util.ArrayList;
import java.util.Objects;
import sh.broy.androidca225.Listener.ColorChanger;
import sh.broy.androidca225.Model.ThemeModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseThemeFragment extends Fragment {

    private ArrayList<ThemeModel> themeList;

    private ColorChanger mColorChanger;

    public ChooseThemeFragment() {
        // Required empty public constructor
    }

    private ArrayList<ThemeModel> createTheme() {
        ArrayList<ThemeModel> themeList = new ArrayList<ThemeModel>();
        themeList.add(new ThemeModel("Air Force", "#5d8aa8"));
        themeList.add(new ThemeModel("American Rose", "#ff033e"));
        themeList.add(new ThemeModel("Almond", "#efdecd"));
        themeList.add(new ThemeModel("Amaranath", "#e52b50"));
        themeList.add(new ThemeModel("Amber", "#ffbf00"));
        themeList.add(new ThemeModel("Amethyst", "#9966cc"));
        themeList.add(new ThemeModel("Android Green", "#a4c639"));
        themeList.add(new ThemeModel("Apricot", "#fbceb1"));
        themeList.add(new ThemeModel("Ash Gray", "#b2beb5"));
        themeList.add(new ThemeModel("Atomic tangerine", "#ff9966"));

        return themeList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_choose_theme, container, false);

        themeList = createTheme();

        SharedPreferences preferences = Objects.requireNonNull(this.getActivity())
                .getSharedPreferences("theme", Context.MODE_PRIVATE);
        String theme_title = preferences.getString("theme_title", "My Color");

        final RadioGroup themeGroup = root.findViewById(R.id.themeGroup);

        themeGroup.removeAllViews();
        themeGroup.removeAllViewsInLayout();

        for (int i = 0; i < themeList.size(); i++) {
            float scale = getResources().getDisplayMetrics().density;
            int paddingTB = (int) (15 * scale + 0.5f);
            int paddingSide = (int) (10 * scale + 0.5f);

            RadioButton radioButtonView = new RadioButton(getActivity());
            radioButtonView.setPadding(paddingSide, paddingTB, paddingSide, paddingTB);
            radioButtonView.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.MATCH_PARENT));
            radioButtonView.setText(themeList.get(i).getTitle());
            themeGroup.addView(radioButtonView);

            if (theme_title.equals(themeList.get(i).getTitle())) {
                radioButtonView.setChecked(true);
            }
        }

        themeGroup.setOnCheckedChangeListener((group, checkedId) -> {

            Log.e("CHOSE THEME", String.valueOf(checkedId));

            /*
            KIND OF HACK TO FIX ARRAY INDEX OUT OF BOUND ISSUE

            ISSUE: checkedId multiplies by 10 every time the fragment is reloaded
            this will make the index stay in between 1-10
            */
            int curIndex = 0;
            if (checkedId > 10) {
                if ((checkedId % 10) != 0) {
                    curIndex = checkedId % 10;
                } else {
                    curIndex = 10;
                }
            } else {
                curIndex = checkedId;
            }

            Log.e("curIndex", String.valueOf(curIndex));

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("theme_title", themeList.get(curIndex - 1).getTitle());
            editor.putString("theme_color", themeList.get(curIndex - 1).getColor());
            mColorChanger
                    .changeColor(themeList.get(curIndex - 1).getTitle(), themeList.get(curIndex - 1).getColor());
            editor.apply();
        });
        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mColorChanger = (ColorChanger) context;
    }
}
