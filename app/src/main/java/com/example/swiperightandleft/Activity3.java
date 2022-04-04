package com.example.swiperightandleft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Activity3 extends AppCompatActivity {
    LinearLayout linearLayout;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        linearLayout = findViewById(R.id.act_3);
        swipeListener = new SwipeListener(linearLayout);
    }

    private class SwipeListener implements View.OnTouchListener {
        GestureDetector gestureDetector;

        SwipeListener(View view)
        {
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                public boolean onDown(MotionEvent e) { return true; }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    float xDiff = e2.getX() - e1.getX();
                    float yDiff = e2.getY() - e2.getY();
                    try{
                        if (Math.abs(xDiff) > Math.abs(yDiff))
                        {
                            if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold)
                            {
                                if (xDiff > 0)
                                {
                                    Intent intent = new Intent(Activity3.this, Activity2.class);
                                    startActivity(intent);
                                }
                                return true;
                            }
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    return false;
                }
            };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }
}
