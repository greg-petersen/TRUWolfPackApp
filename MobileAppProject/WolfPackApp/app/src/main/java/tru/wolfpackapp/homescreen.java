package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        // TEST TO SEE IF ALL DATA IS PARSED CORRECTLY.
        /*
        getData("swimming.txt");
        getData("menbask.txt");
        getData("mensoc.txt");
        getData("menbaseball.txt");
        getData("menvol.txt");
        getData("wombask.txt");
        getData("womsoc.txt");
        getData("womvol.txt");*/

/*
        da = new dataAccess(this, "menbaseball.txt");
        test = da.readLine();
        Log.d("testset", "Start of while");
        while(test!=null){
            Log.d("testset", "READ: " + test);
            test = da.readLine();
        }
        Log.d("testset", "End of while");
        da.close();*/
    }
/*
    private void getData(String fileToOpen){
        Log.d("testest", this.toString());
        dataAccess da = new dataAccess(this, fileToOpen);
        String test = da.readLine();
        Log.d("testset", "Start of while: " + fileToOpen);
        // First line will always be format.
        String[] testSplit = test.split(",");

        String date, vs, location, time, result, meet;
        int numOfHeaders = -1;

        switch (testSplit.length){
            case 3:
                date = testSplit[0];
                location = testSplit[1];
                meet = testSplit[2];
                Log.d("testset", "Headers found: " + date + " " + location + " " + meet);

                test = da.readLine();
                while(test!=null){
                    Log.d("testset", "READ: " + test);
                    testSplit = test.split(",");
                    Log.d("testset", "Date: " + testSplit[0]);
                    Log.d("testset", "Location: " + testSplit[1]);
                    Log.d("testset", "Meet: " + testSplit[2]);
                    Log.d("testset", "*******************************************************");

                    test = da.readLine();
                }
                Log.d("testset", "End of while");
                da.close();
                break;
            case 5:
                String [] headers = testSplit;
                Log.d("testset", "Headers found: " + headers[0] + " " + headers[1] + " " + headers[2] + " " + headers[3] + " " + headers[4]);

                test = da.readLine();
                while(test!=null){
                    Log.d("testset", "READ: " + test);
                    testSplit = test.split(",");
                    for(int x = 0; x<testSplit.length; x++)
                        Log.d("testset", headers[x] + ": " + testSplit[x]);
                    Log.d("testset", "*******************************************************");

                    test = da.readLine();
                }
                Log.d("testset", "End of while");
                da.close();
                break;
            default:
                Log.d("testset", "How did we get here?");
                break;
        }
    }*/
}
