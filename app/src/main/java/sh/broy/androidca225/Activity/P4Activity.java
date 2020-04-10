package sh.broy.androidca225.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.broy.androidca225.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4Activity extends AppCompatActivity {
    private EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);

        editContent = findViewById(R.id.EditContent);
        final Button readStorage = findViewById(R.id.readStorage);
        final Button writeStorage = findViewById(R.id.writeStorage);

        readStorage.setOnClickListener(v -> readFromStorage());
        writeStorage.setOnClickListener(v -> writeToStorage());


    }

    private void readFromStorage() {
        try {
            FileInputStream fileInputStream  =  this.openFileInput("cse225");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            final StringBuilder stringBuilder = new StringBuilder();
            final BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line!=null){
                stringBuilder.append(line).append('\n');
                line = bufferedReader.readLine();
            }
            String content = stringBuilder.toString();
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeToStorage(){
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = this.openFileOutput("cse225",MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(this.editContent.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, "Data Written to Storage", Toast.LENGTH_SHORT).show();
            this.editContent.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
