package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{//monkey hello change
    Button go_next;//initializing the only button on the screen so far

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_next = (Button) findViewById(R.id.Cleck_my_flow);//initializing the go net button
        go_next.setOnClickListener(goNext);//setting the onclick listener
    }
    private View.OnClickListener goNext = new View.OnClickListener()//function to call the next activity
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent (v.getContext(), splashscreen.class);
            startActivity(intent);
        }
    };//i stopped here, just following our graphical flow from the draw.io

    //this is java generated code below
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//hey
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
