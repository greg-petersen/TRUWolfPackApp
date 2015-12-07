package tru.wolfpackapp;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.Serializable;

/**
 * Created by Darkhobbo on 12/6/2015.
 */
@SuppressWarnings("serial")
public class eventObj implements Serializable{
    private Date date;
    private String versus;
    private String location;
    private String eventName;
    private String result;
    private String time;
    private String sport;
    private int gender; // 0 = guy, 1 = girl

    // Default Constructor
    public eventObj(){
        this.date = new Date();
        this.versus = "";
        this.location = "";
        this.eventName = "";
        this.result = "";
        this.sport = "";
        this.gender = -1;
        this.time = "";
    }
    public eventObj(String[] data, String sport, int gen){
        this.sport = sport;
        this.gender = gen;

        String dateString;
        DateFormat format;
        Date newDate;

        switch(sport){
            case "swimming":
                // Date,Location,Meet
                try{
                    dateString = data[0];
                    format = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
                    newDate = format.parse(dateString);
                    // PARSE DATE HERE.
                    // DATE PARSING
                    this.date = newDate;
                    this.location = data[1];
                    this.eventName = data[2];
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                // Date,Vs,Location,Time,Result
                Log.d("testest", "Length: " + data.length);
                try{
                    switch (data.length){
                        case 1:
                        case 2:
                            dateString = data[0];
                            format = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
                            newDate = format.parse(dateString);
                            this.date = newDate;
                            this.versus = data[1];
                            this.location = "TBA";
                            this.time = "TBA";
                            this.result = "TBA";
                            break;
                        case 3:
                            dateString = data[0];
                            format = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
                            newDate = format.parse(dateString);
                            this.date = newDate;
                            this.versus = data[1];
                            this.location = data[2];
                            this.time = "TBA";
                            this.result = "TBA";
                            break;
                        case 4:
                            dateString = data[0];
                            format = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
                            newDate = format.parse(dateString);
                            // PARSE DATE HERE.
                            // DATE PARSING
                            this.date = newDate;
                            this.versus = data[1];
                            this.location = data[2];
                            this.time = data[3];
                            this.result = "TBA";
                            break;
                        case 5:
                            dateString = data[0];
                            format = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
                            newDate = format.parse(dateString);
                            // PARSE DATE HERE.
                            // DATE PARSING
                            this.date = newDate;
                            this.versus = data[1];
                            this.location = data[2];
                            this.time = data[3];
                            Log.d("data", "NULL: " + data[4]);
                            this.result = data[4];
                            break;
                        default:
                            break;
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    // Mutators
    public void setDate(Date newDate){this.date=newDate;}
    public void setLocation(String newLocation){this.location=newLocation;}
    public void setEventName(String newEventName){this.eventName=newEventName;}
    public void setVersus(String newVersus){this.versus=newVersus;}
    public void setResult(String newResult){this.result=newResult;}
    public void setTime(String newTime){this.time=newTime;}
    public void setSport(String newSport){this.sport=newSport;}
    public void setGender(int newGender){this.gender=newGender;}

    // Accessors
    public Date getDate(){return this.date;}
    public String getLocation(){return this.location;}
    public String getEventName(){return this.eventName;}
    public String getVersus(){return this.versus;}
    public String getResult(){return this.result;}
    public String getTime(){return this.time;}
    public String getSport(){return this.sport;}
    public int getGender(){return this.gender;}
}
