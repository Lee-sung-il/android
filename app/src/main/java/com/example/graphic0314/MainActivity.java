package com.example.graphic0314;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.internal.BaselineLayout;

public class MainActivity extends AppCompatActivity {
    public static final  int LINE = 1, CIRCLE = 2, FREE_LINE =3;
    int curShape = LINE;

    public int getCurShape() {
        return curShape;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "그림 그리기");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case LINE:
                curShape = LINE;
                Toast.makeText(this, "선 그리기", Toast.LENGTH_SHORT).show();
                break;
            case CIRCLE:
                curShape = CIRCLE;
                Toast.makeText(this, "원 그리기", Toast.LENGTH_SHORT).show();
                break;
            case FREE_LINE:
                curShape = FREE_LINE;
                Toast.makeText(this, "그림 그리기", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

}