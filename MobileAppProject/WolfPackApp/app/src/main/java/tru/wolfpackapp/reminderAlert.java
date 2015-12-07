package tru.wolfpackapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Darkhobbo on 12/7/2015.
 */
public class reminderAlert extends BroadcastReceiver{

    private static final String APPDATA = "tru.wolfpackapp";

    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Game Reminder", Toast.LENGTH_LONG).show();

        String reminderToRemove = intent.getStringExtra("reminder");

        SharedPreferences sp = context.getSharedPreferences(APPDATA, context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        Set<String> reminderSet = sp.getStringSet("REMINDERS", new HashSet<String>());
        String[] remArray = reminderSet.toArray(new String[reminderSet.size()]);
        Set<String> newReminderSet = new HashSet<>();

        for(int x = 0; x<remArray.length; x++)
        {
            Log.d("testest", remArray[x] + " COMPARED TO " + reminderToRemove);

            if(!remArray[x].equals(reminderToRemove))
                newReminderSet.add(remArray[x]);
        }


        edit.putStringSet("REMINDERS", newReminderSet);
        edit.commit();

        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}
