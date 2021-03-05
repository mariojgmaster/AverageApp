package com.example.average;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String progress;
    TextView progressInView;
    EditText value1, value2, value3;
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide StatusBar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Starting Variables
        progress = "0";
        value1 = findViewById(R.id.edit_text_n1);
        value2 = findViewById(R.id.edit_text_n2);
        value3 = findViewById(R.id.edit_text_n3);
        progressInView = findViewById(R.id.text_view_progress);
        progress_bar = findViewById(R.id.progress_bar);

        // Setting ProgressBar
        setProgress(progress);
    }

    public void calculateAverage(View view) {
        try {
            // Updating Variables
            Double nota1 = Double.parseDouble(value1.getText().toString());
            Double nota2 = Double.parseDouble(value2.getText().toString());
            Double nota3 = Double.parseDouble(value3.getText().toString());
            if(nota1 > 100 || nota2 > 100 || nota3 > 100) {
                //Feedback Error
                errorMessage("Entre com valores de 0 à 100!");
            } else {
                // Main Flow
                String result = String.valueOf(Math.round((nota1+nota2+nota3)/3));
                progress = result;

                // Setting ProgressBar
                setProgress(progress);
            }
        } catch (Exception err) {
                // Obs.: err.getMessage() == "empty String"
            //Feedback Error
            errorMessage("Preencha os campos corretamente!");
        }
    }

    public void setProgress(String progress) {
        progress_bar.setProgress(Integer.parseInt(progress));
        progressInView.setText(progress+"%");
    }

    public void errorMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_LONG);
        toast.show();
    }
}