package com.example.androidlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button pressMeButton;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        // Initialize views
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        pressMeButton = findViewById(R.id.button2);
        checkBox = findViewById(R.id.checkBox);

        // Set onClickListener for "Press Me" button
        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current text from EditText
                String inputText = editText.getText().toString();

                // Set the text to the TextView
                textView.setText(inputText);

                // Create and show a localized Toast message
                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        // Set OnCheckedChangeListener for CheckBox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = "The checkbox is now " + (isChecked ? "on" : "off");

            // Show Snackbar with Undo action
            Snackbar.make(buttonView, message, Snackbar.LENGTH_LONG)
                    .setAction("Undo", click -> {
                        // Undo action to revert checkbox state
                        checkBox.setChecked(!isChecked);
                    })
                    .show();
        });
    }
}
