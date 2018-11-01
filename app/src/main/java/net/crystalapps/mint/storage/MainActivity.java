package net.crystalapps.mint.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.crystalapps.mint.storage.library.core.Storage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSaved;
    private EditText etSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(this);
        tvSaved = findViewById(R.id.tvSaved);
        etSaved = findViewById(R.id.etSaved);

        showSavedText();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                Storage.put("my_key", etSaved.getText().toString());
                showSavedText();
                break;
        }
    }

    private void showSavedText() {
        String text = Storage.getString("my_key");
        tvSaved.setText(text == null ? "Hello World!" : text);
    }
}