package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        Button sportEventsButton = (Button) findViewById(R.id.sportEventsButton);
        Button currentSeasonButton = (Button) findViewById(R.id.currentSeasonButton);
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
                Intent intentCurrentSeason = new Intent(getApplicationContext(), currentseason.class);
                startActivity(intentCurrentSeason);
            }
        });

        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentCalender = new Intent(getApplicationContext(), calender.class);
                startActivity(intentCalender);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splashscreen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
