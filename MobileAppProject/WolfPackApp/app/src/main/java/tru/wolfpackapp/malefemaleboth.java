package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class malefemaleboth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malefemaleboth);

        Button maleButton = (Button) findViewById(R.id.maleButton);
        Button femaleButton = (Button) findViewById(R.id.femaleButton);
        Button bothButton = (Button) findViewById(R.id.bothButton);

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), sportlist.class);
                intent.putExtra("filters", "men");
                startActivity(intent);
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), sportlist.class);
                intent.putExtra("filters", "wom");
                startActivity(intent);
            }
        });

        bothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), sportlist.class);
                intent.putExtra("filters", "both");
                startActivity(intent);
            }
        });
    }
}
