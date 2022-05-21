package ru.vik.secondslotsproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class WheelActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView creditsViewText, betViewText, winViewText;
    public ImageView image1, image2, image3;
    public Wheel wheel1, wheel2, wheel3;
    private Button spinWheelButton, bet100Button, bet500Button, bet1000Button, newGameButton;
    private boolean isStarted = false;
    public static int creditsInt = 1000, betInt = 50, winInt = betInt*10;
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

        spinWheelButton = findViewById(R.id.spinWheelButton);
        bet100Button = findViewById(R.id.bet100Button);
        bet500Button = findViewById(R.id.bet500Button);
        bet1000Button = findViewById(R.id.bet1000Button);
        newGameButton = findViewById(R.id.newGameButton);
        creditsViewText = findViewById(R.id.creditsViewText);
        creditsViewText.setText(Integer.toString(creditsInt));
        betViewText = findViewById(R.id.betViewText);
        betViewText.setText(Integer.toString(betInt));
        winViewText = findViewById(R.id.winViewText);
        winViewText.setText(Integer.toString(winInt));

        spinWheelButton.setOnClickListener(this);
        bet100Button.setOnClickListener(this);
        bet500Button.setOnClickListener(this);
        bet1000Button.setOnClickListener(this);
        newGameButton.setOnClickListener(this);
        newGameButton.setEnabled(false);
        if (creditsInt<=0){
            newGameButton.setEnabled(true);
            spinWheelButton.setEnabled(false);
        }
        changeBet(50);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.bet100Button):
                changeBet(100);
                break;
            case (R.id.bet500Button):
                changeBet(500);
                break;
            case (R.id.bet1000Button):
                changeBet(1000);
                break;
            case (R.id.newGameButton):
                newGameSetter();
                break;
            case (R.id.spinWheelButton):
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
                        creditsInt += winInt;
                        creditsViewText.setText(Integer.toString(creditsInt));
                    }
                    else {
                        creditsInt -= betInt;
                        creditsViewText.setText(Integer.toString(creditsInt));
                    }
                    spinWheelButton.setText("Spin!");
                    isStarted = false;

                }
                else {
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

                    spinWheelButton.setText("Stop");
                    isStarted = true;
                }
                newGameChecker();
                break;
        }
    }

    private void changeBet(int bet){
        betInt = bet;
        winInt = betInt*10;
        betViewText.setText(Integer.toString(betInt));
        winViewText.setText(Integer.toString(winInt));
    }

    private void newGameChecker(){
        if(creditsInt <= 0){
            newGameButton.setEnabled(true);
            spinWheelButton.setEnabled(false);
        }
    }

    private void newGameSetter(){
        wheel1ind = 4;
        wheel2ind = 4;
        wheel3ind = 4;
        creditsInt = 1000;
        newGameButton.setEnabled(false);
        Intent i = new Intent( this , this.getClass() );
        finish();
        this.startActivity(i);
    }
}


