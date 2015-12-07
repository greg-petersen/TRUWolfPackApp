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
    private ArrayList<eventObj> gameInfo;
    private String gender, sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameslist);

        Intent intent = getIntent();
        String filters[] = intent.getStringExtra("filters").split(",");
        gender = filters[0];
        sport = filters[1];
        String file = "";
        String fileM = "";
        String fileF = "";
        games = new ArrayList();
        gameInfo = new ArrayList();

        int genderInt = -1;
        switch(gender){
            case "men": genderInt = 0;
                break;
            case "wom": genderInt = 1;
                break;
            default:
                Log.d("testest", "Gender error.");
                break;
        }

        // Special case for swimming:
        if(sport.equals("swimming")) {
            file = "swimming.txt";
            getData(file, genderInt, sport);
        }
        else{
            if(gender.equals("both"))
            {
                // Open both files.
                fileM = "men"+sport + ".txt";
                fileF = "wom"+sport + ".txt";
                Log.d("testest", fileM + " " + fileF);
                getData(fileM, genderInt, sport);
                getData(fileF, genderInt, sport);
            }
            else{
                file += gender + sport + ".txt";
                Log.d("testest", file);
                getData(file, genderInt, sport);
            }
        }
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData(String fileToOpen, int thisGender, String thisSport){
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
                    test = da.readLine();
                    while(test!=null){
                        testSplit = test.split(",");

                        //Log.d("testset", "READ: " + test);
                       // Log.d("testset", "Date: " + testSplit[0]);
                        //Log.d("testset", "Location: " + testSplit[1]);
                     //   Log.d("testset", "Meet: " + testSplit[2]);
                      //  Log.d("testset", "*******************************************************");
                        games.add(testSplit[0]);
                        gameInfo.add(new eventObj(testSplit, thisSport, thisGender));
                        test = da.readLine();
                    }
                    da.close();
                    break;
                case 5:
                    String [] headers = testSplit;

                    test = da.readLine();
                    while(test!=null){
                        testSplit = test.split(",");

                       // Log.d("testset", "READ: " + test);
                       // for(int x = 0; x<testSplit.length; x++)
                       //     Log.d("testset", headers[x] + ": " + testSplit[x]);
                       // Log.d("testset", "*******************************************************");
                        games.add(testSplit[0]);
                        gameInfo.add(new eventObj(testSplit, thisSport, thisGender));
                        test = da.readLine();
                    }
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
            eventObj obj = gameInfo.get(position);

            intent.putExtra("gameinfo", obj.toString());
            startActivity(intent);
        }
    };
}
