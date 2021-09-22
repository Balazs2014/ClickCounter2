package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Button btnPlus;
    private Button btnMinus;
    private TextView clickCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickCount = findViewById(R.id.clickCount);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);

        reset();
        countPlus();
        countMinus();
    }

    private void countMinus() {
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                clickCount.setText(Integer.toString(count));
                colorChange();
            }
        });
    }

    private void countPlus() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                clickCount.setText(Integer.toString(count));
                colorChange();
            }
        });
    }


    private void reset() {
        clickCount.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                count = 0;
                clickCount.setText(Integer.toString(count));
                colorChange();
                return true;
            }
        });
    }
    private void colorChange() {
        if (count == 0) {
            clickCount.setTextColor(Color.parseColor("#FF0027FF"));
        }
        if (count < 0) {
            clickCount.setTextColor(Color.parseColor("#FFFF0000"));
        }
        if (count > 0) {
            clickCount.setTextColor(Color.parseColor("#FF00FF0A"));
        }
    }
}
