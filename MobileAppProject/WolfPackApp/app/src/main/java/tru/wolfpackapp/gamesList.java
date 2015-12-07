package tru.wolfpackapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkhobbo on 12/6/2015.
 */
public class gamesList extends AppCompatActivity {
    private ArrayList games;
    private ArrayList<String[]> gameInfo;

    public final static String GAMEINFO = "tru.wolfpackapp.GAMEINFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameslist);

        Intent intent = getIntent();
        String filters[] = intent.getStringExtra(sportlist.FILTERS).split(",");
        String gender, sport;
        gender = filters[0];
        sport = filters[1];
        String file = "";
        String fileM = "";
        String fileF = "";
        games = new ArrayList();
        gameInfo = new ArrayList();

        // Special case for swimming:
        if(sport.equals("swimming")) {
            file = "swimming.txt";
            getData(file);
        }
        else{
            if(gender.equals("both"))
            {
                // Open both files.
                fileM = "men"+sport + ".txt";
                fileF = "wom"+sport + ".txt";
                Log.d("testest", fileM + " " + fileF);
                getData(fileM);
                getData(fileF);
            }
            else{
                file += gender + sport + ".txt";
                Log.d("testest", file);
                getData(file);
            }
        }
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData(String fileToOpen){
        try{
            //Log.d("testest", this.toString());
            dataAccess da = new dataAccess(this, fileToOpen);
            String test = da.readLine();
            //Log.d("testset", "Start of while: " + fileToOpen);
            // First line will always be format.
            String[] testSplit = test.split(",");
            String date, vs, location, time, result, meet;

            switch (testSplit.length){
                case 3:
                    date = testSplit[0];
                    location = testSplit[1];
                    meet = testSplit[2];
                    //Log.d("testset", "Headers found: " + date + " " + location + " " + meet);

                    test = da.readLine();
                    while(test!=null){
                        testSplit = test.split(",");
                        /*
                        Log.d("testset", "READ: " + test);
                        Log.d("testset", "Date: " + testSplit[0]);
                        Log.d("testset", "Location: " + testSplit[1]);
                        Log.d("testset", "Meet: " + testSplit[2]);
                        Log.d("testset", "*******************************************************");
                        */

                        games.add(testSplit[0]);
                        testSplit[0] = "DATE: " + testSplit[0];
                        testSplit[1] = "LOCATION: " + testSplit[1];
                        testSplit[2] = "MEET: " + testSplit[2];

                        gameInfo.add(testSplit);
                        test = da.readLine();
                    }
                    //Log.d("testset", "End of while");
                    da.close();
                    break;
                case 5:
                    String [] headers = testSplit;
                    //Log.d("testset", "Headers found: " + headers[0] + " " + headers[1] + " " + headers[2] + " " + headers[3] + " " + headers[4]);

                    test = da.readLine();
                    while(test!=null){
                        testSplit = test.split(",");
                        /*
                        Log.d("testset", "READ: " + test);
                        for(int x = 0; x<testSplit.length; x++)
                            Log.d("testset", headers[x] + ": " + testSplit[x]);
                        Log.d("testset", "*******************************************************");
                        */
                        games.add(testSplit[0]);

                        for(int x = 0; x<testSplit.length; x++)
                            testSplit[x] = headers[x] + ": " + testSplit[x];
                        gameInfo.add(testSplit);

                        test = da.readLine();
                    }
                    //Log.d("testset", "End of while");
                    da.close();
                    break;
                default:
                    Log.d("testest", "How did we get here?");
                    break;
            }
            displayData(games);
        }
        catch(Exception e){
            e.printStackTrace();
            Log.d("testest", e.toString());
        }
    }

    private void displayData(ArrayList list){
        ListView lv = ((ListView) findViewById(R.id.gamesList));
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
        lv.setOnItemClickListener(itemSelectHandler);
    }

    private AdapterView.OnItemClickListener itemSelectHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getApplicationContext(), gamedetails.class);
            String [] test = gameInfo.get(position);

            Log.d("testest", "" + test.length);

            for(int x = 0; x<test.length;x++)
                Log.d("testest", test[x]);

            intent.putExtra(GAMEINFO, test);
            startActivity(intent);
        }
    };
}
