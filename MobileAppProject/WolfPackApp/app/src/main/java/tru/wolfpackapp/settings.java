package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        ImageButton alarm_on = (ImageButton) findViewById(R.id.alarm_on);
        ImageButton alarm_off = (ImageButton) findViewById(R.id.alarm_off);
        ImageButton youtube_demo = (ImageButton) findViewById(R.id.youtube_demo);

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent_youtube_demo = new Intent(getApplicationContext(), youtube_demo.class);
                startActivity(intent_youtube_demo);
            }
        });


        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentMaleFemaleBoth = new Intent(getApplicationContext(), youtube_demo.class);
                startActivity(intentMaleFemaleBoth);
            }
        }); */

        youtube_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent demo = new Intent(getApplicationContext(), youtube_demo.class);
                startActivity(demo);
            }
        });
    }
}