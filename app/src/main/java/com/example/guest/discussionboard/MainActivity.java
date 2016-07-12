package com.example.guest.discussionboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.button1) Button mButton1;
    @Bind(R.id.button2) Button mButton2;
    @Bind(R.id.button3) Button mButton3;
    @Bind(R.id.button4) Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v==mButton1){
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        } else if(v==mButton2){
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        } else if(v==mButton3){
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        }else if(v==mButton4){
            Intent intent = new Intent(MainActivity.this, NewPostActivity.class);
            startActivity(intent);
        }
    }
}
