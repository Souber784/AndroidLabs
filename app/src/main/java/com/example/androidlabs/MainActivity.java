package com.example.androidlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button pressMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        // Initialize the views
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.textView);
        pressMeButton = findViewById(R.id.button2);

        // Set the onClickListener for the button
        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current text from the EditText
                String inputText = editText.getText().toString();

                // Set the text to the TextView
                textView.setText(inputText);

                // Create and show a localized Toast message
                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}