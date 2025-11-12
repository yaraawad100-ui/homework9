package com.example.myapplication9;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView a1;
    private TextView a2;
    private TextView a3;
    private TextView a4;
    private TextView a5;
    private TextView a6;
    private TextView rightGuesses;
    private Button btnStaSto;
    private Button newGame;
    private int[] n;
    private int n6, rightG = 0;
    private Handler handler;
    private Runnable runnable;

    private void startSpinning() {
        handler.post(runnable);
    }

    private void stopSpinning () {
        handler.removeCallbacks(runnable);
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = new int[5];
        a1 = findViewById(R.id.textView);
        a2 = findViewById(R.id.textView2);
        a3 = findViewById(R.id.textView3);
        a4 = findViewById(R.id.textView4);
        a5 = findViewById(R.id.textView5);
        a6 = findViewById(R.id.textView6);
        rightGuesses= findViewById(R.id.textView8);
        btnStaSto = findViewById(R.id.button);
        newGame = findViewById(R.id.button2);
        //*************************************
        n[0]= (int) (Math.random() * ((39 - 3 + 1) + 3));
        n[1]= (int) (Math.random() * ((39 - 3 + 1) + 3));
        n[2]= (int) (Math.random() * ((39 - 3 + 1) + 3));
        n[3]= (int) (Math.random() * ((39 - 3 + 1) + 3));
        n[4]= (int) (Math.random() * ((39 - 3 + 1) + 3));
        a1.setText(String.valueOf(n[0]));
        a2.setText(String.valueOf(n[1]));
        a3.setText(String.valueOf(n[2]));
        a4.setText(String.valueOf(n[3]));
        a5.setText(String.valueOf(n[4]));
        handler = new Handler(Looper.getMainLooper());

        runnable = new Runnable() {
            @Override
            public void run() {
                n6=(int)(Math.random()*(39-3+1)+3);
                a6.setText(n6 + "");
                handler.postDelayed(runnable, 100);
            }
        };

        btnStaSto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnStaSto.getText().toString().equals("start")){
                    btnStaSto.setText("stop");
                    startSpinning();
                } else {
                    btnStaSto.setText("start");
                    stopSpinning();
                }

            }
        });

        for (int j : n) {
            if (j == n6) {
                rightG++;
                rightGuesses.setText("right guesses : " + rightG);
            }
        }
        if(rightG==5){
            newGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a1.setText(0);
                    a2.setText(0);
                    a3.setText(0);
                    a4.setText(0);
                    a5.setText(0);
                    n6=0;
                    rightGuesses.setText("right guesses :0");
                }
            });
        }
    }
}