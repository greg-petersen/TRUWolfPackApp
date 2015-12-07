package tru.wolfpackapp;

import java.util.Date;

/**
 * Created by Darkhobbo on 12/6/2015.
 */
public class eventObj {
    private Date date;
    private String versus;
    private String location;
    private String eventName;
    private String result;

    // Default Constructor
    public eventObj(){
        this.date = new Date();
        this.versus = "";
        this.location = "";
        this.eventName = "";
        this.result = "";
    }

    // 3 Parameter Constructor.
    public eventObj(Date newDate, String newVersus, String newLocation){
        this.date = newDate;
        this.versus = newVersus;
        this.location = newLocation;
        this.eventName = "";
        this.result = "";
    }

    // 4 Parameter Constructor.

    // 5 Parameter Constructor.


    // Mutators
    public void setDate(Date newDate){this.date=newDate;}
    public void setLocation(String newLocation){this.location=newLocation;}
    public void setEventName(String newEventName){this.eventName=newEventName;}
    public void setVersus(String newVersus){this.versus=newVersus;}
    public void setResult(String newResult){this.result=newResult;}

    // Accessors
    public Date getDate(){return this.date;}
    public String getLocation(){return this.location;}
    public String getEventName(){return this.eventName;}
    public String getVersus(){return this.versus;}
    public String getResult(){return this.result;}
}
