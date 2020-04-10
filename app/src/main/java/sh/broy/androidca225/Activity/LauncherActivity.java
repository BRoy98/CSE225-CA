package sh.broy.androidca225.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.broy.androidca225.R;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        final Button qp2 = findViewById(R.id.launch_p2);
        final Button qp4 = findViewById(R.id.launch_p4);
        final Button qp5 = findViewById(R.id.launch_p5);

        qp2.setOnClickListener(v -> {
            Intent i = new Intent(this,P2Activity.class);
            startActivity(i);
        });

        qp4.setOnClickListener(v -> {
            Intent i = new Intent(this, P4Activity.class);
            startActivity(i);
        });

        qp5.setOnClickListener(v->{
            Intent i = new Intent(this, P5Activity.class);
            startActivity(i);
        });
    }
}
