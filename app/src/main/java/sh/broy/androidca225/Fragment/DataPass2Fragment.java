package sh.broy.androidca225.Fragment;

import android.content.Context;
import android.os.Bundle;

import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.broy.androidca225.R;
import sh.broy.androidca225.Listener.FragmentDataSender;

public class DataPass2Fragment extends Fragment {

    private FragmentDataSender mDataSender;
    private TextView receiveText;

    public DataPass2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_data_pass_2, container, false);
        final EditText sendText = root.findViewById(R.id.sendText);
        receiveText = root.findViewById(R.id.receiveText);
        Button sendData = root.findViewById(R.id.sendData);

        sendData.setOnClickListener(v -> {
            String input = sendText.getText().toString();
            mDataSender.sendMessage(1, input);
            sendText.setText("");
        });
        return root;
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);
        mDataSender = (FragmentDataSender) context;
    }

    public void updateData(String text) {
        receiveText.setText(text);
    }
}
