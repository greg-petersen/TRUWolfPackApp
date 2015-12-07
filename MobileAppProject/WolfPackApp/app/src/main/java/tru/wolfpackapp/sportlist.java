package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class sportlist extends AppCompatActivity {

    public final static String FILTERS = "tru.wolfpackapp.FILTERS";
    private String genderFilter;
    private String[] maleSports = {"Basketball", "Soccer", "Volleyball", "Swimming", "Baseball"};
    private String[] femaleSports = {"Basketball", "Soccer", "Volleyball", "Swimming"};
    private String[] allSports = {"Basketball", "Soccer", "Volleyball", "Swimming", "Baseball"};
    private String[] sports = {"bask", "soc", "vol", "swimming", "baseball"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sportslist);
        Intent intent = getIntent();
        genderFilter = intent.getStringExtra(malefemaleboth.FILTERS);
        Log.d("testest", "Filter: " + genderFilter);
        ListView lv = (ListView)findViewById(R.id.sportsList);
        ArrayAdapter<String> sportsAdapter;

        switch(genderFilter){
            case "men":
                sportsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, maleSports);
                // List male sports.
                break;
            case "wom":
                sportsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, femaleSports);
                // List female sports.
                break;
            case "both":
            default:
                sportsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allSports);
                // List all sports.
                Log.d("testest", "How did we get here?");
                break;
        }
        lv.setAdapter(sportsAdapter);
        lv.setOnItemClickListener(itemSelectHandler);

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private AdapterView.OnItemClickListener itemSelectHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("testest", "Item clicked: " + sports[position]);
            Intent intent = new Intent(getApplicationContext(), gamesList.class);
            intent.putExtra(FILTERS, genderFilter+","+sports[position]);
            startActivity(intent);
        }
    };

}

