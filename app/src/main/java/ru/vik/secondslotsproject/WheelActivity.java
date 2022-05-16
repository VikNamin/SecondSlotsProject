package ru.vik.secondslotsproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class WheelActivity extends AppCompatActivity {

    private TextView scoreTextView;
    public ImageView image1, image2, image3;
    public Wheel wheel1, wheel2, wheel3;
    private Button button;
    private boolean isStarted = false;
    public static int scoreInt = 0;
    public static int wheel1ind = 4, wheel2ind = 4, wheel3ind = 4;
    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wheel_activity);

        image1 = findViewById(R.id.image1);
        image1.setImageResource(wheel1.drawables[wheel1ind]);
        image2 = findViewById(R.id.image2);
        image2.setImageResource(wheel2.drawables[wheel2ind]);
        image3 = findViewById(R.id.image3);
        image3.setImageResource(wheel3.drawables[wheel3ind]);

        button = findViewById(R.id.startWheelButton);
        scoreTextView = findViewById(R.id.scoreText);
        scoreTextView.setText("Score: " + scoreInt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStarted) {
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();

                    wheel1ind = wheel1.currentIndex + 1;
                    wheel2ind = wheel2.currentIndex + 1;
                    wheel3ind = wheel3.currentIndex + 1;

                    switch (wheel1ind){
                        case (6) : wheel1ind = 0;
                    }
                    switch (wheel2ind){
                        case (6) : wheel2ind = 0;
                    }
                    switch (wheel3ind){
                        case (6) : wheel3ind = 0;
                    }

                    if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                        scoreInt+=1000;
                        scoreTextView.setText("Score: " + scoreInt);
                    }
                    else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                            || wheel1.currentIndex == wheel3.currentIndex) {
                        scoreInt+=100;
                        scoreTextView.setText("Score: " + scoreInt);
                    }
                    else {
                        scoreTextView.setText("Score: " + scoreInt);
                    }

                    button.setText("Start");
                    isStarted = false;

                } else {

                    wheel1 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image1.setImageResource(img);
                                }
                            });
                        }
                    }, 100, randomLong(0, 300));
                    wheel1.start();

                    wheel2 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image2.setImageResource(img);
                                }
                            });
                        }
                    }, 100, randomLong(150, 700));
                    wheel2.start();

                    wheel3 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image3.setImageResource(img);
                                }
                            });
                        }
                    }, 100, randomLong(400, 900));
                    wheel3.start();

                    button.setText("Stop");
                    isStarted = true;
                }
            }
        });
    }
}


