package eotcatcitmofrhoodiniilabs.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView tac;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tac=findViewById(R.id.textView2);

        animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.tac);
        tac.startAnimation(animation);

        //hide ActionBar
        getSupportActionBar().hide();

        //to hide the statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    //to attach the splash fragment inside the activity
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();

    }
}
