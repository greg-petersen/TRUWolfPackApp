package tru.wolfpackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class homescreen extends AppCompatActivity {

    private static final String APPDATA = "tru.wolfpackapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        SharedPreferences sp = getSharedPreferences(APPDATA, MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("NumOfRem", 234324243);
        edit.commit();


        Button sportEventsButton = (Button) findViewById(R.id.sportEventsButton);
        Button currentSeasonButton = (Button) findViewById(R.id.currentRemindersButton);
        Button calenderButton = (Button) findViewById(R.id.calenderButton);
        ImageButton settingButton = (ImageButton) findViewById(R.id.settingButton);

        sportEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentMaleFemaleBoth = new Intent(getApplicationContext(), malefemaleboth.class);
                startActivity(intentMaleFemaleBoth);
            }
        });

        currentSeasonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentCurrentSeason = new Intent(getApplicationContext(), currentreminders.class);
                startActivity(intentCurrentSeason);
            }
        });

        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentCalendar = new Intent(getApplicationContext(), calendar.class);
                startActivity(intentCalendar);
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentSettings = new Intent(getApplicationContext(), settings.class);
                startActivity(intentSettings);
            }
        });
    }
}
