package com.example.dam.ciclodevida;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private String msg = "";
    private TextView tvScore;
    private EditText etMsg;
    private TextView tvMsg;
    private Button btIncr;
    private Button btMostrar;
    final static String TAG = "MITAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScore = (TextView) findViewById(R.id.tvScore);
        btIncr = (Button) findViewById(R.id.btIncr);
        etMsg = (EditText) findViewById(R.id.etMsg);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        btMostrar = (Button) findViewById(R.id.btMostrar);

        tvScore.setText(String.valueOf(score));

        btIncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                tvScore.setText(String.valueOf(score));
            }
        });

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = msg + " " + etMsg.getText().toString();
                tvMsg.setText(msg);
                etMsg.setText("");
            }
        });

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String s = tvScore.getText().toString();
        outState.putString("score", String.valueOf(s));

        String r = tvMsg.getText().toString();
        outState.putString("msg", String.valueOf(r));
        tvMsg.setText("");

        Log.d(TAG, "onSaveInstanteState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String s = savedInstanceState.get("score").toString();
        score = Integer.valueOf(s);
        tvScore.setText(String.valueOf(s));

        String r = savedInstanceState.get("msg").toString();
        msg = r;
        tvMsg.setText(r);

        Log.d(TAG, "onRestoreInstanteState");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.d(TAG, "onDestroy");
    }
}
