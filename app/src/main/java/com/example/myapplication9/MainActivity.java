package com.example.myapplication9;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
    private int n6;
    private EditText name;
    private int rightG = 0;
    private int counter=0;
    private Button score,exit;
    private Button yesbtn,nobtn;
    private Handler handler;
    private Runnable runnable;
    private AlertDialog dialog;

    private void alertDial0g(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Are you sure");
        alertDialog.setCancelable(true);
        alertDialog.setIcon(R.drawable.alert);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
                dialogInterface.dismiss();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        dialog = alertDialog.create();
    }


    private void startSpinning() {
        handler.post(runnable);
    }

    private void stopSpinning () {
        handler.removeCallbacks(runnable);
    }


    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDial0g();

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
        score = findViewById(R.id.button4);
        name=findViewById(R.id.editTextText);
        exit=findViewById(R.id.button3);
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
        Intent intent = new  Intent (this,yourScore.class);
        Dialog dialog1 = new Dialog(this);
        dialog.setContentView(R.layout.my_dialog);


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
                if(counter<6)
                    counter+=1;
                if(counter==6){
                    btnStaSto.setEnabled(false);
                    if(btnStaSto.getText().toString().equals("start")){
                    btnStaSto.setText("stop");
                    startSpinning();
                }}else {
                    btnStaSto.setText("start");
                    stopSpinning();
                }
                if(n6==n[0]){
                    rightG++;
                    rightGuesses.setText("right guesses :"+String.valueOf(rightG));
                    a1.setBackgroundColor(Color.RED);
                }
                if(n6==n[1]){
                    rightG++;
                    rightGuesses.setText("right guesses :"+String.valueOf(rightG));
                    a2.setBackgroundColor(Color.RED);
                }
                if(n6==n[2]){
                    rightG++;
                    rightGuesses.setText("right guesses :"+String.valueOf(rightG));
                    a3.setBackgroundColor(Color.RED);
                }
                if(n6==n[3]){
                    rightG++;
                    rightGuesses.setText("right guesses :"+String.valueOf(rightG));
                    a4.setBackgroundColor(Color.RED);
                }
                if(n6==n[4]){
                    rightG++;
                    rightGuesses.setText("right guesses :"+String.valueOf(rightG));
                    a5.setBackgroundColor(Color.RED);
                }
            }
        });


            newGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnStaSto.setEnabled(true);
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
                    rightGuesses.setText("right guesses : "+String.valueOf(0));
                    a4.setBackgroundColor(Color.WHITE);
                    a1.setBackgroundColor(Color.WHITE);
                    a5.setBackgroundColor(Color.WHITE);
                    a2.setBackgroundColor(Color.WHITE);
                    a3.setBackgroundColor(Color.WHITE);
                }
            });
            score.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("SCORE", rightG);
                    intent.putExtra("NAME", name.getText().toString());
                    startActivity(intent);
                    finish();
                }
            });

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.show();
                }
            });
        }
    }
