package com.example.myapplication9;

import android.app.backup.FileBackupHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class yourScore extends AppCompatActivity {
    TextView realScore;
    Button  backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_score);
        Intent mainAc = new Intent(yourScore.this,MainActivity.class);
      //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        int x=MainActivity.rightG;
        realScore = findViewById(R.id.textView9);
        realScore.setText(String.valueOf(x));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainAc);
            }
        });
    }
}