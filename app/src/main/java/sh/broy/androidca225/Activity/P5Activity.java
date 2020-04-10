package sh.broy.androidca225.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.broy.androidca225.R;
import sh.broy.androidca225.Fragment.DataPass1Fragment;
import sh.broy.androidca225.Fragment.DataPass2Fragment;
import sh.broy.androidca225.Listener.FragmentDataSender;

public class P5Activity extends AppCompatActivity implements FragmentDataSender {

    private DataPass1Fragment dataFragment1;
    private DataPass2Fragment dataFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);

        dataFragment1 = (DataPass1Fragment) getSupportFragmentManager().findFragmentById(R.id.dataFragment1);
        dataFragment2 = (DataPass2Fragment) getSupportFragmentManager().findFragmentById(R.id.dataFragment2);

    }

    @Override
    public void sendMessage(final int index, final String data) {
        switch (index) {
            case 1:
                dataFragment1.updateData(data);
                break;
            case 2:
                dataFragment2.updateData(data);
                break;
        }
    }
}
