package sh.broy.androidca225.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.TextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.broy.androidca225.R;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowThemeFragment extends Fragment {

    private View root;
    private TextView colorTitle;

    public ShowThemeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_show_color, container, false);
        colorTitle = root.findViewById(R.id.colorTitle);

        SharedPreferences preferences = Objects.requireNonNull(getActivity())
                .getSharedPreferences("theme", Context.MODE_PRIVATE);

        String theme_color = preferences.getString("theme_color", "#ffffff");
        String theme_title = preferences.getString("theme_title", "My Color");
        root.setBackgroundColor(Color.parseColor(theme_color));
        colorTitle.setText(theme_title);
        return root;
    }

    public void setTheme(String title, String theme) {
        root.setBackgroundColor(Color.parseColor(theme));
        colorTitle.setText((title));
    }
}
